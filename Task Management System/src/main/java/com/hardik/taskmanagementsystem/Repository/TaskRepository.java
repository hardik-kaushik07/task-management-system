package com.hardik.taskmanagementsystem.Repository;

import com.hardik.taskmanagementsystem.Model.Tasks;
import com.hardik.taskmanagementsystem.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Long> {

    List<Tasks> findByUser(Users user);
    List<Tasks> findByUserAndStatus(Users user, String status);
}
