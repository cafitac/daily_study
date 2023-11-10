package com.fastcampus.helloecommeradmin.service;

import com.fastcampus.helloecommeradmin.domain.product.ProductDetailView;
import com.fastcampus.helloecommeradmin.repository.ProductRepository;
import com.fastcampus.helloecommeradmin.service.dto.ProductDTO;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductDTO> findAll() {
        List<ProductDetailView> productDetailViews = productRepository.findAllProductDetailView();
        List<ProductDTO> productDTOS = productDetailViews.stream().map(pv -> {
            return ProductDTO.builder()
                .productId(pv.getProductId())
                .productName(pv.getProductName())
                .imageUrl(pv.getImageUrl())
                .stockQuantity(pv.getStockQuantity())
                .price(pv.getPrice())
                .vendorId(pv.getVendorId())
                .vendorName(pv.getVendorName())
                .createdAt(pv.getCreatedAt())
                .createdBy(pv.getCreatedBy())
                .build();
        }).collect(Collectors.toList());
        return productDTOS;
    }

    public Optional<ProductDetailView> getProductDetail(Long productId) {
        return productRepository.getProductDetail(productId);
    }
}