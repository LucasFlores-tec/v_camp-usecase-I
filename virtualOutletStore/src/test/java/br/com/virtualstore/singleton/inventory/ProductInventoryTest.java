package br.com.virtualstore.singleton.inventory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runners.MethodSorters;

import br.com.virtualoutletstore.builder.catalog.Catalog;
import br.com.virtualoutletstore.singleton.inventory.ProductInventory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductInventoryTest {
	
	private Catalog catalog;
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Before
	public void setScerario() {
		catalog = new Catalog();
		catalog.addProductToCatalog("book");
		catalog.addProductToCatalog("tshirt");
		catalog.addProductToCatalog("ssdcard");
		catalog.addProductToCatalog("mouse");
	}
	
	@Test
	public void a_gettingInventory() {
		// Action
		ProductInventory.addCatalogToInventory(catalog);
		
		// Verification
		error.checkThat(ProductInventory.getInstanceOfInventory().getInventory().size(), is(equalTo(4)));
	}
	
	@Test
	public void b_addingCatalogToInventory() {
		// Action
		ProductInventory.addCatalogToInventory(catalog);
		
		// Verification
		error.checkThat(ProductInventory.getInstanceOfInventory().getInventory().get(0).getSku(), is(equalTo(catalog.getAllProducts().get(0).getSku())));
		error.checkThat(ProductInventory.getInstanceOfInventory().getInventory().get(1).getSku(), is(equalTo(catalog.getAllProducts().get(1).getSku())));
		error.checkThat(ProductInventory.getInstanceOfInventory().getInventory().get(2).getSku(), is(equalTo(catalog.getAllProducts().get(2).getSku())));
		error.checkThat(ProductInventory.getInstanceOfInventory().getInventory().get(3).getSku(), is(equalTo(catalog.getAllProducts().get(3).getSku())));
	}
	
	@Test
	public void c_gettingProductStock() {
		
		// Action
		int stockOfProductSku1 = ProductInventory.getInstanceOfInventory().getProductStock(1);
		int stockOfProductSku2 = ProductInventory.getInstanceOfInventory().getProductStock(2);
		int stockOfProductSku3 = ProductInventory.getInstanceOfInventory().getProductStock(3);
		int stockOfProductSku4 = ProductInventory.getInstanceOfInventory().getProductStock(4);
		
		// Verification
		error.checkThat(stockOfProductSku1, is(equalTo(10)));
		error.checkThat(stockOfProductSku2, is(equalTo(10)));
		error.checkThat(stockOfProductSku3, is(equalTo(10)));
		error.checkThat(stockOfProductSku4, is(equalTo(10)));
	}
	
	@Test
	public void d_removingProductToStock() {
		// Action
		ProductInventory.getInstanceOfInventory().removeProductFromStock(1, 5);
		ProductInventory.getInstanceOfInventory().removeProductFromStock(2, 4);
		ProductInventory.getInstanceOfInventory().removeProductFromStock(3, 3);
		ProductInventory.getInstanceOfInventory().removeProductFromStock(4, 2);
		
		// Verification
		error.checkThat(ProductInventory.getInstanceOfInventory().getProductStock(1), is(equalTo(5)));
		error.checkThat(ProductInventory.getInstanceOfInventory().getProductStock(2), is(equalTo(6)));
		error.checkThat(ProductInventory.getInstanceOfInventory().getProductStock(3), is(equalTo(7)));
		error.checkThat(ProductInventory.getInstanceOfInventory().getProductStock(4), is(equalTo(8)));		
		
	}
	
	@Test
	public void e_returningProductToStock() {
		// Action
		ProductInventory.getInstanceOfInventory().returnProductToStock(1, 5);
		ProductInventory.getInstanceOfInventory().returnProductToStock(2, 4);
		ProductInventory.getInstanceOfInventory().returnProductToStock(3, 3);
		ProductInventory.getInstanceOfInventory().returnProductToStock(4, 2);
		
		// Verification
		error.checkThat(ProductInventory.getInstanceOfInventory().getProductStock(1), is(equalTo(10)));
		error.checkThat(ProductInventory.getInstanceOfInventory().getProductStock(2), is(equalTo(10)));
		error.checkThat(ProductInventory.getInstanceOfInventory().getProductStock(3), is(equalTo(10)));
		error.checkThat(ProductInventory.getInstanceOfInventory().getProductStock(4), is(equalTo(10)));
		
	}
	
	
	@Test
	public void f_blockingProductToStock() {
		// Action
		ProductInventory.getInstanceOfInventory().blockProductFromStock(1, 3);
		ProductInventory.getInstanceOfInventory().blockProductFromStock(2, 6);
		ProductInventory.getInstanceOfInventory().blockProductFromStock(3, 9);
		ProductInventory.getInstanceOfInventory().blockProductFromStock(4, 5);
		
		// Verification
		error.checkThat(ProductInventory.getInstanceOfInventory().getProductStock(1), is(equalTo(7)));
		error.checkThat(ProductInventory.getInstanceOfInventory().getProductStock(2), is(equalTo(4)));
		error.checkThat(ProductInventory.getInstanceOfInventory().getProductStock(3), is(equalTo(1)));
		error.checkThat(ProductInventory.getInstanceOfInventory().getProductStock(4), is(equalTo(5)));		
				
	}

}