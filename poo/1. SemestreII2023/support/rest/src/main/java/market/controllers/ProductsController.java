package market.controllers;

import market.model.Order;
import market.model.Product;

public class ProductsController {
	public Order orderProduct(Product pProduct) {
	    Order newOrder = new Order(383783, pProduct.getName(), "Santiago");
	    // si hay que hacer algun sort
	    // ir a buscar otros datos
	    // consultar algo a la base datos
	    // calcular un precio
	    
	    return newOrder;
	}
}
