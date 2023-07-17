package com.buffettinc.hrms.service.training;

import com.buffettinc.hrms.model.training.Task;
import com.buffettinc.hrms.repository.training.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * This class implements the {@link TaskService} interface, providing concrete
 * implementations for each method.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Task saveOrUpdateTask(Task task) {
        return taskRepository.save(task);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task getTaskById(UUID taskID) {
        return taskRepository.findById(taskID).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteTask(UUID taskID) {
        taskRepository.deleteById(taskID);
    }
}
