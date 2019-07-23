package com.thoughtworks.todolist.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String value;

    private Boolean isSelected;

    private Boolean isEdited;

    public Todo(String value, Boolean isSelected, Boolean isEdited) {
        this.value = value;
        this.isSelected = isSelected;
        this.isEdited = isEdited;
    }
}
