package com.flex.neoflex.services;

import com.flex.neoflex.models.ProfileRequest;
import com.flex.neoflex.models.User;

public interface UserService {
	void createProfile(ProfileRequest request);

	Iterable<User> getUser(ProfileRequest request);

	Iterable<User> getUserById(int id);
}