package psystems.co.bpm.injection.zip;

import dagger.Module;
import dagger.Provides;
import psystems.co.bpm.domain.interactors.tasks.TaskInteractor;
import psystems.co.bpm.domain.interactors.tasks.TaskInteractorImpl;
import psystems.co.bpm.domain.threads.InteractorExecutor;
import psystems.co.bpm.domain.threads.InteractorExecutorImpl;
import psystems.co.bpm.domain.threads.MainThread;
import psystems.co.bpm.domain.threads.MainThreadImpl;
import psystems.co.bpm.injection.ActivityScope;
import psystems.co.bpm.presenters.tasks.TaskPresenter;
import psystems.co.bpm.presenters.tasks.TaskPresenterImpl;
import psystems.co.bpm.ui.activities.MainActivity;
import psystems.co.bpm.ui.views.TasksView;

/**
 * Created by ADEL on 11/15/2017.
 */

@Module
public class TasksModule {
    private MainActivity mainActivity;

    public TasksModule(MainActivity activity) {
        this.mainActivity = activity;
    }

    @Provides
    @ActivityScope
    public TasksView providesTaskViews(){
        return mainActivity;
    }

    @Provides
    @ActivityScope
    public TaskPresenter providesPresenter(TaskPresenterImpl taskPresenter){
        return taskPresenter;
    }

    @Provides
    @ActivityScope
    public TaskInteractor providesInteractor(TaskInteractorImpl interactor){
        return interactor;
    }

    @Provides
    @ActivityScope
    public InteractorExecutor providesInteractorExecutor(InteractorExecutorImpl interactorExecutor){
        return interactorExecutor;
    }

    @Provides
    @ActivityScope
    public MainThread providesMainThread(MainThreadImpl mainThread){
        return mainThread;
    }
}
