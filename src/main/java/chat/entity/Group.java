package chat.entity;

import org.jetbrains.annotations.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "Group")
public class Group {

    @Nullable
    @Column(name = "message")
    String message;
}
