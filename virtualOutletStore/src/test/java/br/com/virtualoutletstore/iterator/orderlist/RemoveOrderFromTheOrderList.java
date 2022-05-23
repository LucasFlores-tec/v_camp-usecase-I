package br.com.virtualoutletstore.iterator.orderlist;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.com.virtualoutletstore.composite.cart.Cart;
import br.com.virtualoutletstore.facade.order.Order;

public class RemoveOrderFromTheOrderList {
	
	private Order order1;
	private Order order2;
	private Order order3;
	private Order order4;
	
	private Cart cart1;
	private Cart cart2;
	private Cart cart3;
	private Cart cart4;
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Before
	public void setScenario() {
		// Scenario
		cart1 = new Cart();
		cart2 = new Cart();
		cart3 = new Cart();
		cart4 = new Cart();
		order1 = new Order(cart1, cart1.getShipping(),"paid");
		order2 = new Order(cart2, cart2.getShipping(),"paid");
		order3 = new Order(cart3, cart3.getShipping(),"paid");
		order4 = new Order(cart4, cart4.getShipping(),"paid");
	}
	
	@Test
	public void removeOrderFromTheOrderList() {
		// Action
		OrderList.getInstanceOfOrderList().removeOrderFromTheList(order1);
		OrderList.getInstanceOfOrderList().removeOrderFromTheList(order2);
		OrderList.getInstanceOfOrderList().removeOrderFromTheList(order3);
		OrderList.getInstanceOfOrderList().removeOrderFromTheList(order4);
		
		// Verification
		error.checkThat(OrderList.getInstanceOfOrderList().getListOfOrders().size(), is(equalTo(0)));
	}

}