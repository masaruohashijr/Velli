package com.vindixit.velli;

import java.util.ArrayList;
import java.util.List;

import com.vindixit.velli.office.Office;
import com.vindixit.velli.office.OfficeRepository;
import com.vindixit.velli.role.Role;
import com.vindixit.velli.role.RoleRepository;
import com.vindixit.velli.user.User;
import com.vindixit.velli.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VelliApplication {
	@Autowired 
	private OfficeRepository officeRepository;
	@Autowired 
	private RoleRepository roleRepository;
	public static void main(String[] args) {
		SpringApplication.run(VelliApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			repository.deleteAll();
			officeRepository.deleteAll();
			User user = new User();
			user.setName("Fulano");
			user.setEmail("fulano@gmail.com");
			Office office = new Office();
			Role role = new Role();
			office.setName("ERDF");
			role.setName("Chefe");
			List<User> users = new ArrayList<User>();
			users.add(user);
			office.setUsers(users);
			role.setUsers(users);
			roleRepository.save(role);
			office.setChief(user);
			user.setRole(role);
			user.setOffice(office);
			officeRepository.save(office);
			repository.findAll().forEach(u -> {
				System.out.println(u.getName());
				System.out.println(u.getOffice().getName());
				System.out.println(u.getRole().getName());
			});
		};
	}

}
