package com.example.demo.entity.client;

import com.example.demo.entity.UserDO;
import lombok.Data;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class User implements Serializable {

    private String name;

    // 仅用于登录时接受参数
    private String username;

    private String phone;

    private String password;

    /**
     * 用户类型 admin-管理员-1 editor-老师-0
     */
    private List<String> roles;

    /**
     * 头像地址
     */
    private String avatar;

    public User(){}

    public User(UserDO userDO) {
        if (!userDO.getUsername().isEmpty()) {
            this.name = userDO.getUsername();
        }
        if (!userDO.getPhone().isEmpty()) {
            this.phone = userDO.getPhone();
        }
        if (userDO.getType() == 1) {
            this.roles = new ArrayList<>();
            roles.add("admin");
        } else if (userDO.getType() == 0) {
            this.roles = new ArrayList<>();
            roles.add("editor");
        }
        if (userDO.getAvatar() != null) {
            this.avatar = userDO.getAvatar();
        }

    }
}
