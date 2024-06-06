package com.project.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(@RequestParam(required = false) String id) {
        if (id != null) {
            return taskService.getTaskById(id)
                    .map(List::of)
                    .orElseThrow(() -> new TaskNotFoundException("Task not found"));
        }
        return taskService.getAllTasks();
    }

    @PutMapping
    public Task createOrUpdateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/search")
    public List<Task> findTasksByName(@RequestParam String name) {
        List<Task> tasks = taskService.findTasksByName(name);
        if (tasks.isEmpty()) {
            throw new TaskNotFoundException("No tasks found with the given name");
        }
        return tasks;
    }

    @GetMapping("/assignee")
    public List<Task> findTasksByAssignee(@RequestParam String assignee) {
        List<Task> tasks = taskService.findTasksByAssignee(assignee);
        if (tasks.isEmpty()) {
            throw new TaskNotFoundException("No tasks found for the given assignee");
        }
        return tasks;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class TaskNotFoundException extends RuntimeException {
        public TaskNotFoundException(String message) {
            super(message);
        }
    }
}
