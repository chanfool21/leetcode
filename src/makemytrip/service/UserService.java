package makemytrip.service;

import makemytrip.models.User;

public interface UserService {
    void addUser(User user);
    User getUserById(String userId);
}
