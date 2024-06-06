package com.project.demo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, ObjectId> {
    Task findByTaskID(String taskID);
    List<Task> findByNameContaining(String name);
    List<Task> findTop10ByAssigneeOrderByStartTimeAsc(String assignee);
}
