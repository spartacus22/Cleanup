package com.cleanup.todoc.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

@Database(entities = {Project.class, Task.class}, version = 1)
public abstract class CleanDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();
}
