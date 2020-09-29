package com.bamdule.db.mapper;

import com.bamdule.model.UserVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author kim
 */
@Mapper
public interface UserMapper {

    public List<UserVO> selectUsers();

    public UserVO selectByEmail(String email);

    public void saveUser(UserVO userVO);
}
