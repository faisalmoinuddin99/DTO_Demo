package net.javaguide.springboot;

import net.javaguide.springboot.model.Location;
import net.javaguide.springboot.model.User;
import net.javaguide.springboot.repository.LocationRepository;
import net.javaguide.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDtoTutApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDtoTutApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository ;

	@Autowired
	private LocationRepository locationRepository ;



	@Override
	public void run(String... args) throws Exception {

		Location location1 = new Location() ;
		location1.setPlace("Pune");
		location1.setDescription("One of the best city in Maharashtra after Mumbai");
		location1.setLongitude(400.32);
		location1.setLatitude(125.03);
		locationRepository.save(location1) ;

		Location location2 = new Location() ;
		location2.setLatitude(500.36);
		location2.setLongitude(78.32);
		location2.setPlace("Mumbai");
		location2.setDescription("Best city to live");
		locationRepository.save(location2) ;

		User user1 = new User() ;
		user1.setFirstName("Leo");
		user1.setLastName("Messi");
		user1.setEmail("messi@gmail.com") ;
		user1.setLocation(location1);
		user1.setPassword("messi123");
		userRepository.save(user1) ;

		User user2 = new User() ;
		user2.setFirstName("Cristinao");
		user2.setLastName("Ronaldo");
		user2.setEmail("ronaldo@yahoo.com");
		user2.setLocation(location2);
		user2.setPassword("cr7");
		userRepository.save(user2) ;
	}
}
