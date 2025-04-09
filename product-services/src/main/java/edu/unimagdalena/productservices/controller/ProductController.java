package edu.unimagdalena.productservices.controller;

import edu.unimagdalena.productservices.entity.Product;
import edu.unimagdalena.productservices.service.ProductService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Flux<Product> getAllProducts() {
        return Flux.fromIterable(productService.findAll());
    }

    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable("id") UUID id) {
        return Mono.fromCallable(()->productService.findById(id).orElse(null));
    }

    @PostMapping
    public Mono<Product> createProduct(@RequestBody Product product) {
        return Mono.fromCallable(()->productService.save(product));
    }

    @PutMapping("/{id}")
    public Mono<Product> updateProduct(@PathVariable("id") UUID id, @RequestBody Product product) {
        return Mono.fromCallable(()->productService.updateById(id, product).orElse(null));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable("id") UUID id) {
        return Mono.fromRunnable(()->productService.deleteById(id));
    }

}
