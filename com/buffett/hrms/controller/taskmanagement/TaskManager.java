package com.buffett.hrms.controller.taskmanagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.buffett.hrms.model.taskmanagement.Task;
import com.buffett.hrms.model.Employee;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public Task createTask(String taskName, String taskDescription, LocalDate dueDate, Employee assignedEmployee) {
        Task task = new Task(taskName, taskDescription, dueDate, assignedEmployee);
        tasks.add(task);
        return task;
    }

    public void assignTask(Task task, Employee assignedEmployee) {
        task.setAssignedEmployee(assignedEmployee);
    }

    public void removeTask(Task task){
        tasks.remove(task);
    }

    public List<Task> getTasksForEmployee(Employee employee){
        List<Task> tasksForEmployee = new ArrayList<>();
        for(Task task : tasks){
            if(task.getAssignedEmployee().equals(employee)){
                tasksForEmployee.add(task);
            }
        }
        return tasksForEmployee;
    }

    public List<Task> getAllTasks(){
        return tasks;
    }
}
