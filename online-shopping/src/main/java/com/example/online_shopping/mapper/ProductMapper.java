package com.example.online_shopping.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.online_shopping.dao.entity.Product;
import com.example.online_shopping.model.ProductDto;

@Component
public class ProductMapper {

	public ProductDto entityToDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		productDto.setDescription(product.getDescription());
		return productDto;
	}

	public Product dtoToEntity(ProductDto productDto) {
		Product product = new Product();
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setDescription(productDto.getDescription());
		return product;
	}

	public List<ProductDto> entityListToDtoList(List<Product> products) {
		List<ProductDto> productDtos = new ArrayList<>();
		for (Product product : products) {
			ProductDto poructDto = entityToDto(product);
			productDtos.add(poructDto);
		}
		return productDtos;
	}

	public List<Product> dtoListToEntityList(List<ProductDto> productDtos) {
		List<Product> products = new ArrayList<>();
		for (ProductDto productDto : productDtos) {
			Product product = dtoToEntity(productDto);
			products.add(product);
		}
		return products;
	}

}
