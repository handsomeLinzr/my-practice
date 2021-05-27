package com.example.block;

import java.util.concurrent.TimeUnit;

public class UserService {

    public static PointService pointService = new PointService();

    public User register(String name) {
        User user = new User();
        user.setName(name);
        pointService.addUser(user);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user;
    }

}
