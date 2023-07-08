package com.example.demo.Controler;

import com.example.demo.Dto.ProductDto;
import com.example.demo.models.ProductModel;
import com.example.demo.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductControler {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/product")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody@Valid ProductDto productDto){
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productDto,productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Object> getOneProducts(@PathVariable(value = "id")UUID id){
        Optional<ProductModel> product0 = productRepository.findById(id);
        if(product0.isEmpty()){
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto não encontrado");}
        return ResponseEntity.status(HttpStatus.OK).body(product0.get());
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id,@RequestBody
                                                @Valid ProductDto productDto){
        Optional<ProductModel> product0 = productRepository.findById(id);
        if(product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto não encontrado");}
        var productModel = product0.get();
        BeanUtils.copyProperties(productDto,productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));

    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Object> deleteProducts(@PathVariable(value = "id")UUID id){
        Optional<ProductModel> product0 = productRepository.findById(id);
        if(product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto não encontrado");}
        productRepository.delete(product0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product Deleted");
        }

    }