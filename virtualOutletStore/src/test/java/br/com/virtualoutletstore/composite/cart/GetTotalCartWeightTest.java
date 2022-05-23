package br.com.virtualoutletstore.composite.cart;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.virtualoutletstore.builder.catalog.Catalog;
import br.com.virtualoutletstore.singleton.inventory.ProductInventory;

public class GetTotalCartWeightTest {
	
	@Test
	public void getTotalCartWeight() {
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
		Double totalCartWeight = cart.getTotalWeightOfTheCart();
		
		//  Verification
		
		assertEquals(totalCartWeight, 12.0, 0.01);
	}

}
