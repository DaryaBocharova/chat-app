package chat.api.repository;

import chat.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository {

    User findById(@NotNull final String id);

    void remove(@NotNull User user);

    void persist(@NotNull User user);
}
