package chat.api.repository;

import chat.entity.Group;
import chat.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface IGroupRepository {

    Group findById(@NotNull final String id);

    void remove(@NotNull final Group group);

    void persist(@NotNull Group group);

    Group merge(@NotNull final Group group);

    Collection<Group> sortAllByUserId(@NotNull final User user, @NotNull final String parameter);
}
