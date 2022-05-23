package br.com.virtualoutletstore.composite.cart;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.com.virtualoutletstore.builder.catalog.Catalog;
import br.com.virtualoutletstore.singleton.inventory.ProductInventory;

public class GetTotalCartPriceTest {
	
	@Rule
	public ErrorCollector error = new ErrorCollector();

	@Test
	public void getTotalCartPrice() {
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
		Double totalCartPrice = cart.getTotalPriceOfTheCart();
		
		//  Verification
		error.checkThat(totalCartPrice, is(equalTo(6800.0)));
	}

}
