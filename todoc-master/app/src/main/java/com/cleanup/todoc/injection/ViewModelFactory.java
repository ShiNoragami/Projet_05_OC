package com.cleanup.todoc.injection;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.cleanup.todoc.repository.ProjectData;
import com.cleanup.todoc.repository.TaskData;
import com.cleanup.todoc.ui.TaskViewModel;

import java.util.concurrent.Executor;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final TaskData mTaskDataRepository;
    private final ProjectData mProjectDataRepository;
    private final Executor mExecutor;

    public ViewModelFactory(TaskData taskDataRepository, ProjectData projectDataRepository, Executor executor) {
        mTaskDataRepository = taskDataRepository;
        mProjectDataRepository = projectDataRepository;
        mExecutor = executor;
    }

    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(TaskViewModel.class)){
            return (T) new TaskViewModel(mProjectDataRepository,mTaskDataRepository,mExecutor);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}