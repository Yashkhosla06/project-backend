package com.project.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    private ObjectId id;
    private String name;
    private String taskID;
    private String assignee;
    private String project;
    private Date startTime;
    private String yashKhoslaProperty;

    // Constructor excluding ObjectId
    public Task(String name, String taskID, String assignee, String project, Date startTime, String yashKhoslaProperty) {
        this.name = name;
        this.taskID = taskID;
        this.assignee = assignee;
        this.project = project;
        this.startTime = startTime;
        this.yashKhoslaProperty = yashKhoslaProperty;
    }
}
