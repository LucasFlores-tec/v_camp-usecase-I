package br.com.virtualoutletstore.iterator.orderlist;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.com.virtualoutletstore.composite.cart.Cart;
import br.com.virtualoutletstore.facade.order.Order;

public class GetListOfOrdersTest {
	
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
		OrderList.getInstanceOfOrderList().addOrderToTheOrdersList(order1);
		OrderList.getInstanceOfOrderList().addOrderToTheOrdersList(order2);
		OrderList.getInstanceOfOrderList().addOrderToTheOrdersList(order3);
		OrderList.getInstanceOfOrderList().addOrderToTheOrdersList(order4);
	}
	
	@Test
	public void getOrderListTest() {
		// Action
		List<Order> orderList = OrderList.getInstanceOfOrderList().getListOfOrders();
		
		// Verification
		error.checkThat(orderList.get(0).getOrderCart(), is(equalTo(cart1)));
		error.checkThat(orderList.get(1).getOrderCart(), is(equalTo(cart2)));
		error.checkThat(orderList.get(2).getOrderCart(), is(equalTo(cart3)));
		error.checkThat(orderList.get(3).getOrderCart(), is(equalTo(cart4)));
		error.checkThat(orderList.get(0).getOrderShipping(), is(equalTo(cart1.getShipping())));
		error.checkThat(orderList.get(1).getOrderShipping(), is(equalTo(cart2.getShipping())));
		error.checkThat(orderList.get(2).getOrderShipping(), is(equalTo(cart3.getShipping())));
		error.checkThat(orderList.get(3).getOrderShipping(), is(equalTo(cart4.getShipping())));
		error.checkThat(orderList.get(0).getOrderStatus(), is(equalTo("paid")));
		error.checkThat(orderList.get(1).getOrderStatus(), is(equalTo("paid")));
		error.checkThat(orderList.get(2).getOrderStatus(), is(equalTo("paid")));
		error.checkThat(orderList.get(3).getOrderStatus(), is(equalTo("paid")));
	}

}