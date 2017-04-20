package hu.bme.aut.moblab.model;

import com.orm.dsl.Table;
/**
 * Created by bali on 2017. 04. 20..
 */

@Table
public class Result {

    private Long id = null;
    private Integer score = 0;
    private String name;

    public Result() {
    }

    public Result(Integer score, String name) {
        this.score = score;
        this.name = name;
    }

    public Result(Long id, Integer score, String name) {
        this.id = id;
        this.score = score;
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
