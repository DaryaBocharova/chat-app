package chat.api.service;

import chat.entity.Group;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
public interface IGroupService {

    Group findById(@NotNull final String id, @NotNull final String userId);

    void remove(@Nullable final String id, @Nullable final String userId);

    void create(@NotNull final String id, @NotNull final String name);
}
