package chat.service;

import chat.api.service.IUserService;
import chat.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Override
    public User create(@NotNull String id, @NotNull String name, @NotNull boolean editChat, @NotNull String password, @NotNull String role) {
        return null;
    }
}
