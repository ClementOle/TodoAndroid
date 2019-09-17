package com.colewski.todoandroid.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskModel {
    private Integer id;
    private String content;

}
