package br.com.virtualoutletstore.client;

import br.com.virtualoutletstore.builder.catalog.Catalog;
import br.com.virtualoutletstore.builder.catalog.Product;
import br.com.virtualoutletstore.composite.cart.Cart;
import br.com.virtualoutletstore.facade.order.Order;
import br.com.virtualoutletstore.iterator.orderlist.OrderList;
import br.com.virtualoutletstore.iterator.orderlist.OrderListIterator;
import br.com.virtualoutletstore.observer.backoffice.Backoffice;
import br.com.virtualoutletstore.singleton.inventory.ProductInventory;

public class Client {
	
public static void main(String[] args) {
		
		/**
		 * Instantiating the objects needed in order to run the application:
		 * - catalogOfProducts: an object of Catalog that will receive all new products the store has.
		 * - purchaseCarts: objects of Cart, where the products will be stored during the purchase. 
		 * - orders: objects of Order, where the carts will be stored during the purchase.
		 * - orderlistIterator: this  is the class responsible for iterating inside the list of orders.
		 * - orderObserver: object of the class Backoffice, that will print out every new order added to the orderList.
		 */
		Catalog catalogOfProducts = new Catalog();
		Cart Cart1 = new Cart();
		Cart Cart2 = new Cart();
		Cart Cart3 = new Cart();
		Cart Cart4 = new Cart();
		Order order1;
		Order order2;
		Order order3;
		Order order4;
		OrderListIterator orderListIterator = new OrderListIterator();
		Backoffice orderObserver;
		
		/**
		 * Adding products to the Catalog using the method addProductToCatalog, from the class Catalog, and printing them.
		 */
		catalogOfProducts.addProductToCatalog("book");
		catalogOfProducts.addProductToCatalog("tshirt");
		catalogOfProducts.addProductToCatalog("ssdcard");
		catalogOfProducts.addProductToCatalog("mouse");
		System.out.println("PRINTING THE PRODUCTS OF CATALOG\n");
		System.out.println("Catalog: " + catalogOfProducts.getAllProducts());
		
		/**
		 * Adding products of the Catalog to the Inventory of Products and printing them.
		 */
		System.out.println("\nADDING PRODUCTS TO THE INVENTORY...");
		ProductInventory.addCatalogToInventory(catalogOfProducts);
		
		System.out.println("\nPRINTING THE PRODUCTS OF THE INVENTORY\n");
		for(Product product: ProductInventory.getInstanceOfInventory().getInventory()) {
			System.out.println("SKU: " + product.getSku());
			System.out.println("Price: " + product.getPrice());
			System.out.println("Weight: " + product.getWeight());
			switch(product.getSku()) {
			case 1: 
				System.out.println("Author: " + product.getBook().getAuthor());
				System.out.println("Title: " + product.getBook().getTitle());
				ProductInventory.getInstanceOfInventory().getProductStock(1);
				System.out.println("\n=====================================\n"); 
				break;
			case 2: 
				System.out.println("Color: " + product.getTshirt().getColor());
				System.out.println("Size: " + product.getTshirt().getSize());
				ProductInventory.getInstanceOfInventory().getProductStock(2);
				System.out.println("\n=====================================\n");
				break;
			case 3:
				System.out.println("Brand: " + product.getSsdcard().getBrand());
				System.out.println("Gigabytes: " + product.getSsdcard().getGigabytes());
				ProductInventory.getInstanceOfInventory().getProductStock(3);
				System.out.println("\n=====================================\n");
				break;
			case 4:
				System.out.println("Brand: " + product.getMouse().getBrand());
				System.out.println("Type: " + product.getMouse().getType());
				ProductInventory.getInstanceOfInventory().getProductStock(4);
				System.out.println("\n=====================================\n");
				break;
			}
		}
		
		/**
		 * Adding products to the Carts using the addProductToTheCart method, removing some products from the Carts, and printing them.
		 */
		System.out.println("\nADDING PRODUCTS TO CART 1...");
		Cart1.addProductToCart(1, 3);
		Cart1.addProductToCart(3, 1);
		Cart1.addProductToCart(4, 1);
		System.out.println("\nCART 1");
		System.out.println("Products: " + Cart1.getCart());
		System.out.println(Cart1.getShipping());
		System.out.println("Total Price: " + Cart1.getTotalPriceOfTheCart());
		System.out.println("Total Weight: " + Cart1.getTotalWeightOfTheCart());
		
		System.out.println("\nADDING PRODUCTS TO CART 2...");
		Cart2.addProductToCart(1, 1);
		Cart2.addProductToCart(2, 3);
		Cart2.addProductToCart(4, 1);
		System.out.println("CART 2");
		System.out.println("Products: " + Cart2.getCart());
		System.out.println(Cart2.getShipping());
		System.out.println("Total Price: " + Cart2.getTotalPriceOfTheCart());
		System.out.println("Total Weight: " + Cart2.getTotalWeightOfTheCart());
		
		System.out.println("\nADDING PRODUCTS TO CART 3...");
		Cart3.addProductToCart(1, 1);
		Cart3.addProductToCart(2, 1);
		Cart3.addProductToCart(3, 1);
		System.out.println("CART 3");
		System.out.println("Products: " + Cart3.getCart());
		System.out.println(Cart3.getShipping());
		System.out.println("Total Price: " + Cart3.getTotalPriceOfTheCart());
		System.out.println("Total Weight: " + Cart3.getTotalWeightOfTheCart());
		
		System.out.println("\nADDING PRODUCTS TO CART 4...");
		Cart4.addProductToCart(1, 1);
		Cart4.addProductToCart(3, 1);
		Cart4.addProductToCart(4, 3);
		System.out.println("CART 4");
		System.out.println("Products: " + Cart4.getCart());
		System.out.println(Cart4.getShipping());
		System.out.println("Total Price: " + Cart4.getTotalPriceOfTheCart());
		System.out.println("Total Weight: " + Cart4.getTotalWeightOfTheCart());
		
		System.out.println("\n=====================================\n");
		
		System.out.println("\nREMOVING PRODUCTS FROM CART 1...");
		Cart1.removeProductFromCart(1, 1);
		Cart1.removeProductFromCart(3, 1);
		System.out.println("\nCART 1");
		System.out.println("Products: " + Cart1.getCart());
		System.out.println(Cart1.getShipping());
		System.out.println("Total Price: " + Cart1.getTotalPriceOfTheCart());
		System.out.println("Total Weight: " + Cart1.getTotalWeightOfTheCart());
		
		System.out.println("\nREMOVING PRODUCTS FROM CART 2...");
		Cart2.removeProductFromCart(2, 1);
		Cart2.removeProductFromCart(4, 1);
		System.out.println("CART 2");
		System.out.println("Products: " + Cart2.getCart());
		System.out.println(Cart2.getShipping());
		System.out.println("Total Price: " + Cart2.getTotalPriceOfTheCart());
		System.out.println("Total Weight: " + Cart2.getTotalWeightOfTheCart());
		
		System.out.println("\nREMOVING PRODUCTS FROM CART 3...");
		Cart3.removeProductFromCart(2, 1);
		Cart3.removeProductFromCart(3, 1);
		System.out.println("CART 3");
		System.out.println("Products: " + Cart3.getCart());
		System.out.println(Cart3.getShipping());
		System.out.println("Total Price: " + Cart3.getTotalPriceOfTheCart());
		System.out.println("Total Weight: " + Cart3.getTotalWeightOfTheCart());
		
		System.out.println("\nREMOVING PRODUCTS FROM CART 4...");
		Cart4.removeProductFromCart(1, 1);
		Cart4.removeProductFromCart(4, 1);
		System.out.println("CART 4");
		System.out.println("Products: " + Cart4.getCart());
		System.out.println(Cart4.getShipping());
		System.out.println("Total Price: " + Cart4.getTotalPriceOfTheCart());
		System.out.println("Total Weight: " + Cart4.getTotalWeightOfTheCart());
		
		System.out.println("\n=====================================\n");
		
		/**
		 * Adding the Cart objects with their products and characteristics of shipping, price and weight to an order each, and printing them..
		 */
		System.out.println("ADDING CARTS TO THEIR ORDERS...\n");
		order1 = new Order(Cart1, Cart1.getShipping(), "pending");
		order2 = new Order(Cart2, Cart2.getShipping(), "pending");
		order3 = new Order(Cart3, Cart3.getShipping(), "pending");
		order4 = new Order(Cart4, Cart4.getShipping(), "pending");
		
		System.out.println("=====================================\n");
		
		System.out.println("PRINTING THE ORDERS\n");
		System.out.println("Order 1: " + order1.getOrderCart());
		System.out.println("Order 2: " + order2.getOrderCart());
		System.out.println("Order 3: " + order3.getOrderCart());
		System.out.println("Order 4: " + order4.getOrderCart());
		
		System.out.println("\n=====================================\n");
		
		System.out.println("CANCELLING ORDER:");
		
		System.out.println("Order 1 products before cancelled: " + order1.getOrderCart().getCart());
		System.out.println("Order 1 price before cancelled: " + order1.getOrderCart().getTotalPriceOfTheCart());
		
		order1.setOrderStatus("cancelled");
		
		System.out.println("Order 1 products after cancelled: " + order1.getOrderCart().getCart());
		System.out.println("Order 1 price after cancelled: " + order1.getOrderCart().getTotalPriceOfTheCart());
		
		System.out.println("\n=====================================\n");
		
		System.out.println("ADDING ORDERS TO THE ORDERLIST... AND ACTIVATING THE BACKOFFICE");
		
		System.out.println("\n=====================================\n");

		/**
		 * Instantiating the Backoffice observer to return a notification every time an order is added to the order list.
		 */
		orderObserver = new Backoffice();
		OrderList.getInstanceOfOrderList().attachObserver(orderObserver);
		
		OrderList.getInstanceOfOrderList().addOrderToTheOrdersList(order1);
		OrderList.getInstanceOfOrderList().addOrderToTheOrdersList(order2);
		OrderList.getInstanceOfOrderList().addOrderToTheOrdersList(order3);
		OrderList.getInstanceOfOrderList().addOrderToTheOrdersList(order4);
		
		/**
		 * Adding Iterator object to the OrderList, in order to get different types of iterating in the OrderList instance.
		 */
		OrderList.getInstanceOfOrderList().setIterator(orderListIterator);
		
		System.out.println("PRINTING THE ORDERS CART, STATUS AND SHIPPING TYPE/PRICE\n");
		orderListIterator.getOrderList();
		
		System.out.println("PRINTING THE ORDERS SHIPPING TYPE/PRICE\n");
		orderListIterator.getOrderShipping();
		
		System.out.println("PRINTING THE PRODUCTS OF THE ORDERS/CARTS\n");
		orderListIterator.getProductsOfTheOrder();
		
		System.out.println("PRINTING THE TOTAL PRICE OF THE ORDERS/CARTS\n");
		orderListIterator.getOrderTotalPrice();
	}

}