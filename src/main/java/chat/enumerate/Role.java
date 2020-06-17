package chat.enumerate;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public enum Role implements Serializable {

    USER("user"), ADMIN("admin");

    @NotNull
    private final String displayName;

    Role(@NotNull final String role) {
        displayName = role;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
