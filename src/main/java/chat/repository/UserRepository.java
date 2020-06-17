package chat.repository;

import chat.api.repository.IUserRepository;
import chat.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository {
    @Override
    public User findById(@NotNull String id) {
        return null;
    }

    @Override
    public User removeById(@NotNull String id) {
        return null;
    }

    @Override
    public User create(@NotNull String id, @NotNull String name) {
        return null;
    }
}
