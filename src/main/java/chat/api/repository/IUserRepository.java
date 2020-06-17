package chat.api.repository;

import chat.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository {

    User findById(@NotNull final String id);

    User removeById(@NotNull final String id);

    User create( @NotNull final String id,
                 @NotNull final String name);
}
