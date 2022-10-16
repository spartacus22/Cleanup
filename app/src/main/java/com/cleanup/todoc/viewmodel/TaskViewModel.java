package com.cleanup.todoc.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repository.TaskDataRepository;

import java.util.List;
import java.util.concurrent.Executor;

public class TaskViewModel extends ViewModel {

    private final TaskDataRepository taskDataSource;
    private Executor executor;

    private LiveData<List<Task>> tasks;

    public TaskViewModel(TaskDataRepository taskDataSource, Executor executor){
        this.taskDataSource=taskDataSource;
        this.executor = executor;
    }

    public LiveData<List<Task>> getTasks() {
        return taskDataSource.getAllTasks();
    }

    public LiveData<List<Task>> getSortedTasks() {
        return taskDataSource.getAllTasksSortedByName();
    }

    public LiveData<List<Task>> getSortedTasksByNameDesc() {
        return taskDataSource.getAllTasksSortedByNameDesc();
    }

    public LiveData<List<Task>> getSortedTasksByDate() {
        return taskDataSource.getAllTasksSortedByDate();
    }

    public LiveData<List<Task>> getSortedTasksByDateDesc() {
        return taskDataSource.getAllTasksSortedByDateDesc();
    }


    public void createTask(Task task){
        executor.execute(() -> {
            taskDataSource.createTask(task);
        });
    }

    public void deleteTask(Task task){
        executor.execute(() -> {
            taskDataSource.deleteTask(task);
        });
    }

    public void init() {
        if (this.tasks != null) {
            return;
        }
        tasks = taskDataSource.getAllTasks();
    }


}
