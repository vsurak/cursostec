package market.agri;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import market.controllers.ProductsController;
import market.model.Order;
import market.model.Product;

@RestController
public class AgroApi {
	
	@GetMapping("/search/{phrase}")
	public ResponseEntity<String>  searchPhrase(@PathVariable("phrase") String pInputPhrase) {
		
		ResponseEntity<String> result = new ResponseEntity<String>("enviaste esta frase: "+pInputPhrase, HttpStatus.ACCEPTED);
		
		return result;
	}
	
	@PostMapping(path = "/product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> createProduct(@RequestBody Product pProduct) {
	    System.out.println("Recibi este producto: "+pProduct.getName());
	    
	    ProductsController controller = new ProductsController();
	    return new ResponseEntity<>(controller.orderProduct(pProduct), HttpStatus.CREATED);
	}
}
