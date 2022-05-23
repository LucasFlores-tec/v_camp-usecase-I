package br.com.virtualoutletstore.builder.catalog;

import br.com.virtualoutletstore.products.Book;
import br.com.virtualoutletstore.products.Mouse;
import br.com.virtualoutletstore.products.SsdCard;
import br.com.virtualoutletstore.products.Tshirt;

public class ProductBuilder implements Builder {

	private int sku;
	
	private Double price;
	
	private Double weight;
	
	private Book book;
	
	private Tshirt tshirt;
	
	private SsdCard ssdcard;
	
	private Mouse mouse;
	
	@Override
	public void setSku(int sku) {
		this.sku = sku;
	}

	@Override
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Override
	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public void setTshirt(Tshirt tshirt) {
		this.tshirt = tshirt;
	}

	@Override
	public void setSsdcard(SsdCard ssdcard) {
		this.ssdcard = ssdcard;
	}

	@Override
	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}
	
	public Product getResults() {
		return new Product(sku, price, weight, book, tshirt, ssdcard, mouse);
	}

}
