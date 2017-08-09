package com.translate.service.demo;

import org.springframework.ui.Model;

public interface HelloService {

  String greeting(String name, Model model);
}
