package com.appsdeveloper.estore.data;

import com.appsdeveloper.estore.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    Map<String,User> users = new HashMap<>();
    @Override
    public boolean save(User user) {
        boolean isUserAvailable = false;
        if(!users.containsKey(user.getId())){
          users.put(user.getId(), user);
            isUserAvailable = true;

        }
        return isUserAvailable;
    }
}
