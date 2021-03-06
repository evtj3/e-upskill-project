package com.up.skill.model;

import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;

/**
 * Created by jejeTabadzki on 2/16/2017.
 */
@Entity
@Table(name="contents")
public class ContentForm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Please write a topic")
    private String mainTopic;

    @NotBlank(message = "Please write a tile.")
    private String title;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMainTopic() {
        return mainTopic;
    }

    public void setMainTopic(String mainTopic) {
        this.mainTopic = mainTopic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}