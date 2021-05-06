package app.projetaria.hexagonal.infraestructure;

import java.util.UUID;

import app.projetaria.hexagonal.application.IProduct;

public interface IProductRepository {
	
	public IProduct get(UUID id);
	
	public IProduct save(IProduct product);
}
