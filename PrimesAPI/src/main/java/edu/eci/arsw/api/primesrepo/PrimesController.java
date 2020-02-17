package edu.eci.arsw.api.primesrepo;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.service.PrimeService;
import edu.eci.arsw.blueprints.exception.FoundPrimeException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */
@RestController
@RequestMapping(value = "/primes")
public class PrimesController
{
	@Autowired
	@Qualifier("PrimeServiceStub")
    PrimeService primeService;


    @RequestMapping(method = GET )
    public ResponseEntity<?> getPrimes() {
        return new ResponseEntity<>(primeService.getFoundPrimes(), HttpStatus.ACCEPTED);
    }

    
    @RequestMapping( value = "/{primenumber}", method = GET )
    public ResponseEntity<?> getPrimesNumber(@PathVariable String primenumber) {
    	
        return new ResponseEntity<>(primeService.getPrime(primenumber), HttpStatus.ACCEPTED);
    }
    
    
    @RequestMapping(method = RequestMethod.POST)	
	public ResponseEntity<?> manejadorPostRecursoXX(@RequestBody FoundPrime foundPrime) {
    	boolean flag = false;
    	
			try {
				primeService.addFoundPrime(foundPrime);
				flag = true;
			} catch (Exception e) {
				return new ResponseEntity<>("Error, not primes add", HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(flag, HttpStatus.ACCEPTED);
			
		
    }



}
