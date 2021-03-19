package com.ml.prize.commons.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author Mr.ml
 * @date 2021/3/18
 */
@ApiModel("分页信息")
public class PageBean {
    @ApiModelProperty(value = "当前页，1开始")
    private Integer currentPage = 1;
    @ApiModelProperty(value = "每页条数，默认10")
    private Integer pageSize = 10;
    @ApiModelProperty(value = "总条数")
    private Long totalNum;
    @ApiModelProperty(value = "是否有下一页")
    private Integer isMore;
    @ApiModelProperty(value = "总页数")
    private Integer totalPage;
    @ApiModelProperty(value = "开始索引")
    private Integer startIndex;
    @ApiModelProperty(value = "本页数据")
    private List items;

    public PageBean() {
        super();
    }

    public PageBean(Integer currentPage, Integer pageSize, Long totalNum, List data) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPage = Math.toIntExact((this.totalNum + this.pageSize - 1) / this.pageSize);
        this.startIndex = (this.currentPage - 1) * this.pageSize;
        this.isMore = this.currentPage >= this.totalPage ? 0 : 1;
        this.items = data;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getIsMore() {
        return isMore;
    }

    public void setIsMore(Integer isMore) {
        this.isMore = isMore;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }

}
