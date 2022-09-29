package com.cleanup.todoc.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.cleanup.todoc.model.Task;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface TaskDao {
    @Insert
    //void insertAll(Task... tasks);
    public Completable insertAll(Task task);

    @Delete
    //void delete(Task task);
    public Completable delete(List<Task> tasks);

    @Query("SELECT * FROM task")
    public Single<List<Task>> getAll();


}
