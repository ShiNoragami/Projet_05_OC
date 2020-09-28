package com.cleanup.todoc.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.cleanup.todoc.model.Project;

import java.util.List;

@Dao
public interface ProjectDAO {

    @Query("SELECT * FROM Project")
    public LiveData<List<Project>> getAllProjects();

    @Query("SELECT * FROM Project WHERE id = :projectId")
    public LiveData<Project> getProject(long projectId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertProject(Project project);

    @Insert
    public void insertAll(Project... projects);
}
