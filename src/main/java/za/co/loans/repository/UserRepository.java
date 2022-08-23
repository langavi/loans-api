package za.co.loans.repository;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import za.co.loans.domain.user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository
public class UserRepository {

    private Map<String, User> users = new HashMap<>();

    public void add(User user) {
        if (Objects.isNull(users))
            users = new HashMap<>();

        if (!users.containsKey(user.getEmailAddress())) {
            users.put(user.getEmailAddress(), user);
        }
    }

    public boolean exists(User user) {
        if (!CollectionUtils.isEmpty(users) && users.containsKey(user.getEmailAddress())) {
            User existingUser = users.get(user.getEmailAddress());
            return Objects.equals(existingUser.getPassword(), user.getPassword());
        }
        return false;
    }

    public void deleteAll() {
        if (!CollectionUtils.isEmpty(users))
            users.clear();
    }

    public void update(User user) {
        if (!CollectionUtils.isEmpty(users) && users.containsKey(user.getEmailAddress())) {
            users.replace(user.getEmailAddress(), user);
        } else {
            add(user);
        }
    }
}
