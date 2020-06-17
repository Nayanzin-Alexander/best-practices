package solid.dependencyinvertion.highlevel;

import solid.dependencyinvertion.entitiy.User;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public long save(User user) {
        return userRepository.save(user);
    }

    public User getById(long id) {
        return userRepository.findById(id);
    }
}
