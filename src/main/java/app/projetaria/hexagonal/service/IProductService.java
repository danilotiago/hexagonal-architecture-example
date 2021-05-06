package app.projetaria.hexagonal.service;

import java.math.BigDecimal;
import java.util.UUID;

import app.projetaria.hexagonal.application.IProduct;

public interface IProductService {
	
	public IProduct get(UUID id);
	
	public IProduct create(String name, BigDecimal price);
	
	public IProduct enable(IProduct product);
	
	public IProduct disable(IProduct product);
}
