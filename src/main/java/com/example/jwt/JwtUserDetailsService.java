package com.example.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.models.Person;
import com.example.repositories.PersonRepository;


@Service
public class JwtUserDetailsService implements UserDetailsService {
     @Autowired
	private PersonRepository personRepo;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	  Person person = personRepo.findByEmail(email);

    if (!person.getEmail().equals(email)) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", email));
    }
    JwtUserDetails jwtUser= new JwtUserDetails( person.getEmail(),
	     person.getPassword(),"user" );

    return jwtUser;
  }
}


