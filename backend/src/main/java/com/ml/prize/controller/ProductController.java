package com.ml.prize.controller;

import com.ml.prize.entity.Product;
import com.ml.prize.service.ProductService;
import com.ml.prize.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Mr.ml
 * @date 2021/3/13
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @PostMapping("/add")
    public ResultVO addProduct(Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/delete/{productId}")
    public ResultVO deleteProduct(@PathVariable("productId") Integer productId) {
        return productService.deleteProduct(productId);
    }

    @PutMapping("/update")
    public ResultVO updateProduct(Product product) {
        return productService.updateProduct(product);
    }

    @GetMapping("/get/{productId}")
    public ResultVO getProduct(@PathVariable("productId") Integer productId) {
        return productService.getProduct(productId);
    }

}
