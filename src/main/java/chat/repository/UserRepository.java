package chat.repository;

import chat.api.repository.IUserRepository;
import chat.entity.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserRepository implements IUserRepository {

    @NotNull
    private final EntityManager entityManager;

    @Autowired
    public UserRepository(@NotNull EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findById(@NotNull String id) {
        @Nullable final User user = entityManager
                .createQuery("SELECT e FROM User e WHERE e.id = :id", User.class)
                .setParameter("id", id)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
        return user;
    }

    @Override
    public void remove(@NotNull User user) {
            entityManager.remove(user);
    }

    @Override
    public void persist(@NotNull User user) {
        entityManager.persist(user);
    }

}
