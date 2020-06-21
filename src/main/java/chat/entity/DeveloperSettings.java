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
@Table(name = "developer")
public class DeveloperSettings extends AbstractEntity {

    @Nullable
    @Column(name = "fio")
    String fio;

    @Nullable
    @Column(name = "email")
    String email;
}
