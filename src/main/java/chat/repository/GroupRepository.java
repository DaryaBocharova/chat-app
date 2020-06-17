package chat.repository;

import chat.api.repository.IGroupRepository;
import chat.entity.Group;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

@Repository
public class GroupRepository implements IGroupRepository {

    @Override
    public Group findById(@NotNull String id) {
        return null;
    }

    @Override
    public Group removeById(@NotNull String id) {
        return null;
    }

    @Override
    public Group create(@NotNull String id, @NotNull String name) {
        return null;
    }
}
