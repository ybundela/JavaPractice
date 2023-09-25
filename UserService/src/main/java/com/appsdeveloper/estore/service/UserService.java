package com.appsdeveloper.estore.service;

import com.appsdeveloper.estore.model.User;

public interface UserService {

    User createUser(String firstName, String lastName, String email, String password, String repeatPassword);

    boolean validadPassword(String password, String repeatPassword);
}
