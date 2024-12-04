package org.example.apiinventorysystem.model.request;


import org.example.apiinventorysystem.model.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
	private String username;
	private String gender;
	private String telephone;
	private String address;
	private String email;
	private String password;

	public User toEntity(){
		return new User().builder()
			.address(address)
			.email(email)
			.gender(gender)
			.username(username)
			.telephone(telephone)
			.password(password)
			.build();
	}
}
