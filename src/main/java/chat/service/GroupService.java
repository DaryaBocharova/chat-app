package chat.service;

import chat.api.repository.IGroupRepository;
import chat.api.service.IGroupService;
import chat.entity.Group;
import chat.repository.GroupRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Service
public class GroupService implements IGroupService {

    @NotNull
    final EntityManagerFactory entityManagerFactory;

    @Autowired
    public GroupService(@NotNull EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Group findById(@NotNull String id, @NotNull String userId) {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final IGroupRepository groupRepository = new GroupRepository(entityManager);
        @Nullable Group group = null;
        try {
            entityManager.getTransaction().begin();
            group = groupRepository.findById(id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return group;
    }


    @Override
    public void remove(@Nullable final String id, @Nullable final String userId) {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final IGroupRepository groupRepository = new GroupRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @Nullable final Group group = groupRepository.findById(id);
            groupRepository.remove(group);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void create(@NotNull String id, @NotNull String name) {
        @NotNull final Group group = new Group();
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final IGroupRepository groupRepository = new GroupRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            groupRepository.persist(group);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }


}
