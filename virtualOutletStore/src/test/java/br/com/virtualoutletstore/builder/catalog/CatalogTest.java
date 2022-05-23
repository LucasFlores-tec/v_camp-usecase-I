package br.com.virtualoutletstore.builder.catalog;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CatalogTest {
	
	private Catalog catalog;
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Before
	public void setTestScenario() {
		// Scenario
		catalog = new Catalog();
	}

	@Test
	public void a_addBookToCatalog() {
		// Action
		catalog.addProductToCatalog("book");
		
		// Verification
		error.checkThat(catalog.getAllProducts().get(0).getSku(), is(equalTo(1)));
		error.checkThat(catalog.getAllProducts().get(0).getPrice(), is(equalTo(200.0)));
		error.checkThat(catalog.getAllProducts().get(0).getWeight(), is(equalTo(0.350)));
		error.checkThat(catalog.getAllProducts().get(0).getBook().getAuthor(), is(equalTo("Robert C. Martin; Michael C. Feathers; Timothy R. Ottinger")));
		error.checkThat(catalog.getAllProducts().get(0).getBook().getTitle(), is(equalTo("Clean Code: A Handbook of Agile Software Craftsmanship")));
	}
	
	@Test
	public void b_addTshirtToCatalog() {
		// Action
		catalog.addProductToCatalog("tshirt");
		
		// Verification
		error.checkThat(catalog.getAllProducts().get(1).getSku(), is(equalTo(2)));
		error.checkThat(catalog.getAllProducts().get(1).getPrice(), is(equalTo(50.0)));
		error.checkThat(catalog.getAllProducts().get(1).getWeight(), is(equalTo(0.100)));
		error.checkThat(catalog.getAllProducts().get(1).getTshirt().getColor(), is(equalTo("Black")));
		error.checkThat(catalog.getAllProducts().get(1).getTshirt().getSize(), is(equalTo("G")));
	}
	
	@Test
	public void c_addSsdcartToCatalog() {
		// Action
		catalog.addProductToCatalog("ssdcard");
		
		// Verification
		error.checkThat(catalog.getAllProducts().get(2).getSku(), is(equalTo(3)));
		error.checkThat(catalog.getAllProducts().get(2).getPrice(), is(equalTo(350.0)));
		error.checkThat(catalog.getAllProducts().get(2).getWeight(), is(equalTo(0.50)));
		error.checkThat(catalog.getAllProducts().get(2).getSsdcard().getBrand(), is(equalTo("Kingston")));
		error.checkThat(catalog.getAllProducts().get(2).getSsdcard().getGigabytes(), is(equalTo(480)));
	}
	
	@Test
	public void d_addMouseToCatalog() {
		// Action
		catalog.addProductToCatalog("mouse");
		
		// Verification
		error.checkThat(catalog.getAllProducts().get(3).getSku(), is(equalTo(4)));
		error.checkThat(catalog.getAllProducts().get(3).getPrice(), is(equalTo(80.0)));
		error.checkThat(catalog.getAllProducts().get(3).getWeight(), is(equalTo(0.50)));
		error.checkThat(catalog.getAllProducts().get(3).getMouse().getBrand(), is(equalTo("Logitech")));
		error.checkThat(catalog.getAllProducts().get(3).getMouse().getType(), is(equalTo("Bluetooth")));
	}
	
	@Test
	public void e_getAllProductsFromCatalog() {
		// Verification
		error.checkThat(catalog.getAllProducts().size(), is(equalTo(4)));
	}
	
}