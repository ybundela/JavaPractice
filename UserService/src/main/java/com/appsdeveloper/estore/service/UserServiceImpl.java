package com.appsdeveloper.estore.service;

import com.appsdeveloper.estore.data.UserRepository;
import com.appsdeveloper.estore.data.UserRepositoryImpl;
import com.appsdeveloper.estore.model.User;

import java.util.UUID;

public class UserServiceImpl implements UserService {


    UserRepository userRepository;

    EmailverificationService emailverificationService;

    public UserServiceImpl(UserRepository userRepository, EmailverificationService emailverificationService) {
        this.userRepository = userRepository;
        this.emailverificationService = emailverificationService;
    }
    @Override
    public User createUser(String firstName, String lastName, String email, String password, String repeatPassword) {

        if(firstName == null || firstName.trim().length()==0){
         throw new IllegalArgumentException("User firstName is Empty");
        }
        User user = new User(firstName, lastName, email, UUID.randomUUID().toString());
       boolean isUserCreated;

       try{
           isUserCreated  =  userRepository.save(user);
       }catch(RuntimeException e){
           throw new UserServiceException(e.getMessage());
       }
       if(!isUserCreated)throw new UserServiceException("Could not create the user");

       try{
           emailverificationService.emailConfirmation(user);
       }catch (RuntimeException ex){
           throw new UserServiceException(ex.getMessage());
       }
      return user;
    }

    @Override
    public boolean validadPassword(String password, String repeatPassword) {
        boolean isValidPassword = false;
        if(password.equalsIgnoreCase(repeatPassword)){
            isValidPassword = true;
        }
        return isValidPassword;
    }
}
