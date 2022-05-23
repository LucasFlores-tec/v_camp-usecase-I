package br.com.virtualoutletstore.builder.catalog;

import br.com.virtualoutletstore.products.Book;
import br.com.virtualoutletstore.products.Mouse;
import br.com.virtualoutletstore.products.SsdCard;
import br.com.virtualoutletstore.products.Tshirt;

public class Director {
	
	public void bookBuilder(ProductBuilder book) {
		book.setSku(1);
		book.setPrice(200.0);
		book.setWeight(1.0);
		book.setBook(new Book("Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin; Michael C. Feathers; Timothy R. Ottinger"));
	}
	
	public void tshirtBuilder(ProductBuilder tshirt) {
		tshirt.setSku(2);
		tshirt.setPrice(50.0);
		tshirt.setWeight(0.1);
		tshirt.setTshirt(new Tshirt("Black", "G"));
	}
	
	public void ssdCardBuilder(ProductBuilder ssdCard) {
		ssdCard.setSku(3);
		ssdCard.setPrice(350.0);
		ssdCard.setWeight(0.05);
		ssdCard.setSsdcard(new SsdCard("Kingston", 480));
	}
	
	public void mouseBuilder(ProductBuilder mouse) {
		mouse.setSku(4);
		mouse.setPrice(80.0);
		mouse.setWeight(0.05);
		mouse.setMouse(new Mouse("Logitech", "Bluetooth"));
	}
	
}