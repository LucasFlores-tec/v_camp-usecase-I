package br.com.virtualoutletstore.factory.shipping;

import br.com.virtualoutletstore.composite.cart.Cart;

public class Road extends Shipping {
	
	private String type = "Road";

	@Override
	public Double getPrice(Cart cart) {
		Double totalRoadDeliverPrice = 0d;
		Double priceForeachItem = 1.0;
		if(cart.getTotalPriceOfTheCart()>7.99) {
			totalRoadDeliverPrice = cart.getTotalPriceOfTheCart() * 0.10;
			for(int i=0;i<cart.getCart().size();i++) {
				totalRoadDeliverPrice += priceForeachItem;
			}
		} else {
			System.out.println("The purchase total is below the minimum required");
		}
		return totalRoadDeliverPrice;
	}
	
	public String getType() {
		return type;
	}

}
