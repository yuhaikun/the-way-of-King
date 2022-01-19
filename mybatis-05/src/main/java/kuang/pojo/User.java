package kuang.pojo;


import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String password;


    public User() {
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
