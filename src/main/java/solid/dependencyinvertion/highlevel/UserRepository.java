package solid.dependencyinvertion.highlevel;

import solid.dependencyinvertion.entitiy.User;

public interface UserRepository {

    long save(User user);

    User findById(long id);
}
