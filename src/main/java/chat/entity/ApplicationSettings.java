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
@Table(name = "appSettings")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ApplicationSettings extends AbstractEntity {

    @Nullable
    @Column(name = "oc")
    String oc;

    @Nullable
    @Column(name = "storage")
    Long storage;
}
