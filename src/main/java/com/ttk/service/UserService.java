package com.ttk.service;

import com.ttk.entity.User;

public interface UserService {

	// save User details in db table
			User addUser(User user);

			// method to fetch User detail based on uid from db table
			User getUserDetail(int uid);

			//method to modify User detail based on uid from db table
			User updateUserDetail(User user, int uid);

			//method to remove User detail based on uid from db table
			void deleteUserDetail(int uid);

}
