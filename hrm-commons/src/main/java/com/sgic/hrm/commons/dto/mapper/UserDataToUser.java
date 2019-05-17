package com.sgic.hrm.commons.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.UserData;
import com.sgic.hrm.commons.entity.User;

public class UserDataToUser {

	

  public UserDataToUser() {

	}

public static User mapToUser(UserData userData) {
    User user = new User();
    if (userData != null) {
      user.setId(userData.getId());
      user.setFullName(userData.getFullName());
    }
    return user;
  }

  public static List<User> mapToUserList(List<UserData> userDataList) {
    List<User> userList = new ArrayList<User>();
    if (userDataList != null) {
      for (UserData userData : userDataList) {
        userList.add(mapToUser(userData));
      }
    }
    return userList;
  }
}
