package com.cleanup.todoc.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.cleanup.todoc.model.Task;

import java.util.List;

@Dao
public interface TaskDao {
    @Insert
    void insertAll(Task... tasks);

    @Delete
    void delete(Task task);

    @Query("SELECT * FROM task")
    LiveData<List<Task>> getAll();

    @Query("SELECT * FROM task ORDER BY name ")
    LiveData<List<Task>> getAllTasksSortedByName();

    @Query("SELECT * FROM task ORDER BY name DESC ")
    LiveData<List<Task>> getAllTasksSortedByNameDesc();

    @Query("SELECT * FROM task ORDER BY creationTimestamp")
    LiveData<List<Task>> getAllTasksSortedByDate();

    @Query("SELECT * FROM task ORDER BY creationTimestamp DESC")
    LiveData<List<Task>> getAllTasksSortedByDateDesc();
}
