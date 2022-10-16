package com.cleanup.todoc.repository;

import androidx.lifecycle.LiveData;

import com.cleanup.todoc.database.TaskDao;
import com.cleanup.todoc.model.Task;

import java.util.List;

public class TaskDataRepository {

    private final TaskDao taskDao;

    public TaskDataRepository(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public LiveData<List<Task>> getAllTasks(){
        return this.taskDao.getAll();
    }

    public LiveData<List<Task>> getAllTasksSortedByName(){
        return this.taskDao.getAllTasksSortedByName();
    }

    public LiveData<List<Task>> getAllTasksSortedByNameDesc(){
        return this.taskDao.getAllTasksSortedByNameDesc();
    }

    public LiveData<List<Task>> getAllTasksSortedByDate(){
        return this.taskDao.getAllTasksSortedByDate();
    }

    public LiveData<List<Task>> getAllTasksSortedByDateDesc(){
        return this.taskDao.getAllTasksSortedByDateDesc();
    }

    public void createTask(Task task){taskDao.insertAll(task);}

    public void deleteTask(Task task){taskDao.delete(task);}

}
