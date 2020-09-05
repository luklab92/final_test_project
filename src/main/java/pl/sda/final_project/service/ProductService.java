package pl.sda.final_project.service;

import org.springframework.stereotype.Service;
import pl.sda.final_project.dto.ProductDto;
import pl.sda.final_project.model.product.ProductCategoryEntity;
import pl.sda.final_project.model.product.ProductEntity;
import pl.sda.final_project.repo.ProductCategoryRepo;
import pl.sda.final_project.repo.ProductRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepo productRepo;
    private ProductCategoryRepo productCategoryRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public void saveProduct(ProductDto productDto) {
        ProductEntity productEntityToSave = ProductEntity.apply(productDto);
        ProductCategoryEntity category = productCategoryRepo.findById(productDto.getProductCategoryId())
                .orElseThrow(() -> new RuntimeException("Can't find category"));
        productEntityToSave.setCategory(category);
        productRepo.save(productEntityToSave);
    }

    public List<ProductDto> findProducts() {
        return productRepo.findAll().stream()
                .map(ProductDto::apply)
                .collect(Collectors.toList());
    }
}