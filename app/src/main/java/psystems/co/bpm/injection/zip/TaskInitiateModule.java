package psystems.co.bpm.injection.zip;

import dagger.Module;
import dagger.Provides;
import psystems.co.bpm.domain.interactors.tasks.TaskInitiateInteractor;
import psystems.co.bpm.domain.interactors.tasks.TaskInitiateInteractorImpl;
import psystems.co.bpm.domain.interactors.tasks.TaskInteractor;
import psystems.co.bpm.domain.interactors.tasks.TaskInteractorImpl;
import psystems.co.bpm.domain.threads.InteractorExecuterOfTaskDetailsImpl;
import psystems.co.bpm.domain.threads.InteractorExecutor;
import psystems.co.bpm.domain.threads.InteractorExecutorImpl;
import psystems.co.bpm.domain.threads.InteractorExecutorOfInitiateTasks;
import psystems.co.bpm.domain.threads.InteractorExecutorOfInitiateTasksImpl;
import psystems.co.bpm.domain.threads.InteractorExecutorOfTaskDetails;
import psystems.co.bpm.domain.threads.MainThread;
import psystems.co.bpm.domain.threads.MainThreadImpl;
import psystems.co.bpm.injection.ActivityScope;
import psystems.co.bpm.presenters.tasks.TaskInitiatePresenter;
import psystems.co.bpm.presenters.tasks.TaskInitiatePresenterImpl;
import psystems.co.bpm.presenters.tasks.TaskPresenter;
import psystems.co.bpm.presenters.tasks.TaskPresenterImpl;
import psystems.co.bpm.ui.activities.MainActivity;
import psystems.co.bpm.ui.fragments.TaskInitiateFragment;
import psystems.co.bpm.ui.views.TaskInitiateView;
import psystems.co.bpm.ui.views.TasksView;

/**
 * Created by ADEL on 12/6/2017.
 */
@Module
public class TaskInitiateModule {

    private TaskInitiateFragment taskInitiateFragment;

    public TaskInitiateModule(TaskInitiateFragment taskInitiateFragment) {
        this.taskInitiateFragment = taskInitiateFragment;
    }
    @Provides
    @ActivityScope
    public TaskInitiateView providesTaskViews(){
        return taskInitiateFragment;
    }

    @Provides
    @ActivityScope
    public TaskInitiatePresenter providesPresenter(TaskInitiatePresenterImpl taskPresenter){
        return taskPresenter;
    }

    @Provides
    @ActivityScope
    public TaskInitiateInteractor providesInteractor(TaskInitiateInteractorImpl interactor){
        return interactor;
    }

    @Provides
    @ActivityScope
    public InteractorExecutorOfInitiateTasks providesTaskDetailsInteractorExecutor(InteractorExecutorOfInitiateTasksImpl interactorExecutor){
        return interactorExecutor;
    }

    @Provides
    @ActivityScope
    public MainThread providesMainThread(MainThreadImpl mainThread){
        return mainThread;
    }

}
