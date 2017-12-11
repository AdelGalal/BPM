package psystems.co.bpm.injection.zip;

import dagger.Module;
import dagger.Provides;
import psystems.co.bpm.domain.interactors.tasks.TaskInitiateUrlInteractor;
import psystems.co.bpm.domain.interactors.tasks.TaskInitiateUrlInteractorImpl;
import psystems.co.bpm.domain.threads.InteractorExecutorOfInitiateTaskUrl;
import psystems.co.bpm.domain.threads.InteractorExecutorOfInitiateTaskUrlImpl;
import psystems.co.bpm.domain.threads.MainThread;
import psystems.co.bpm.domain.threads.MainThreadImpl;
import psystems.co.bpm.injection.ActivityScope;
import psystems.co.bpm.presenters.tasks.TaskInitiateURLPresenter;
import psystems.co.bpm.presenters.tasks.TaskInitiateURLPresenterImpl;
import psystems.co.bpm.ui.activities.TaskInitiatiableActivity;
import psystems.co.bpm.ui.views.TaskInitiateUrlView;
import psystems.co.bpm.ui.views.TaskInitiateView;

/**
 * Created by ADEL on 12/6/2017.
 */
@Module
public class TaskInitiateURLModule {
    private TaskInitiatiableActivity taskInitiatiableActivity;

    public TaskInitiateURLModule(TaskInitiatiableActivity taskInitiatiableActivity) {
        this.taskInitiatiableActivity = taskInitiatiableActivity;
    }

    @Provides
    @ActivityScope
    public TaskInitiateUrlView providesTaskInitURLViews(){
        return taskInitiatiableActivity;
    }

    @Provides
    @ActivityScope
    public TaskInitiateURLPresenter providesPresenter(TaskInitiateURLPresenterImpl taskPresenter){
        return taskPresenter;
    }

    @Provides
    @ActivityScope
    public TaskInitiateUrlInteractor providesInteractor(TaskInitiateUrlInteractorImpl interactor){
        return interactor;
    }

    @Provides
    @ActivityScope
    public InteractorExecutorOfInitiateTaskUrl providesTaskDetailsInteractorExecutor(InteractorExecutorOfInitiateTaskUrlImpl interactorExecutor){
        return interactorExecutor;
    }

    @Provides
    @ActivityScope
    public MainThread providesMainThread(MainThreadImpl mainThread){
        return mainThread;
    }

}
