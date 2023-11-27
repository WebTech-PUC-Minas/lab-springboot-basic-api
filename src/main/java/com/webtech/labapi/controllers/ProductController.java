package com.webtech.labapi.controllers;

import com.webtech.labapi.domain.product.Product;
import com.webtech.labapi.domain.product.ProductRepository;
import com.webtech.labapi.domain.product.RequestProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RestController
@RequestMapping("/products") //endpoint que esse controller vai ouvir
public class ProductController {

    @Autowired //injeção de dependência
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity getAllProducts(){
        var allProducts = productRepository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody @Valid RequestProduct product){ //Valid - validação do corpo de acordo com as definições da classe RequestProduct
        //System.out.println(product);
        Product newProduct = new Product(product);
        productRepository.save(newProduct);
        return ResponseEntity.ok().build();
    }

    //! entender uso do Optional
    @PutMapping     //formas: por id (inclusão na rota), por corpo, etc
    @Transactional  //ao executar mais de um comando sql de forma conjunta
    public ResponseEntity updateProduct(@RequestBody @Valid RequestProduct product){
        Optional<Product> existingProduct = productRepository.findById(product.id());
        if (existingProduct.isPresent()){
            Product updateProduct = existingProduct.get();
            updateProduct.setName(product.name());
            updateProduct.setPrice(product.price());
            return ResponseEntity.ok(updateProduct); //não é ideal retornar toda uma entidade Produto
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id){
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
