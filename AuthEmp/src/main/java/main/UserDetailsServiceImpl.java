package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private EmployeeRepo userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		Employee users = userRepository.findByEmpName(username);

		if (users == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		
		System.out.println("\t=====> UserDetailsServiceImpl: " + users.getEmpName());
		return new MyUserDetails(users);
	}

}
