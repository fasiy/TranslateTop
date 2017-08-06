package com.translate.controller;

import org.springframework.ui.Model;

public interface HelloController {
	String greeting(String name, Model model);
}
