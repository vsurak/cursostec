package market.agri;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgroApi {
	@GetMapping("/search/{phrase}")
	public ResponseEntity<String>  searchPhrase(@PathVariable("phrase") String pInputPhrase) {
		
		ResponseEntity<String> result = new ResponseEntity<String>("enviaste esta frase: "+pInputPhrase, HttpStatus.ACCEPTED);
		
		return result;
	}
}
