package br.com.virtualoutletstore.composite.cart;

import java.util.ArrayList;
import java.util.List;

import br.com.virtualoutletstore.builder.catalog.Product;
import br.com.virtualoutletstore.factory.shipping.Aero;
import br.com.virtualoutletstore.factory.shipping.Road;
import br.com.virtualoutletstore.factory.shipping.Shipping;
import br.com.virtualoutletstore.singleton.inventory.ProductInventory;

/**
 * Cart (COMPOSITE)
 */
public class Cart {
	
	private List<Product> cart = new ArrayList<>();
	
	public List<Product> getCart() {
		return cart;
	}

	public void addProductToCart(int productSku, int quantity) {
		ProductInventory.getInstanceOfInventory().removeProductFromStock(productSku, quantity);
		for(Product product: ProductInventory.getInstanceOfInventory().getInventory()) {
			if(product.getSku()==productSku) {
				for(int i=0;i<quantity;i++) {
					cart.add(product);
				}
			}
		}
	}
	
	public void removeProductFromCart(int productSku, int quantity) {
		ProductInventory.getInstanceOfInventory().returnProductToStock(productSku, quantity);
		for(int i=0;i<cart.size();i++) {
			if(cart.get(i).getSku()==productSku) {
				for(int j=0;j<quantity;j++) {
					cart.remove(i);
				}
				break;
			}
		}
	}
	
	public void removeAllProductsFromCart() {
		for(int i=1;i<=getCart().size()+1;i++) {
			removeProductFromCart(i, getProductQuantity(i));
		}
	}
	
	public int getProductQuantity(int productSku) {
		int prodQtd=0;
		for(Product product: getCart()) {
			if(product.getSku()==productSku) {
				prodQtd++;
			}
		}
		return prodQtd;
	}

	public Double getTotalPriceOfTheCart() {
		Double Total = 0d;
		for(Product product: cart) {
			Total += product.getPrice();
		}
		return Total;
	}
	
	public Double getTotalWeightOfTheCart() {
		Double weight = 0d;
		for(Product product: cart) {
			weight += product.getWeight();
		}
		return weight;
	}
	
	public String getShipping() {
		Shipping shipping;
		if(getTotalWeightOfTheCart() <= 10) {
			shipping = new Aero();
		} else {
			shipping = new Road();
		}
		return "Shipping Price: R$" + shipping.getPrice(this) + "\nShipping Type: " + shipping.getType();
	}
	
}
