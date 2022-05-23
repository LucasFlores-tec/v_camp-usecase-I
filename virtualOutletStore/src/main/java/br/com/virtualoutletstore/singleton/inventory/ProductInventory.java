package br.com.virtualoutletstore.singleton.inventory;

import java.util.ArrayList;
import java.util.List;

import br.com.virtualoutletstore.builder.catalog.Catalog;
import br.com.virtualoutletstore.builder.catalog.Product;

/**
 * Inventory (SINGLETON)
 */

public class ProductInventory {
	
	private static volatile ProductInventory instanceOfInventory;
	
	private static int bookStock = 10;
	
	private static int tshirtStock = 10;
	
	private static int ssdCardStock = 10;
	
	private static int mouseStock = 10;

	private static List<Product> inventory = new ArrayList<>();
	
	private ProductInventory(int bookStock, int tshirtStock, int ssdCardStock, int mouseStock, List<Product> inventory) {
		ProductInventory.bookStock = bookStock;
		ProductInventory.tshirtStock = tshirtStock;
		ProductInventory.ssdCardStock = ssdCardStock;
		ProductInventory.mouseStock = mouseStock;
		ProductInventory.inventory = inventory;
	}

	public synchronized static ProductInventory getInstanceOfInventory() {
		if(instanceOfInventory == null) {
			instanceOfInventory = new ProductInventory(bookStock, tshirtStock, ssdCardStock, mouseStock, inventory);
		}
		return instanceOfInventory;
	}

	public List<Product> getInventory() {
		ProductInventory.getInstanceOfInventory();
		return ProductInventory.inventory;
	}

	public static void addCatalogToInventory(Catalog catalog) {
		for(Product product: catalog.getAllProducts()) {
			inventory.add(product);
		}
	}
	
	public int getProductStock(int productSku) {
		int stock = 0;
		switch(productSku) {
		case 1: stock = ProductInventory.bookStock; break;
		case 2: stock = ProductInventory.tshirtStock; break; 
		case 3: stock = ProductInventory.ssdCardStock; break;
		case 4: stock = ProductInventory.mouseStock; break;
		default: System.out.println("Product with sku (" + productSku + ") not found");
		}
		return stock;
	}
	
	public void returnProductToStock(int productSku, int quantity) {
		switch(productSku) {
		case 1: ProductInventory.bookStock += quantity; break;
		case 2: ProductInventory.tshirtStock += quantity; break;  
		case 3: ProductInventory.ssdCardStock += quantity; break;
		case 4: ProductInventory.mouseStock += quantity; break;
		default: System.out.println("Product with sku (" + productSku + ") not found");
		}
	}
	
	public void removeProductFromStock(int productSku, int quantity) {
		switch(productSku) {
		case 1: ProductInventory.bookStock -= quantity; break;
		case 2: ProductInventory.tshirtStock -= quantity; break;  
		case 3: ProductInventory.ssdCardStock -= quantity; break;
		case 4: ProductInventory.mouseStock -= quantity; break;
		default: System.out.println("Product with sku (" + productSku + ") not found");
		}
	}
	
	public void blockProductFromStock(int productSku, int quantity) {
		switch(productSku) {
		case 1: ProductInventory.bookStock -= quantity; break;
		case 2: ProductInventory.tshirtStock -= quantity; break;  
		case 3: ProductInventory.ssdCardStock -= quantity; break;
		case 4: ProductInventory.mouseStock -= quantity; break;
		default: System.out.println("Product with sku (" + productSku + ") not found");
		}
	}
	
}
