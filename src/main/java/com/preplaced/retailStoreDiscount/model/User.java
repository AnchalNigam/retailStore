package com.preplaced.retailStoreDiscount.model;
import com.preplaced.retailStoreDiscount.utils.Constants.USER_TYPE;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private USER_TYPE userType;
    public User() {}
    public User(Long id, String name, USER_TYPE userType) {
        this.id = id;
        this.name = name;
        this.userType = userType;

    }


    public USER_TYPE getUserType() {
        return userType;
    }
}
