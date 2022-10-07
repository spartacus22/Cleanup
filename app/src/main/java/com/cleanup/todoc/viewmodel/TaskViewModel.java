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

}
