package com.cleanup.todoc.repository;

import android.arch.lifecycle.LiveData;

import com.cleanup.todoc.database.dao.TaskDAO;
import com.cleanup.todoc.model.Task;

import java.util.List;

public class TaskData {

    private TaskDAO mTaskDAO;

    public TaskData(TaskDAO taskDAO) { mTaskDAO = taskDAO; }

    public LiveData<List<Task>> getAllTasks(){
        return this.mTaskDAO.getAllTasks();
    }

    public void insertTask(Task task){
        this.mTaskDAO.insertTask(task);
    }

    public void deleteTask(long taskId){
        this.mTaskDAO.deleteTask(taskId);
    }
}

