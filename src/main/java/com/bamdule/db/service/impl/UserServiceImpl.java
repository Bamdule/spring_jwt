package com.bamdule.db.service.impl;

import com.bamdule.db.mapper.UserMapper;
import com.bamdule.model.UserVO;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.bamdule.db.service.UserService;
import java.util.List;

/**
 *
 * @author kim
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<UserVO> selectUsers() {
        return userMapper.selectUsers();
    }

    @Override
    public Optional<UserVO> selectByEmail(String email) {
        return Optional.ofNullable(userMapper.selectByEmail(email));
    }

    @Override
    public void saveUser(UserVO userVO) {

        Optional<UserVO> u = this.selectByEmail(userVO.getEmail());

        System.out.println("[MYTEST] optional : " + u);

        if (u.isPresent()) {
            throw new RuntimeException("This email already exists");
        } else {
            userVO.setPassword(passwordEncoder.encode(userVO.getPassword()));
            userMapper.saveUser(userVO);
        }

    }

}
