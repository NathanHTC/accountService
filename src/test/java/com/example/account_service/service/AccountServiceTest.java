package com.example.account_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.account_service.model.UserProfile;
import com.example.account_service.repository.UserProfileRepos;
import com.example.exception.service_exception.UserNotFoundException;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {
   
   //creates a mock
   @Mock
   private UserProfileRepos userProfileRepos;

   //create a instance of the class and injects the mocks into it
   @InjectMocks
   private AccountService accountService;

   @Test
   void testGetUserById_Success() {
      UserProfile mockUser = new UserProfile();
      mockUser.setId(1L);
      mockUser.setEmail("test@gmail.com");

      when(userProfileRepos.findById(1L)).thenReturn(Optional.of(mockUser));
      UserProfile user = accountService.getUserById(1L);

      assertNotNull(user);
      assertEquals(mockUser.getEmail(), user.getEmail());
   }
   
   @Test
   void testGetUserById_NotFound() {
      when(userProfileRepos.findById(2L)).thenReturn(Optional.empty());
      assertThrows(UserNotFoundException.class, () -> accountService.getUserById(2L));
   }

   
}
