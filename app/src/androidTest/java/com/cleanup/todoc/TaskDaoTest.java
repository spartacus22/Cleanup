package com.cleanup.todoc;

import static org.junit.Assert.assertTrue;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
// import androidx.test.InstrumentationRegistry;
import androidx.test.platform.app.InstrumentationRegistry;
// import androidx.test.runner.AndroidJUnit4;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.cleanup.todoc.database.todocDatabase;
import com.cleanup.todoc.model.Project;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class TaskDaoTest {

    // FOR DATA

    private todocDatabase database;

    @Rule

    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before

    public void initDb() throws Exception {

        this.database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().getContext(),

                        todocDatabase.class)
                .allowMainThreadQueries()
                .build();
    }

    @After

    public void closeDb() throws Exception {

        database.close();

    }

    // DATA SET FOR TEST

    private static long PROJECT_ID = 5L;

    private static Project PROJECT_DEMO = new Project(PROJECT_ID, "Projet alpha", 0xFFEADAD1);

    @Test

    public void insertAndGetProject() throws InterruptedException {

        // BEFORE : Adding a new user

        this.database.projectDao().createProject(PROJECT_DEMO);

        // TEST

        Project project = LiveDataTestUtil.getValue(this.database.projectDao().getProject(PROJECT_ID));

        assertTrue(project.getName().equals(PROJECT_DEMO.getName()) && project.getId() == PROJECT_ID);

    }

}
