package com.cleanup.todoc.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repository.ProjectData;
import com.cleanup.todoc.repository.TaskData;

import java.util.List;
import java.util.concurrent.Executor;

public class TaskViewModel extends ViewModel {

    //REPOSITORIES
    private final ProjectData mProjectDataRepository;
    private final TaskData mTaskDataRepository;
    private final Executor mExecutor;

    //CONSTRUCTOR
    public TaskViewModel(ProjectData projectDataRepository, TaskData taskDataRepository, Executor executor) {
        mProjectDataRepository = projectDataRepository;
        mTaskDataRepository = taskDataRepository;
        mExecutor = executor;
    }

    public LiveData<List<Task>> getAllTasks(){
        return this.mTaskDataRepository.getAllTasks();
    }

    public void insertTask(Task task){
        mExecutor.execute(()-> {
            this.mTaskDataRepository.insertTask(task);
        });
    }

    public void deleteTask(long taskId){
        mExecutor.execute(()->{
            this.mTaskDataRepository.deleteTask(taskId);
        });
    }

    public LiveData<List<Project>> getAllProjects(){
        return this.mProjectDataRepository.getAllProjects();
    }
}
