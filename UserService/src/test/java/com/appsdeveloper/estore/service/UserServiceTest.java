package com.appsdeveloper.estore.service;

import com.appsdeveloper.estore.data.UserRepository;
import com.appsdeveloper.estore.model.User;
import com.appsdeveloper.estore.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @Mock
    EmailverificationServiceImpl emailverificationService;
    @InjectMocks
     UserServiceImpl userService;
     String firstName;
     String lastName;
     String email;
     String password;
     String repeatPassword;

    @BeforeEach
    void init(){
         firstName = "Yogi";
         lastName = "Bundela";
         email = "yogi@junit.com";
         password = "Monday1212";
         repeatPassword ="Monday1212";
    }
    @DisplayName("User Object Created")
    @Test
    void testCreateUser_whenUserDetailsProvided_returnUserObject(){

        //Arrange
        Mockito.when(userRepository.save(any(User.class))).thenReturn(true);
        //Act
        User user  = userService.createUser(firstName,lastName,email,password,repeatPassword);

        //Assert
        assertNotNull(user,"Create user method should not return null");
        assertEquals(firstName,user.getFirstName(),"User firstName is incorrect");
        assertEquals(lastName,user.getLastName(),"User lastName is incorrect");
        assertEquals(email,user.getEmail(),"User email is incorrect");
        assertNotNull(user.getId(),"User Id is missing");
        Mockito.verify(userRepository).save(any(User.class));


    }

    @DisplayName("Empty fiestName cause correct exception")
    @Test
    void testCreatUser_WhenFirstNameIsEmpty_throwIllegalArgumentExepction(){
        String firstName = "";
        String expectedErrorMessage = "User firstName is Empty";

        //Act & Assert
        IllegalArgumentException errorDetails = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            userService.createUser(firstName,lastName,email,password,repeatPassword);
        },"Empty fistName should have cause illegalArgument Exception");

        //Assert
       assertEquals(expectedErrorMessage,errorDetails.getMessage(),"Exception error message is not correct");
    }

    @DisplayName("Validate password, when passsword and repeatpassword matches")
    @Test
    void testPassword_WhenValidPasswordProvided_returnSucessLogin(){
        //Arrange
        String password = "Monday121!";
        String repeatPassword = "Monday121!";
        //Act
        boolean isValidPassword  = userService.validadPassword(password,repeatPassword);

        //Assert
        assertTrue(isValidPassword,"Entered password is not valid");

    }

    @DisplayName("if save() method cause runtimeexception , Userservices exception will get thrown")
    @Test
    void testCreateUser_whenSaveMethodThrowsException_ThenThrowUserServiceException(){
        //Arrange
        when(userRepository.save(any(User.class))).thenThrow(RuntimeException.class);

        //Act & Assert

        assertThrows(UserServiceException.class , () ->{
            userService.createUser(firstName,lastName,email,password,repeatPassword);
        }, "Should have thrown UserserviceException instead");
        //Assert
    }

    @Test
    @DisplayName("Email notification exceptioon is handle")
    void testCreateUser_whenEmailNotificationExceptionThrown_thorowUserServiceException(){
     //Arrange
        when(userRepository.save(any(User.class))).thenReturn(true);
        doThrow(EmailServicesException.class)
                .when(emailverificationService).emailConfirmation(any(User.class));

        assertThrows(UserServiceException.class, ()-> {
            userService.createUser(firstName,lastName,email,password,repeatPassword);
        }, "Should have thrown UserServices Exception instead");

        verify(emailverificationService,times(1)).emailConfirmation(any(User.class));
    }


}
