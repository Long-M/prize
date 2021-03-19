package com.ml.prize.api.service.impl;

import com.github.pagehelper.PageHelper;
import com.ml.prize.api.service.UserService;
import com.ml.prize.commons.entity.*;
import com.ml.prize.commons.enums.RedisKeyPrefixEnum;
import com.ml.prize.commons.mapper.UserGameMapper;
import com.ml.prize.commons.mapper.UserMapper;
import com.ml.prize.commons.mapper.ViewUserHitMapper;
import com.ml.prize.commons.util.PasswordUtils;
import com.ml.prize.commons.util.RedisUtils;
import com.ml.prize.commons.vo.PageBean;
import com.ml.prize.commons.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

/**
 * @author Mr.ml
 * @date 2021/3/18
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private ViewUserHitMapper viewUserHitMapper;
    @Resource
    private UserGameMapper userGameMapper;
    @Resource
    private RedisUtils redisUtils;

    @Override
    public ResultVO login(HttpServletRequest httpServletRequest, String username, String password) {
        Integer errorTimes = (Integer) redisUtils.get(RedisKeyPrefixEnum.USERLOGINTIMES + username);
        if (errorTimes != null && errorTimes >= 5) {
            return new ResultVO(0, "密码错误5次，请5分钟后再登录", null);
        }

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(PasswordUtils.encodePassword(password));
        List<User> users = userMapper.selectByExample(userExample);
        if (users != null && users.size() > 0) {
            User user = users.get(0);
            // 信息脱敏，不要将敏感信息带入session以免其他接口不小心泄露到前台
            user.setPassword(null);
            user.setStuNo(null);
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("loginUserId", user.getUserId());
            redisUtils.set("loginUser:" + user.getUserId(), session.getId());
            redisUtils.set(RedisKeyPrefixEnum.SESSIONID + session.getId(), user);
            return new ResultVO(1, "登录成功", user);
        } else {
            // 错误计数，5次锁定5分钟
            redisUtils.incr(RedisKeyPrefixEnum.USERLOGINTIMES + username, 1);
            redisUtils.expire(RedisKeyPrefixEnum.USERLOGINTIMES + username, 60 * 5);
            return new ResultVO(0, "账户名或密码错误", null);
        }
    }

    @Override
    public ResultVO logout(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        if (session != null) {
            redisUtils.del("loginUser:" + session.getAttribute("loginUserId"));
            session.invalidate();
        }
        return new ResultVO(1, "退出成功", null);
    }

    @Override
    public ResultVO info(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        User user = (User) redisUtils.get(RedisKeyPrefixEnum.SESSIONID + session.getId());
        if (user == null) {
            return new ResultVO(0, "登录超时", null);
        } else {
            UserDto userDto = new UserDto(user);
            userDto.setGames(userGameMapper.getGamesNumByUserId(user.getUserId()));
            userDto.setProducts(userGameMapper.getPrizesNumByUserId(user.getUserId()));
            return new ResultVO(1, "成功", userDto);
        }
    }

    @Override
    public ResultVO hit(Integer gameId, Integer curPage, Integer limit, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        Integer userId = (Integer) session.getAttribute("loginUserId");
        if (userId == null) {
            return new ResultVO(0, "登录超时", null);
        }
        ViewUserHitExample viewUserHitExample = new ViewUserHitExample();
        ViewUserHitExample.Criteria criteria = viewUserHitExample.createCriteria().andUserIdEqualTo(userId);
        if (gameId != -1) {
            criteria.andGameIdEqualTo(gameId);
        }
        long total = viewUserHitMapper.countByExample(viewUserHitExample);
        PageHelper.startPage(curPage, limit);
        List<ViewUserHit> all = viewUserHitMapper.selectByExample(viewUserHitExample);
        return new ResultVO(1, "成功", new PageBean(curPage, limit, total, all));
    }

}
