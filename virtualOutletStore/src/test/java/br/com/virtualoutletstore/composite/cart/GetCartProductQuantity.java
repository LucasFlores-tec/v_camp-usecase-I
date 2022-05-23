package br.com.virtualoutletstore.composite.cart;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import br.com.virtualoutletstore.builder.catalog.Catalog;
import br.com.virtualoutletstore.singleton.inventory.ProductInventory;

public class GetCartProductQuantity {
	
	@Rule
	public ErrorCollector error = new ErrorCollector();

	@Test
	public void getCartProductQuantiy() {
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
		int productSku1Quantity = cart.getProductQuantity(1);
		int productSku2Quantity = cart.getProductQuantity(2);
		int productSku3Quantity = cart.getProductQuantity(3);
		int productSku4Quantity = cart.getProductQuantity(4);
		
		//  Verification
		error.checkThat(productSku1Quantity, is(equalTo(10)));
		error.checkThat(productSku2Quantity, is(equalTo(10)));
		error.checkThat(productSku3Quantity, is(equalTo(10)));
		error.checkThat(productSku4Quantity, is(equalTo(10)));
	}
	
}
