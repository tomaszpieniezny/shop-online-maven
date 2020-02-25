package com.shop.shoponline.controller;

import com.shop.shoponline.mapper.ProductMapper;
import com.shop.shoponline.model.dto.ProductDto;
import com.shop.shoponline.model.entity.Product;
import com.shop.shoponline.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class ProductController {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    public List<ProductDto> getProduct() {
        return productMapper.mapToProductDtoList(productService.findAllProduct());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/availableProducts")
    public List<ProductDto> getProductAvailable() {
        return productMapper.mapToProductDtoList(productService.findAllAvailableProduct());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    public ProductDto getProductById(@PathVariable int id) throws Exception{
        return productMapper.mapToProductDto(productService.getProduct(id).orElseThrow(Exception::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/products", consumes = APPLICATION_JSON_VALUE)
    public Product createProduct(@RequestBody Product newProduct) {
        return productService.saveProduct(newProduct);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/products", consumes = APPLICATION_JSON_VALUE)
    public Product updateProduct(@RequestBody Product updateProduct) {
        return productService.saveProduct(updateProduct);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
    }

}
