package org._233Latiao.Lytine.ssm.entity;

public class User extends BaseEntity {
	private static final long serialVersionUID = 1L;

	// 主键
    private Integer id;

    // 用户名
    private String userName;

    // 密码
    private String password;

    // 年龄
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}