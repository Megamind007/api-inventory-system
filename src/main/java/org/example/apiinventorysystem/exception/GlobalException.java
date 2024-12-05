package org.example.apiinventorysystem.exception;

import org.example.apiinventorysystem.model.response.ApiResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Configuration
public class GlobalException {
	@ExceptionHandler(NotfoundException.class)
	public ApiResponse<?> handleNotfoundException(NotfoundException e) {
		return null;
	}
}
