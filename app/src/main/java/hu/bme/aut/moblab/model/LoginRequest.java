package hu.bme.aut.moblab.model;

import com.orm.dsl.Table;

/**
 * Created by bali on 2017. 04. 23..
 */

@Table
public class LoginRequest {

    private Long id = null;
    private String password;
    private String name;

    public LoginRequest() {
    }

    public LoginRequest(String score, String name) {
        this.password = score;
        this.name = name;
    }

    public LoginRequest(Long id, String score, String name) {
        this.id = id;
        this.password = score;
        this.name = name;
    }

    public String getScore() {
        return password;
    }

    public void setScore(String pw) {
        this.password = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
