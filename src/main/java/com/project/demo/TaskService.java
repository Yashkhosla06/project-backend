package com.project.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(String id) {
        return Optional.ofNullable(taskRepository.findByTaskID(id));
    }

    public Task createTask(Task task) {
        task.setYashKhoslaProperty(generateYashKhoslaProperty());
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) {
        task.setYashKhoslaProperty(generateYashKhoslaProperty());
        return taskRepository.save(task);
    }

    public void deleteTask(String id) {
        Task task = taskRepository.findByTaskID(id);
        System.out.println(task);
        if (task != null) {
            taskRepository.delete(task);
        }
    }

    public List<Task> findTasksByName(String name) {
        return taskRepository.findByNameContaining(name);
    }

    public List<Task> findTasksByAssignee(String assignee) {
        return taskRepository.findTop10ByAssigneeOrderByStartTimeAsc(assignee);
    }

    private String generateYashKhoslaProperty() {
        String source = "YashKhosla";
        Random random = new Random();
        StringBuilder result = new StringBuilder(5);
        for (int i = 0; i < 5; i++) {
            result.append(source.charAt(random.nextInt(source.length())));
        }
        return result.toString();
    }
}
