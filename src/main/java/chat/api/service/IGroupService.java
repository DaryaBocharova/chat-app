package chat.api.service;

import chat.entity.Group;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public interface IGroupService {

    Group findByIdAndUserId(
            @NotNull final String id,
            @NotNull final String userId);

    Group removeByIdAndUserId(
            @NotNull final String id,
            @NotNull final String userId);

    Group save(
            @NotNull final String id,
            @NotNull final String name);
}
