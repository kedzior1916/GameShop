package pl.kedzierski.gameshop.models;

import java.util.Set;

public class Role {
    private Long id;
    private Types type;
    private Set<User> users;

    public Role(Types type){
        this.type = type;
    }

    public enum Types{
        ROLE_ADMIN,
        ROLE_USER
    }
}
