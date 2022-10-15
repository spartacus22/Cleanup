package com.cleanup.todoc.injections;

import android.content.Context;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.cleanup.todoc.database.CleanDatabase;
import com.cleanup.todoc.repository.TaskDataRepository;
import com.cleanup.todoc.viewmodel.TaskViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskViewModelFactory implements ViewModelProvider.Factory {

    private final TaskDataRepository taskDataSource;

    private final Executor executor;

    private static TaskViewModelFactory factory;

    public static TaskViewModelFactory getInstance(Context context) {

        if (factory == null) {

            synchronized (TaskViewModelFactory.class) {

                if (factory == null) {

                    factory = new TaskViewModelFactory(context);

                }

            }

        }

        return factory;

    }

    private TaskViewModelFactory(Context context) {

        CleanDatabase database = CleanDatabase.getInstance(context);

        this.taskDataSource = new TaskDataRepository(database.taskDao());

        this.executor = Executors.newSingleThreadExecutor();

    }

    @Override
    @NotNull
    public <T extends ViewModel>  T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(TaskViewModel.class)) {
            return (T) new TaskViewModel(taskDataSource, executor);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }

}