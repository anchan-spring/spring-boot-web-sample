package example.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.boot.entity.UserEntity;
import example.boot.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public List<UserEntity> selectAll(){
		return userMapper.selectAll();
	}
}
