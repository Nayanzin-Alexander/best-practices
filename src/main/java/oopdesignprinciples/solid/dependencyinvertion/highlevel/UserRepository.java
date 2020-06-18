package oopdesignprinciples.solid.dependencyinvertion.highlevel;

import oopdesignprinciples.solid.dependencyinvertion.entitiy.User;

public interface UserRepository {

    long save(User user);

    User findById(long id);
}
