package com.hardik.taskmanagementsystem.Service;

import com.hardik.taskmanagementsystem.Model.Tasks;
import com.hardik.taskmanagementsystem.Model.Users;
import com.hardik.taskmanagementsystem.Repository.TaskRepository;
import com.hardik.taskmanagementsystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    public List<Tasks> getAllTasks(String status, Authentication authentication) {

        String email = authentication.getName();

        Users user = userRepository.findByEmail(email);
        if(user==null){
            throw new UsernameNotFoundException("User Not Found");
        }

        if(status!=null){
            String capitalStatus = status.toUpperCase();
            return taskRepository.findByUserAndStatus(user,capitalStatus);
        }
        return taskRepository.findByUser(user);
    }

    public String createTasks(Tasks task, Authentication authentication) {

        String email = authentication.getName();
        Users user = userRepository.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        task.setUser(user);

        if(task.getStatus()==null){
            task.setStatus("PENDING");
        }
        else{
            String status = task.getStatus().toUpperCase();
            if(!status.equals("PENDING") && !status.equals("COMPLETE")){
                throw new RuntimeException("Invalid Status");
            }
            task.setStatus(task.getStatus().toUpperCase());
        }
         taskRepository.save(task);
        return "Task Created Successfully";
    }

    public String updateTask(Long id, Tasks updateTask, Authentication authentication) {

        String email = authentication.getName();
        Users user = userRepository.findByEmail(email);
        if(user==null){
            throw new UsernameNotFoundException("User Not Found");
        }

        Tasks task = taskRepository.findById(id).orElseThrow(()->new RuntimeException("No Task Found"));

        if(!task.getUser().getId().equals(user.getId())){
            throw new RuntimeException("Sorry you are not allow to Update!");
        }

       if(updateTask.getTitle()!=null){
           task.setTitle(updateTask.getTitle());
       }

        if(updateTask.getStatus()==null){
            task.setStatus("PENDING");
        }
        else{
            String status = updateTask.getStatus().toUpperCase();
            if(!status.equals("PENDING") && !status.equals("COMPLETE")){
                throw new RuntimeException("Invalid Status");
            }
            task.setStatus(status);
        }

        taskRepository.save(task);
        return "Task Updated Successfully";
    }

    public String deleteTask(Long id, Authentication authentication) {

        String email = authentication.getName();
        Users user = userRepository.findByEmail(email);
        if(user==null){
            throw new UsernameNotFoundException("User Not Found");
        }

        Tasks task = taskRepository.findById(id).orElseThrow(()->new RuntimeException("No Task Found"));
        if(!task.getUser().getId().equals(user.getId())){
            throw new RuntimeException("Sorry you are not allow to Delete!");
        }

        taskRepository.delete(task);

        return "Task Deleted Successfully";
    }
}
