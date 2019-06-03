package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.UserDTO;
import it.contrader.services.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Home")
public class HomeController {

	private final UserService userService;

	@Autowired
	public HomeController(UserService userService) {
		this.userService = userService;
	}



	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
	public List<UserDTO> userManagement(HttpServletRequest request) {
		
		return this.userService.getListaUserDTO();
	}

/*
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
	
		return "index";
	}
*/
	
}