package chat.repository;

import chat.api.repository.IGroupRepository;
import chat.entity.Group;
import chat.entity.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Collection;

@Repository
public class GroupRepository implements IGroupRepository {

    @NotNull
    private final EntityManager entityManager;

    @Autowired
    public GroupRepository(@NotNull EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Group findById(@NotNull String id) {
        @Nullable final Group group = entityManager
                .createQuery("SELECT e FROM Project e WHERE e.id = :id", Group.class)
                .setParameter("id", id)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
        return group;
    }

    @Override
    public void remove(@NotNull final Group group) {
        entityManager.remove(group);
    }

    @Override
    public void persist(@NotNull final Group group) {
        entityManager.persist(group);
    }

    @Override
    public Group merge(@NotNull final Group group) {
        return entityManager.merge(group);
    }

    public Collection<Group> sortAllByUserId(@NotNull final User user, @NotNull final String parameter) {
        @NotNull final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        @NotNull final CriteriaQuery<Group> criteriaQuery = criteriaBuilder.createQuery(Group.class);
        @NotNull final Root<Group> groupRoot = criteriaQuery.from(Group.class);
        @NotNull final Predicate condition = criteriaBuilder.equal(groupRoot.get("user"), user);
        criteriaQuery.select(groupRoot).where(condition);
        criteriaQuery.orderBy(criteriaBuilder.desc(groupRoot.get("parameter")));
        @NotNull final TypedQuery<Group> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
