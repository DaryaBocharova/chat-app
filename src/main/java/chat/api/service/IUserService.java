package chat.api.service;

import chat.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    User create(
            @NotNull final String id,
            @NotNull final String name,
            @NotNull final boolean editChat,
            @NotNull final String password,
            @NotNull final String role);
}
