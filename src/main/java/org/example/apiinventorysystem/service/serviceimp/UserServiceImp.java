package org.example.apiinventorysystem.service.serviceimp;

import lombok.RequiredArgsConstructor;
import org.example.apiinventorysystem.repository.UserRepository;
import org.example.apiinventorysystem.service.UserService;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
	private final UserRepository userRepository;
}
