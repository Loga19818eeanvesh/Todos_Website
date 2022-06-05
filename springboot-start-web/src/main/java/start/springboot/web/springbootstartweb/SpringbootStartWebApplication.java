package start.springboot.web.springbootstartweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import start.springboot.web.springbootstartweb.model.User;
import start.springboot.web.springbootstartweb.repository.UserRepository;



@SpringBootApplication
public class SpringbootStartWebApplication implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootStartWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User("user1","usr1","pwd1",true,"ROLE_ADMIN"); 
		userRepository.save(user);
	}

}
