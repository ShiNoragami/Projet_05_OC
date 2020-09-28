package com.cleanup.todoc.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cleanup.todoc.model.Task;

import java.util.List;

@Dao
public interface TaskDAO {

    @Query("SELECT * FROM Task WHERE projectId = :projectId")
    public LiveData<List<Task>> getTasks(long projectId);

    @Query("SELECT * FROM Task")
    public LiveData<List<Task>> getAllTasks();

    @Insert
    public long insertTask(Task task);

    @Update
    public int updateTask(Task task);

    @Query("DELETE FROM Task WHERE id = :taskId")
    public int deleteTask(long taskId);
}
