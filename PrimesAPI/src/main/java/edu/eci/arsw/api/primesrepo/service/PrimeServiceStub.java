package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.blueprints.exception.FoundPrimeException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */
@Component("PrimeServiceStub")
public class PrimeServiceStub implements PrimeService
{	
	ArrayList<FoundPrime> fp = new ArrayList<FoundPrime>();
	
    @Override
    public void addFoundPrime( FoundPrime foundPrime ) throws FoundPrimeException
    {	 
    	FoundPrime f = getPrime(foundPrime.getPrime());
    	if (f != null && !f.getUser().equals(foundPrime.getUser())) {
    		throw new FoundPrimeException("No puede añadir ese número primo, es del usuario " + f.getUser());
    	} else if (f != null && f.getUser().equals(foundPrime.getUser())) {
    		throw new FoundPrimeException("No puede añadir el numero dos veces " + f.getUser());
    	}
    	fp.add(foundPrime);
    }

    @Override
    public List<FoundPrime> getFoundPrimes()
    {
        //TODO
        return fp;
    }

    @Override
    public FoundPrime getPrime( String prime )
    {
        //TODO
        for (FoundPrime fp: this.fp) {
        	if (fp.getPrime().equals(prime)) return fp;
        }
        
        return null;
    }
}
