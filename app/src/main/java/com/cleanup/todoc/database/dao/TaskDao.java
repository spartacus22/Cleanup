package com.cleanup.todoc.database.dao;

import android.database.Cursor;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.cleanup.todoc.model.Task;

import java.util.List;

@Dao

public interface TaskDao {

        @Query("SELECT * FROM Task WHERE projectId = :pId")

        LiveData<List<Task>> getTasks(long pId);

        @Query("SELECT * FROM Task WHERE projectId = :pId")

        Cursor getTasksWithCursor(long pId);

        @Insert

        long insertTask(Task task);

        @Update

        int updateTask(Task task);

        @Query("DELETE FROM Task WHERE id = :taskId")

        int deleteTask(long taskId);

}
