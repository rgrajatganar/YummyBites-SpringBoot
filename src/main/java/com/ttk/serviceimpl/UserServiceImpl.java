package com.ttk.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttk.entity.User;
import com.ttk.exception.UserNotFoundException;
import com.ttk.repository.UserRepository;
import com.ttk.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository uRepo;
	@Override
	public User addUser(User user) {
		return uRepo.save(user);
	}

	@Override
	public User getUserDetail(int uid) {
		return uRepo.findById(uid).
				orElseThrow(()-> new UserNotFoundException("User id is not corrected"));
	}

	@Override
	public User updateUserDetail(User user, int uid) {
		User UpdateUser = uRepo.findById(uid).
				orElseThrow(()-> new UserNotFoundException("User id is not corrected"));
				// set new value
		//Student.setSphone(student.getSphone());
		UpdateUser.setUphone(user.getUphone());
		UpdateUser.setUaddr(user.getUaddr());
		uRepo.save(UpdateUser);
		return UpdateUser;
	}

	@Override
	public void deleteUserDetail(int uid) {
		User delUser =uRepo.findById(uid).
				orElseThrow(()-> new UserNotFoundException("User id is not corrected"));
		uRepo.delete(delUser);
		
	}


}
