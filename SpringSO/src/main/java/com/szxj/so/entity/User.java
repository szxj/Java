package com.szxj.so.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * @author suzhouxj
 */

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public interface UserSimpleView{}
    public interface UserDetailView extends UserSimpleView{}

    private  String id;
    private  String username;
    private  String password;

    public String getId() {
        return id;
    }

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }
    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
