package com.buffettinc.hrms.service.training;

import com.buffettinc.hrms.model.training.Task;

import java.util.List;
import java.util.UUID;

/**
 * This interface provides a contract for the TaskService. It includes CRUD methods for
 * handling {@link Task}.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface TaskService {

    /**
     * Saves or updates a task.
     *
     * @param task The task to be saved or updated.
     * @return The saved or updated task.
     */
    Task saveOrUpdateTask(Task task);

    /**
     * Gets a task by ID.
     *
     * @param taskID The ID of the task.
     * @return The task.
     */
    Task getTaskById(UUID taskID);

    /**
     * Gets all tasks.
     *
     * @return A list of all tasks.
     */
    List<Task> getAllTasks();

    /**
     * Deletes a task.
     *
     * @param taskID The ID of the task to delete.
     */
    void deleteTask(UUID taskID);
}
