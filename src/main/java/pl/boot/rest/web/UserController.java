package pl.boot.rest.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import pl.boot.rest.service.UserService;
import pl.boot.rest.domain.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers() {		
		
		List<User> users = userService.findAll();
		
		if(users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
		
        return new ResponseEntity<>(users, HttpStatus.OK);			
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable Integer userId) {
		
		User user = userService.findOne(userId);
		
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(user, HttpStatus.OK);	
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> delete(@PathVariable Integer userId) {
		
		User user = userService.findOne(userId);
		
        if (user == null) {            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
 
        userService.delete(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	@PostMapping
	ResponseEntity<Void> create(@Valid @RequestBody User userDTO, UriComponentsBuilder ucBuilder) {
		
		User user = userService.findByUsername(userDTO);
		
        if (user != null) {            
            return new ResponseEntity<>(HttpStatus.CONFLICT);        	
        }
        
        userService.save(userDTO);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(userDTO.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
                 
	}
	
	//@PutMapping - doesn't work?
	@RequestMapping(value = "{userId}", method = RequestMethod.PUT)
    public ResponseEntity<User> update(@PathVariable Integer userId, @Valid @RequestBody User userDTO) {
         
        User user = userService.findOne(userId);
         
        if (user==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
 
        user.setUsername(userDTO.getUsername());
        user.setIsActive(userDTO.getIsActive());
        user.setCreated(userDTO.getCreated());
        
        userService.save(user);
        
        return new ResponseEntity<>(user, HttpStatus.OK);        
    }
}
