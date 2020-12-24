package com.example.openservice.service;

import com.example.openservice.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Map<Long, User> MOKE_DB_DATA = new HashMap<>();

    static {
        User _user1 = User.builder().id(10000L).age(23).username("username1").password("dddddddddddddddddddddd").build();
        User _user2 = User.builder().id(10001L).age(24).username("username2").password("hhhhhhhhhhhhhh").build();
        User _user3 = User.builder().id(10002L).age(25).username("username3").password("mmmmmmmmmmmmmmm").build();

        MOKE_DB_DATA.put(10000L,_user1);
        MOKE_DB_DATA.put(10001L,_user2);
        MOKE_DB_DATA.put(10002L,_user3);
    }


    public void  addUser(User user) {
        Long key = System.currentTimeMillis();
        user.setId(key);
        MOKE_DB_DATA.put(key,user);
    }

    public void  updateUser(User user) {
        MOKE_DB_DATA.replace(user.getId(),user);
    }

    public void  deleteUser(Long id) {
        MOKE_DB_DATA.remove(id);
    }

    public Collection<User> AllUser() {
        return new ArrayList<>(MOKE_DB_DATA.values());
    }

    public User user(Long id) {
        return MOKE_DB_DATA.get(id);
    }
}
