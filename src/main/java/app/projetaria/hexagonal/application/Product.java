package app.projetaria.hexagonal.application;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

public class Product implements IProduct {
	
	private UUID id;
	
	private String name;
	
	private StatusEnum status;
	
	private BigDecimal price;
	
	public Product() {
		this.id = UUID.randomUUID();
		this.status = StatusEnum.DISABLE;
	}

	@Override
	public Boolean isValid() throws IllegalArgumentException {
		
		if (this.price == null || this.price.compareTo(BigDecimal.ZERO) == -1) {
			throw new IllegalArgumentException("The price must be greater or equal zero");
		}
		
		Boolean hasInvalidField = Stream.of(id, name, status, price)
					.anyMatch(Objects::isNull);
		
		if (hasInvalidField) {
			throw new IllegalArgumentException("Some field is null");
		}
		
		return true;
	}

	@Override
	public void enable() throws IllegalArgumentException {
		if (this.price.compareTo(BigDecimal.ZERO) != 1) {
			throw new IllegalArgumentException("The price must be greater than zero to enable the product");
		}
		this.status = StatusEnum.ENABLE;
	}

	@Override
	public void disable() throws IllegalArgumentException {
		if (this.price.compareTo(BigDecimal.ZERO) != 0) {
			throw new IllegalArgumentException("The price must be zero to disable the product");
		}
		this.status = StatusEnum.DISABLE;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
