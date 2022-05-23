package br.com.virtualoutletstore.observer.backoffice;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.com.virtualoutletstore.composite.cart.Cart;
import br.com.virtualoutletstore.facade.order.Order;
import br.com.virtualoutletstore.iterator.orderlist.OrderList;

public class RenderOrderListTest {
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Test
	public void renderOrderListTest() {
		// Scenario
		Cart cart1 = new Cart();
		Cart cart2 = new Cart();
		Cart cart3 = new Cart();
		Cart cart4 = new Cart();
		
		Order order1 = new Order(cart1, cart1.getShipping(),"paid");
		Order order2 = new Order(cart2, cart2.getShipping(),"paid");
		Order order3 = new Order(cart3, cart3.getShipping(),"paid");
		Order order4 = new Order(cart4, cart4.getShipping(),"paid");
		
		Backoffice addOrderObserver = new Backoffice();
		
		// Action
		
		OrderList.getInstanceOfOrderList().attachObserver(addOrderObserver);
		OrderList.getInstanceOfOrderList().addOrderToTheOrdersList(order1);
		OrderList.getInstanceOfOrderList().addOrderToTheOrdersList(order2);
		OrderList.getInstanceOfOrderList().addOrderToTheOrdersList(order3);
		OrderList.getInstanceOfOrderList().addOrderToTheOrdersList(order4);
		
		// Verification
		
	}
}
