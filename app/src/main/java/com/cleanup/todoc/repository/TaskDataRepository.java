package com.cleanup.todoc.repository;

import androidx.lifecycle.LiveData;

import com.cleanup.todoc.database.TaskDao;
import com.cleanup.todoc.model.Task;

import java.util.List;

public class TaskDataRepository {

    private final TaskDao taskDao;
    public TaskDataRepository(TaskDao taskDao) { this.taskDao = taskDao; }

    public LiveData<List<Task>> getAllTasks(){ return this.taskDao.getAll();}

    public void createTask(Task task){taskDao.insertAll(task);}

    public void deleteTask(Task task){taskDao.delete(task);}

}
