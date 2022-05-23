package br.com.virtualoutletstore.facade.order;

import br.com.virtualoutletstore.composite.cart.Cart;

/**
 * Order (FACADE)
 */
public class Order {
	
	private Cart cart;

	private String shipping;
	
	private String status;
	
	public Order(Cart cart, String shipping, String status) {
		this.cart = cart;
		this.shipping = shipping;
		this.status = status;
	}

	public Cart getOrderCart() {
		return cart;
	}
	
	public void setOrderCart(Cart cart) {
		this.cart = cart;
	}

	public String getOrderShipping() {
		return shipping;
	}
	
	public void setOrderShipping(Cart cart) {
		this.shipping = cart.getShipping();
	}

	public String getOrderStatus() {
		return status;
	}
	
	public void setOrderStatus(String status) {
		this.status = status;
		if(status=="cancelled") {
			setOrderCart(new Cart());
			System.out.println("This order >> [" + this + "] << is cancelled.");
		}
	}
	
}
