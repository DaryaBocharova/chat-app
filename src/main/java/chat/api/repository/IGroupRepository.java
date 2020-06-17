package chat.api.repository;

import chat.entity.Group;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IGroupRepository {

    Group findById(@NotNull final String id);

    Group removeById(@NotNull final String id);

    Group create(@NotNull final String id,
                  @NotNull final String name);
}
