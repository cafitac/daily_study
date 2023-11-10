package com.fastcampus.helloecommeradmin.controller;

import com.fastcampus.helloecommeradmin.domain.product.ProductDetailView;
import com.fastcampus.helloecommeradmin.exception.ProductNotFoundException;
import com.fastcampus.helloecommeradmin.service.ProductService;
import com.fastcampus.helloecommeradmin.service.dto.ProductDTO;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private static final String MENU_KEY = "products";

    private final ProductService productService;

    @GetMapping(value = {"/products", "/products/"})
    public String list(Model model) {
        List<ProductDTO> productDTOS = productService.findAll();
        model.addAttribute("products", productDTOS);
        model.addAttribute("menuId", MENU_KEY);
        return "/products/products";
    }

    @GetMapping("/products/product-detail")
    public String detail(@RequestParam Long productId, Model model) {
        Optional<ProductDetailView> optionalProductDetailView = productService.getProductDetail(productId);
        ProductDetailView productDetailView = optionalProductDetailView.orElseThrow(() -> new ProductNotFoundException("Not found product info"));
        model.addAttribute("productDetail", productDetailView);
        model.addAttribute("menuId", MENU_KEY);
        return "/products/product-detail";
    }
}