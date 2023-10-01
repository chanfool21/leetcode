package makemytrip.service.impl;

import makemytrip.models.User;
import makemytrip.service.UserService;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private Map<String, User> userMap;

    public UserServiceImpl() {
        this.userMap = new HashMap<>();
    }

    @Override
    public void addUser(User user) {
        // Assuming user will be unique object  where userId will be created at upper layer and passed here
        userMap.put(user.getId(), user);
    }

    @Override
    public User getUserById(String userId) {
        return userMap.get(userId);
    }
}
