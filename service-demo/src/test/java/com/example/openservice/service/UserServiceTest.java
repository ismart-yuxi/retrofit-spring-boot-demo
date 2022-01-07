package com.example.openservice.service;

import com.example.openservice.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class UserServiceTest {

    static Map<Long, User> MOCK_DB_DATA = new HashMap<>();


    @BeforeAll
    static void initData() {
        User _user1 = User.builder().id(10000L).age(23).username("username1").password("dddddddddddddddddddddd").build();
        User _user2 = User.builder().id(10001L).age(24).username("username2").password("hhhhhhhhhhhhhh").build();
        User _user3 = User.builder().id(10002L).age(25).username("username3").password("mmmmmmmmmmmmmmm").build();

        MOCK_DB_DATA.put(10000L, _user1);
        MOCK_DB_DATA.put(10001L, _user2);
        MOCK_DB_DATA.put(10002L, _user3);
    }

    @InjectMocks
    UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void testAddUser() {
        userService.addUser(new User(10004L, "username", 0, "password"));
    }

    @Test
    void testUpdateUser() {
        userService.updateUser(new User(10001L, "username", 0, "password"));
    }

    @Test
    void testDeleteUser() {
        userService.deleteUser(10002L);
//        Assertions.assertDoesNotThrow();
    }

    @Test
    void testAllUser() {
        Collection<User> result = userService.AllUser();
        Assertions.assertEquals(MOCK_DB_DATA.size()+1, result.size());
    }

    @Test
    void testUser() throws JsonProcessingException {
        User result = userService.user(10000L);
        ObjectMapper om = new ObjectMapper();
        String resultStr = om.writeValueAsString(result);
        String MockDataStr = om.writeValueAsString(MOCK_DB_DATA.get(10000L));
        Assertions.assertEquals(MockDataStr, resultStr);
    }
}

