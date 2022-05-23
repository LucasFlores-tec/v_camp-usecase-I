package br.com.virtualoutletstore.shipping;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.com.virtualoutletstore.builder.catalog.Catalog;
import br.com.virtualoutletstore.composite.cart.Cart;
import br.com.virtualoutletstore.factory.shipping.Aero;
import br.com.virtualoutletstore.factory.shipping.Shipping;
import br.com.virtualoutletstore.singleton.inventory.ProductInventory;

public class AeroShippingTest {
	
	private Cart cart;
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Before
	public void setScenario() {
		Catalog catalogAeroTest = new Catalog();
		catalogAeroTest.addProductToCatalog("book");
		catalogAeroTest.addProductToCatalog("tshirt");
		catalogAeroTest.addProductToCatalog("ssdcard");
		catalogAeroTest.addProductToCatalog("mouse");
		ProductInventory.addCatalogToInventory(catalogAeroTest);
		cart = new Cart();
	}
	
	@Test
	public void getPriceShippingAero() {
		// Scenario 2
		cart.addProductToCart(1, 1);
		cart.addProductToCart(2, 1);
		cart.addProductToCart(3, 1);
		Shipping shipping = new Aero();
		
		// Action
		Double shippingAeroPrice = shipping.getPrice(cart);
		
		// Verification
		error.checkThat(shippingAeroPrice, is(equalTo(63.0)));
		
	}

}