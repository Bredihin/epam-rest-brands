package com.epam.rest.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.rest.entity.User;
import com.epam.rest.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userServices;

	private static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/json", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<User>> getusers(Model model) throws Exception {
		logger.debug("Received request to show all users");
		List<User> users = userServices.getUserList();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	// @RequestMapping(value = "/subscriptions", produces = {
	// MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	// @ResponseBody
	// public ResponseEntity<Set<SubscriptionShow>>
	// getSubscriptionShow(@RequestParam(value = "id", required = true) Integer
	// id, Model model) throws Exception {
	// Set<SubscriptionShow> subscriptionShow =
	// userServices.getUserById(id).getSubscriptionsShow();
	// return new ResponseEntity<Set<SubscriptionShow>>(subscriptionShow,
	// HttpStatus.OK);
	// }

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getUsers(Model model) throws Exception {
		logger.debug("Received request to show all users");
		List<User> users = userServices.getUserList();
		model.addAttribute("users", users);
		return "userpage";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAdd(Model model) {
		logger.debug("Received request to show add page");
		model.addAttribute("userAttribute", new User());
		return "addpage";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("userAttribute") User user) throws Exception {
		logger.debug("Received request to add new user");
		userServices.addUser(user);
		return "addedpage";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value = "id", required = true) Integer id, Model model) throws Exception {

		logger.debug("Received request to delete existing user");
		userServices.deleteUser(id);
		model.addAttribute("id", id);
		return "deletedpage";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getEdit(@RequestParam(value = "id", required = true) Integer id, Model model) throws Exception {
		logger.debug("Received request to show edit page");
		model.addAttribute("userAttribute", userServices.getUserById(id));
		return "editpage";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("userAttribute") User user, @RequestParam(value = "id", required = true) Integer id, Model model) throws Exception {
		logger.debug("Received request to update user");
		userServices.editUser(user.getUserId());
		model.addAttribute("id", id);
		return "editedpage";
	}
}
