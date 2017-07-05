package pkg.service;

import org.springframework.stereotype.Service;
import pkg.model.Role;
import pkg.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static final AtomicLong counter = new AtomicLong();

    private static List<User> users;

    static {
        users = populateDummyUsers();
    }

    public List<User> findAllUsers() {
        return users;
    }

    public User findById(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User findByName(String name) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    public void saveUser(User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
    }

    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    public void deleteUserById(long id) {
        users.removeIf(user -> user.getId() == id);
    }

    public boolean isUserExist(User user) {
        return findByName(user.getUsername()) != null;
    }

    public void deleteAllUsers() {
        users.clear();
    }

    private static List<User> populateDummyUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(counter.incrementAndGet(), "Sam", "asd123", 30, 70000, Role.USER));
        users.add(new User(counter.incrementAndGet(), "Tom", "asd123", 40, 50000, Role.USER));
        users.add(new User(counter.incrementAndGet(), "Jerome", "asd123", 45, 30000, Role.USER));
        users.add(new User(counter.incrementAndGet(), "Silvia", "asd123", 50, 40000, Role.ADMIN));
        users.add(new User(counter.incrementAndGet(), "asd", "123", 50, 40000, Role.USER));
        return users;
    }

}
