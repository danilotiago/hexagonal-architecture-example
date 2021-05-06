package app.projetaria.hexagonal.application;

import static org.junit.Assert.*;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductTest {

	@Test
	public void mustBeEnableProduct_whenPriceIsgreaterThanZero() {
		BigDecimal inputPrice = BigDecimal.TEN;
		
		Product product = new Product();
		product.setPrice(inputPrice);
		
		product.enable();
		
		assertEquals(product.getStatus(), StatusEnum.ENABLE);
	}
	
	@Test
	public void mustNotBeEnableProduct_whenPriceIsZero() {
		
		String exceptionMessage = "The price must be greater than zero to enable the product";
		BigDecimal inputPrice = BigDecimal.ZERO;
		Product product = new Product();
		product.setPrice(inputPrice);

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			product.enable();
	    });
		
		assertEquals(exception.getMessage(), exceptionMessage);
		assertEquals(product.getStatus(), StatusEnum.DISABLE);

	}
	
	@Test
	public void mustNotBeEnableProduct_whenPriceIsNegative() {
		
		String exceptionMessage = "The price must be greater than zero to enable the product";
		BigDecimal inputPrice = BigDecimal.valueOf(-1.0);
		Product product = new Product();
		product.setPrice(inputPrice);

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			product.enable();
	    });
		
		assertEquals(exception.getMessage(), exceptionMessage);
		assertEquals(product.getStatus(), StatusEnum.DISABLE);
	}
	
	@Test
	public void mustBeDisableProduct_whenPriceIsZero() {
		
		BigDecimal inputPrice = BigDecimal.ZERO;
		Product product = new Product();
		product.setPrice(inputPrice);
		
		product.disable();
		
		assertEquals(product.getStatus(), StatusEnum.DISABLE);
	}
	
	@Test
	public void mustNotBeDisable_whenPriceIsGreaterThanZero() {
		
		String exceptionMessage = "The price must be zero to disable the product";
		BigDecimal inputPrice = BigDecimal.TEN;
		Product product = new Product();
		product.setPrice(inputPrice);
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			product.disable();
		});
		
		assertEquals(exception.getMessage(), exceptionMessage);
	}
	
	@Test
	public void mustNotBeDisable_whenPriceIsNegative() {
		
		String exceptionMessage = "The price must be zero to disable the product";
		BigDecimal inputPrice = BigDecimal.valueOf(-1.0);
		Product product = new Product();
		product.setPrice(inputPrice);
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			product.disable();
		});
		
		assertEquals(exception.getMessage(), exceptionMessage);
	}
	
	@Test
	public void mustBeValid_whenPriceIsNotNegativeAndFieldsNotNull() {
		
		Product product = new Product();
		product.setId(UUID.randomUUID());
		product.setName("Product test");
		product.setPrice(BigDecimal.TEN);
		
		product.isValid();
		
		assertEquals(product.getStatus(), StatusEnum.DISABLE);
	}
	
	@Test
	public void mustNotBeValid_whenPriceIsNull() {
		
		String exceptionMessage = "The price must be greater or equal zero";
		Product product = new Product();
		product.setPrice(null);
		product.setId(UUID.randomUUID());
		product.setName("Product test");
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			product.isValid();
		});
		
		assertEquals(exception.getMessage(), exceptionMessage);
	}
	
	@Test
	public void mustNotBeValid_whenPriceIsNegative() {
		
		String exceptionMessage = "The price must be greater or equal zero";
		Product product = new Product();
		product.setPrice(BigDecimal.valueOf(-1.0));
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			product.isValid();
		});
		
		assertEquals(exception.getMessage(), exceptionMessage);
	}
	
	@Test
	public void mustNotBeValid_whenAnyFieldIsNull() {
		
		String message = "Some field is null";
		Product product = new Product();
		product.setPrice(BigDecimal.ONE);
		product.setName(null);
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			product.isValid();
		});
		
		assertEquals(exception.getMessage(), message);
	}
}
