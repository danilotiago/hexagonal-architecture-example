package app.projetaria.hexagonal.application;

public interface IProduct {
	
	Boolean isValid() throws IllegalArgumentException;
	
	void enable() throws IllegalArgumentException;
	
	void disable() throws IllegalArgumentException;
}
