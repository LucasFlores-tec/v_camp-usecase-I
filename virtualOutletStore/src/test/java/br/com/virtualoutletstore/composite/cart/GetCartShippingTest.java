package br.com.virtualoutletstore.composite.cart;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.com.virtualoutletstore.builder.catalog.Catalog;
import br.com.virtualoutletstore.singleton.inventory.ProductInventory;

public class GetCartShippingTest {
	
	@Rule
	public ErrorCollector error = new ErrorCollector();

	@Test
	public void getCartShipping() {
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
		cart.getShipping();
		
		//  Verification
		error.checkThat(cart.getShipping(), is(equalTo("Shipping Price: R$" + 720.0 + "\nShipping Type: " + "Aero")));
		
		// Shipping = 10% of the total purchase price, + R$1,00 for each product
		// Purchase Total Price: R$ 6.800,00 (10% 680) + R$40,00 (40 items) = R$ 720,00
	}

}