package chat.service;

import chat.api.service.IGroupService;
import chat.entity.Group;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class GroupService implements IGroupService {
    @Override
    public Group findByIdAndUserId(@NotNull String id, @NotNull String userId) {
        return null;
    }

    @Override
    public Group removeByIdAndUserId(@NotNull String id, @NotNull String userId) {
        return null;
    }

    @Override
    public Group save(@NotNull String id, @NotNull String name) {
        return null;
    }
}
