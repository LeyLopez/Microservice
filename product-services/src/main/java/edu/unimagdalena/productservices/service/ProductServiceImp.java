package edu.unimagdalena.productservices.service;

import edu.unimagdalena.productservices.entity.Product;
import edu.unimagdalena.productservices.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> updateById(UUID id, Product product) {
        return productRepository.findById(id).map(
                productInBD->{
                    productInBD.setName(product.getName());
                    productInBD.setDescription(product.getDescription());
                    productInBD.setPrice(product.getPrice());

                    return productRepository.save(productInBD);
                }
        );
    }
}
