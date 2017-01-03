package com.CCL.entities;

import com.CCL.controllers.CCLController;
import com.CCL.utlities.PasswordStorage;

import javax.persistence.*;

/**
 * Created by michaelplott on 1/3/17.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private boolean isAdmin;

    public User() {
    }

    public User(String userName, String password, String email, boolean isAdmin) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public static boolean isValidUser(User user) throws PasswordStorage.InvalidHashException, PasswordStorage.CannotPerformOperationException {
        if (user.getUserName() == null || user.getPassword() == null) {
            return false;
        }
        User userFromDB = CCLController.users.findByUserName(user.getUserName());
        if (userFromDB == null) {
            return false;
        }
        if (!PasswordStorage.verifyPassword(user.getPassword(), userFromDB.getPassword())) {
            return false;
        }
        else {
            return true;
        }
    }

}
