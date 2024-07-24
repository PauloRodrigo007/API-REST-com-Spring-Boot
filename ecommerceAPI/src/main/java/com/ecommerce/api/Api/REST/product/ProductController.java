package com.ecommerce.api.Api.REST.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	 private List<Product> products = new ArrayList<>(); 
	    
	    @PostMapping("/adicionar")
	    public Product adicionarProduto(@RequestBody Product produto) {
	        produto.setId(products.size() + 1); 
	        products.add(produto);
	        return produto;
	    }
	    
	    @GetMapping("/list")
	    public List<Product> getAllProducts() {
	        return products;
	    }
	    
	    @GetMapping("/{productId}")
	    public Product getProductById(@PathVariable long productId) {
	        Optional<Product> productOptional = products.stream()
	                .filter(product -> product.getId() == productId)
	                .findFirst();
	        
	        if (productOptional.isPresent()) {
	            return productOptional.get();
	        } else {
	            throw new IllegalArgumentException("Produto não encontrado com o ID: " + productId);
	        }
	    }
	    
	    @PutMapping("/{productId}")
	    public Product updateProduct(@PathVariable long productId, @RequestBody Product updatedProduct) {
	        @SuppressWarnings("unused")
			Optional<Product> productOptional = products.stream()
	                .filter(product -> product.getId() == productId)
	                .findFirst();
			return updatedProduct;
	    	    
}
	    
	    @DeleteMapping("/{productId}")
	    public String deleteProduct(@PathVariable long productId) {
	        Iterator<Product> iterator = products.iterator();
	        while (iterator.hasNext()) {
	            Product product = iterator.next();
	            if (product.getId() == productId) {
	                iterator.remove();
	                return "Produto removido com sucesso.";
	            }
	        }
	        return "Produto não encontrado com o ID: " + productId;
	    }
}
