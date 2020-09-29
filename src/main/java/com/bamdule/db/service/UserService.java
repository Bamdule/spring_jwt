package com.bamdule.db.service;

import com.bamdule.model.UserVO;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author kim
 */
public interface UserService {

    List<UserVO> selectUsers();

    Optional<UserVO> selectByEmail(String email);

    void saveUser(UserVO userVO);

}
