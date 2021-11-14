package it.prova.spring.boot;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.prova.spring.boot.user.exceptions.UserVoidException;

@RestController
public class UserController {
	private final UserRepository userRepository;
	
	private static final Logger logger = LogManager.getLogger(UserController.class);

	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@GetMapping("/users")
	Iterable<UserTable> getUsers(){
		logger.info("Ricerco la lista di tutti gli utenti");
		return userRepository.findAll();
	}
	
	@PostMapping("/user")
	UserTable createUser(@RequestBody UserTable newUserTable) throws UserVoidException {
		if (newUserTable != null && StringUtils.isNotBlank(newUserTable.getNome())) {
			logger.info("Inserisco l'utente: "+newUserTable.getNome());
			return userRepository.save(newUserTable);
		}else {
			throw new UserVoidException("Utente in input non correttamente valorizzato");
		}
		
	}
	
	@GetMapping("/getUser")
	Optional<UserTable> getUserParam(@RequestParam Integer userId){
		return userRepository.findById(userId);
	}
	
	@GetMapping("/getUser/{userId}")
	Optional<UserTable> getUser(@PathVariable Integer userId){
		return userRepository.findById(userId);
	}
	
	@PutMapping("/updateUser/{userId}")
	UserTable updateUser(@PathVariable Integer userId, @RequestBody UserTable userTable){
		
		Optional<UserTable> utente = userRepository.findById(userId);
		
		utente.get().setCognome(userTable.getCognome());
		utente.get().setNome(userTable.getNome());
		utente.get().setPassword(userTable.getPassword());
		
		return userRepository.save(utente.get());
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	void deleteUser(@PathVariable Integer userId){
		userRepository.deleteById(userId);
	}
}
