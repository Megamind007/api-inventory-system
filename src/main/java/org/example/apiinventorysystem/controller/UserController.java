package org.example.apiinventorysystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.apiinventorysystem.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/users")
@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
}
