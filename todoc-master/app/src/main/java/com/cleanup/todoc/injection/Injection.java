package com.cleanup.todoc.injection;

import android.content.Context;

import com.cleanup.todoc.database.TodocDataBase;
import com.cleanup.todoc.repository.ProjectData;
import com.cleanup.todoc.repository.TaskData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Injection {

    public static TaskData provideTaskDataSource(Context context){
        TodocDataBase dataBase = TodocDataBase.getInstance(context);
        return new TaskData(dataBase.taskDAO());
    }

    public static ProjectData provideProjectDataSource(Context context){
        TodocDataBase dataBase = TodocDataBase.getInstance(context);
        return new ProjectData(dataBase.projectDAO());
    }

    public static Executor provideExecutor(){
        return Executors.newSingleThreadExecutor();
    }

    public static ViewModelFactory provideViewModelFactory(Context context){
        ProjectData projectDataRepository = provideProjectDataSource(context);
        TaskData taskDataRepository = provideTaskDataSource(context);
        Executor executor = provideExecutor();
        return new ViewModelFactory(taskDataRepository,projectDataRepository,executor);
    }
}
