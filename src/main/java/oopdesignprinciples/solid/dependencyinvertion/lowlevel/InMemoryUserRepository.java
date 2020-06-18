package oopdesignprinciples.solid.dependencyinvertion.lowlevel;

import static java.util.Objects.isNull;

import java.util.HashMap;
import java.util.Map;
import oopdesignprinciples.solid.dependencyinvertion.entitiy.User;
import oopdesignprinciples.solid.dependencyinvertion.highlevel.UserRepository;

public class InMemoryUserRepository implements UserRepository {

    private long idCounter = 0L;
    private Map<Long, User> users = new HashMap<>();

    @Override
    public long save(User user) {
        if (isNull(user.getId())) {
            user.setId(getNextUserId());
        }
        users.put(user.getId(), user);
        return user.getId();
    }

    private long getNextUserId() {
        return idCounter++;
    }

    @Override
    public User findById(long id) {
        return users.get(id);
    }
}
