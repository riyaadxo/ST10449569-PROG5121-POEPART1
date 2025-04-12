/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poepart1progmain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */

public class LoginTest {

    @Test
    public void testCheckUserName_Valid() {
        Login login = new Login("user_1", "Password1!", "+27831234567", "Riyaad", "Khalifa");
        assertTrue(login.checkUserName());
    }

    @Test
    public void testCheckUserName_Invalid() {
        Login login = new Login("user!", "Password1!", "+27831234567", "Riyaad", "Khalifa");
        assertFalse(login.checkUserName());
    }

    @Test
    public void testCheckPasswordComplexity_Valid() {
        Login login = new Login("user_1", "Ch&&sec@ke99!", "+27831234567", "Riyaad", "Khalifa");
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testCheckPasswordComplexity_Invalid() {
        Login login = new Login("user_1", "password", "+27831234567", "Riyaad", "Khalifa");
        assertFalse(login.checkPasswordComplexity());
    }

    @Test
    public void testCheckCellPhoneNumber_Valid() {
        Login login = new Login("user_1", "Password1!", "+27831234567", "Riyaad", "Khalifa");
        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    public void testCheckCellPhoneNumber_Invalid() {
        Login login = new Login("user_1", "Password1!", "08966553", "Riyaad", "Khalifa");
        assertFalse(login.checkCellPhoneNumber());
    }

    @Test
    public void testRegisterUser_Valid() {
        Login login = new Login("u_1", "Password1!", "+27831234567", "Riyaad", "Khalifa");
        String message = login.registerUser();
        assertTrue(message.contains("Username successfully captured"));
        assertTrue(message.contains("Password successfully captured"));
        assertTrue(message.contains("Cell phone number successfully added."));
    }

    @Test
    public void testRegisterUser_Invalid() {
        Login login = new Login("user!", "password", "08966553", "Riyaad", "Khalifa");
        String message = login.registerUser();
        assertTrue(message.contains("Username is not correctly formatted"));
        assertTrue(message.contains("Password is not correctly formatted"));
        assertTrue(message.contains("Cell phone number incorrectly formatted"));
    }

    @Test
    public void testLoginUser_Success() {
        Login login = new Login("user_1", "Password1!", "+27831234567", "Riyaad", "Khalifa");
        login.registerUser();  // simulate registration first
        assertTrue(login.loginUser("user_1", "Password1!"));
    }

    @Test
    public void testLoginUser_Failure() {
        Login login = new Login("user_1", "Password1!", "+27831234567", "Riyaad", "Khalifa");
        login.registerUser();
        assertFalse(login.loginUser("wrong_user", "wrongpass"));
    }

    @Test
    public void testReturnLoginStatus_Success() {
        Login login = new Login("user_1", "Password1!", "+27831234567", "Riyaad", "Khalifa");
        String status = login.returnLoginStatus(true);
        assertEquals("Welcome Riyaad, Khalifa it is great to see you again.", status);
    }

    @Test
    public void testReturnLoginStatus_Failure() {
        Login login = new Login("user_1", "Password1!", "+27831234567", "Riyaad", "Khalifa");
        String status = login.returnLoginStatus(false);
        assertEquals("Username or password incorrect, please try again.", status);
    }
}
