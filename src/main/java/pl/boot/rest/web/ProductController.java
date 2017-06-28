package pl.boot.rest.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.boot.rest.domain.Product;
import pl.boot.rest.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProducts() {		
		
		List<Product> products = productRepository.findAll();
		
		if(products.isEmpty()){
            return ResponseEntity.noContent().build();
        }
		
        return ResponseEntity.ok(products);			
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> find(@PathVariable("id") Integer id) {
		
		Product product = productRepository.findOne(id);
		
		if(product == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(product);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<Void> create(@Valid @RequestBody Product productDTO) throws URISyntaxException {
		
		Product product = productRepository.findByProductCode(productDTO.getProductCode());
		
		if (product != null) {            
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
		
		productRepository.save(productDTO);
		
		return ResponseEntity.created(new URI("http://localhost/products/" + productDTO.getId())).build();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
 
		Product product = productRepository.findOne(id);
		
		if(product == null) {
			return ResponseEntity.notFound().build();
		}

		productRepository.delete(id);
		
        return ResponseEntity.noContent().build();
    }
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> update(@PathVariable("id") Integer id, @RequestBody Product productDTO) {
         
		Product product = productRepository.findOne(id);
		
		if(product == null) {
			return ResponseEntity.notFound().build();
		}

		product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setProductCode(productDTO.getProductCode());
        product.setProductName(productDTO.getProductName());
        product.setReleaseDate(productDTO.getReleaseDate());
        product.setStarRating(productDTO.getStarRating());
        
        productRepository.save(product);
        
        return new ResponseEntity<>(productDTO, HttpStatus.OK);        
    }
	
	
	
	
}
