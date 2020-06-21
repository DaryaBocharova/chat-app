package chat.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.jetbrains.annotations.Nullable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Cacheable
@NoArgsConstructor
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "Group")
public class Group extends AbstractEntity{

    @Nullable
    @Column(name = "message")
    String message;
}
