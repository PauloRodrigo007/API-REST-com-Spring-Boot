package com.ecommerce.api.Api.REST.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	  @Autowired
	    private ProductRepository productRepository;

	    // Método para adicionar um novo produto
	    public Product addProduct(Product product) {
	        return productRepository.save(product);
	    }

	    // Método para obter um produto pelo ID
	    public Product getProductById(long productId) {
	        Optional<Product> productOptional = productRepository.findById(productId);
	        return productOptional.orElseThrow(() -> new IllegalArgumentException("Produto não encontrado com o ID: " + productId));
	    }

	    // Método para atualizar um produto
	    public Product updateProduct(long productId, Product updatedProduct) {
	        Product existingProduct = getProductById(productId);
	        existingProduct.setNome(updatedProduct.getNome());
	        existingProduct.setPreco(updatedProduct.getPreco());
	        return productRepository.save(existingProduct);
	    }

	    // Método para remover um produto pelo ID
	    public void deleteProduct(long productId) {
	        productRepository.deleteById(productId);
	    }

	    // Método para listar todos os produtos
	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }
}
