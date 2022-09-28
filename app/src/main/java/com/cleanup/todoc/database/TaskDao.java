package com.cleanup.todoc.database;

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
    List<Task> getAll();


}
