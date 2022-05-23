package br.com.virtualoutletstore.factory.shipping;

import br.com.virtualoutletstore.composite.cart.Cart;

public class Aero extends Shipping {
	
	private String type = "Aero";

	@Override
	public Double getPrice(Cart cart) {
		Double totalAeroDeliverPrice = 0d;
		Double priceForeachItem = 1.0;
		if(cart.getTotalPriceOfTheCart()>7.99) {
			totalAeroDeliverPrice = cart.getTotalPriceOfTheCart() * 0.10;
			for(int i=0;i<cart.getCart().size();i++) {
				totalAeroDeliverPrice += priceForeachItem;
			}
		} else {
			System.out.println("The purchase total is below the minimum required");
		}
		return totalAeroDeliverPrice;
	}
	
	public String getType() {
		return type;
	}

}