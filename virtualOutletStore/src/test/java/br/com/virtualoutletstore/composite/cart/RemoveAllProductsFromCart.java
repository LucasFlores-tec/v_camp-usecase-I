package br.com.virtualoutletstore.composite.cart;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.com.virtualoutletstore.builder.catalog.Catalog;
import br.com.virtualoutletstore.singleton.inventory.ProductInventory;

public class RemoveAllProductsFromCart {
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Test
	public void removeAllProductsFromCart() {
		// Scenario
		Catalog catalogCartTest = new Catalog();
		catalogCartTest.addProductToCatalog("book");
		catalogCartTest.addProductToCatalog("tshirt");
		catalogCartTest.addProductToCatalog("ssdcard");
		catalogCartTest.addProductToCatalog("mouse");
		ProductInventory.addCatalogToInventory(catalogCartTest);
		Cart cart = new Cart();
		cart.addProductToCart(1, 10);
		cart.addProductToCart(2, 10);
		cart.addProductToCart(3, 10);
		cart.addProductToCart(4, 10);
		
		// Action
		cart.removeAllProductsFromCart();
		
		//  Verification
		error.checkThat(cart.getCart().size(), is(equalTo(0)));
	}

}
