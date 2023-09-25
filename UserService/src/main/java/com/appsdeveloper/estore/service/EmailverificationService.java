package com.appsdeveloper.estore.service;

import com.appsdeveloper.estore.model.User;

public interface EmailverificationService {

    void emailConfirmation(User user);
}
