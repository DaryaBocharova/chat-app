package chat.api.service;

import chat.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    void create(@NotNull User user) ;
}
