package com.appsdeveloper.estore.data;

import com.appsdeveloper.estore.model.User;

public interface UserRepository {

    boolean save(User user);
}
