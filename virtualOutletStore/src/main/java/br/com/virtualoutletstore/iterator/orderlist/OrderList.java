package br.com.virtualoutletstore.iterator.orderlist;

import java.util.ArrayList;
import java.util.List;

import br.com.virtualoutletstore.facade.order.Order;
import br.com.virtualoutletstore.observer.backoffice.OrderListObserver;

/**
 * Order List (SINGLETON & ITERATOR)
 */
public class OrderList {
	
	private static OrderList instanceOfOrderList;
	
	private static List<Order> listOfOrders = new ArrayList<>();
	
	private List<OrderListObserver> orderObservers = new ArrayList<>();
	
	private OrderList(List<Order> listOfOrders) {
		OrderList.listOfOrders = listOfOrders;
	}
	
	public synchronized static OrderList getInstanceOfOrderList() {
		if(instanceOfOrderList==null) {
			instanceOfOrderList = new OrderList(listOfOrders);
		}
		return instanceOfOrderList;
	}

	public void setIterator(OrderListIterator iterator) {}

	public List<Order> getListOfOrders() {
		OrderList.getInstanceOfOrderList();
		return OrderList.listOfOrders;
	}
	
	public void addOrderToTheOrdersList(Order order) {
		if(order.getOrderStatus()=="cancelled") {
			System.out.println("This order >>[" + order + "]<< is cancelled and can not be added to the order list.");
		} else {
			listOfOrders.add(order);
			orderObservers.forEach(o->o.renderOrderList(this));
		}
	}
	
	public void removeOrderFromTheList(Order order) {
		listOfOrders.remove(order);
		orderObservers.forEach(o->o.renderOrderList(this));
	}
	
	public void attachObserver(OrderListObserver observer) {
		orderObservers.add(observer);
	}
	
	public void detachObserver(OrderListObserver observer) {
		orderObservers.remove(observer);
	}
	
}