package com.ihub;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

	@Autowired
	private UserJPARepository userRepository;
	
	//select user by id
	@RequestMapping(value="/getuser", method=RequestMethod.GET)
	Optional<Users> getUser(@RequestParam Integer id)
	{
		return userRepository.findById(id);
		
	}
	//insert user
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	Users insertUser(@RequestBody Users user)
	{
		Users savedUser=userRepository.save(user);
		return savedUser;
	}
	//update user
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	Users updateUser(@RequestBody Users user)
	{
		Users updatedUser=userRepository.save(user);
		return updatedUser;
	}
	//delete user
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	Map deleteUser(@RequestParam Integer id)
	{
		userRepository.deleteById(id);
		Map<String,String> status=new HashMap<>();
		status.put("Status", "Success");
		return status;
	}
	//selects all users
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	List<Users> getAllUsers(){
        return userRepository.findAll();
    }
	//insert list of users
	@RequestMapping(value="/insertAll",method=RequestMethod.POST)
	String addAllUsers(@RequestBody List<Users> userList)
	{
		userRepository.saveAll(userList);
		return "SUCCESS";
	}
	@RequestMapping(value="/deleteAll",method=RequestMethod.DELETE)
	String deleteAllUsers()
	{
		userRepository.deleteAll();
		return "SUCCESS";
	}
	

}
