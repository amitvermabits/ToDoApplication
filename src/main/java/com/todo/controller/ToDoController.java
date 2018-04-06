package com.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToDoController {

	@RequestMapping("/todo")
	public String home() {
		return "index";
	}

}
