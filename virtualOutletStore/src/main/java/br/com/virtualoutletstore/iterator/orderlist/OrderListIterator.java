package br.com.virtualoutletstore.iterator.orderlist;

import br.com.virtualoutletstore.builder.catalog.Product;
import br.com.virtualoutletstore.facade.order.Order;

public class OrderListIterator implements Iterator {

	@Override
	public void getOrderList() {
		for(Order order: OrderList.getInstanceOfOrderList().getListOfOrders()) {
			System.out.println("Cart: " + order.getOrderCart());
			System.out.println("Status: " + order.getOrderStatus());
			System.out.println("Shipping: " + order.getOrderShipping());
			System.out.println("\n=================\n");
		}
	}

	@Override
	public void getProductsOfTheOrder() {
		int i = 1;
		for(Order order: OrderList.getInstanceOfOrderList().getListOfOrders()) {
			int totalOfProducts = 0;
			System.out.println("ORDER " + i + ":");
			for(Product product: order.getOrderCart().getCart()) {
				System.out.println("Sku: " + product.getSku());
				System.out.println("Price: " + product.getPrice());
				System.out.println("Weight: " + product.getWeight());
				switch(product.getSku()) {
				case 1:
					System.out.println("Author: " + product.getBook().getAuthor());
					System.out.println("Title: " + product.getBook().getTitle() + "\n");
					break;
				case 2:
					System.out.println("Color: " + product.getTshirt().getColor());
					System.out.println("Size: " + product.getTshirt().getSize() + "\n");
					break;
				case 3:
					System.out.println("Brand: " + product.getSsdcard().getBrand());
					System.out.println("Gigabytes: " + product.getSsdcard().getGigabytes() + "\n");
					break;
				case 4:
					System.out.println("Brand: " + product.getMouse().getBrand());
					System.out.println("Type: " + product.getMouse().getType() + "\n"); 
					break;
				}
				totalOfProducts++;
			}
			System.out.println("Total of Products in this Order: " + totalOfProducts);
			System.out.println("\n========================\n");
			i++;
		}
	}

	@Override
	public void getOrderTotalPrice() {
		int i = 1;
		for(Order order: OrderList.getInstanceOfOrderList().getListOfOrders()) {
			System.out.println("Order " + i + " total price: R$" + order.getOrderCart().getTotalPriceOfTheCart());
			i++;
		}
	}

	@Override
	public void getOrderShipping() {
		int i = 1;
		for(Order order: OrderList.getInstanceOfOrderList().getListOfOrders()) {
			System.out.println("Cart " + i + ":\n" + order.getOrderShipping());
			i++;
		}
	}

}