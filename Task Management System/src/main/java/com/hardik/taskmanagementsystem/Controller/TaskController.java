package com.hardik.taskmanagementsystem.Controller;

import com.hardik.taskmanagementsystem.Model.Tasks;
import com.hardik.taskmanagementsystem.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<Tasks> getAllTasks(String status, Authentication authentication){
        return taskService.getAllTasks(status, authentication);
    }

    @PostMapping("/tasks")
    public String createTask(@RequestBody Tasks task,Authentication authentication){
        return taskService.createTasks(task, authentication);
    }

    @PutMapping("/update/{id}")
    public String updateTask(@PathVariable Long id, @RequestBody Tasks task, Authentication authentication){
        return taskService.updateTask(id, task, authentication);
    }

    @DeleteMapping("delete/{id}")
    public String deleteTask(@PathVariable Long id, Authentication authentication){
        return taskService.deleteTask(id, authentication);
    }
}


