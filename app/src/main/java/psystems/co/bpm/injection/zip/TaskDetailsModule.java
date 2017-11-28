package psystems.co.bpm.injection.zip;



import dagger.Module;
import dagger.Provides;
import psystems.co.bpm.domain.interactors.tasks.TaskDetailsInteractor;
import psystems.co.bpm.domain.interactors.tasks.TaskDetailsInteractorImpl;
import psystems.co.bpm.domain.threads.InteractorExecuterOfTaskDetailsImpl;
import psystems.co.bpm.domain.threads.InteractorExecutorOfTaskDetails;
import psystems.co.bpm.domain.threads.MainThread;
import psystems.co.bpm.domain.threads.MainThreadImpl;
import psystems.co.bpm.injection.ActivityScope;
import psystems.co.bpm.presenters.tasks.TaskDetailsPresenter;
import psystems.co.bpm.presenters.tasks.TaskDetailsPresenterImpl;
import psystems.co.bpm.ui.activities.TaskDetailsActivity;
import psystems.co.bpm.ui.views.TaskDetailsView;

/**
 * Created by ADEL on 11/23/2017.
 */
@Module
public class TaskDetailsModule {
    private TaskDetailsActivity taskDetailsActivity;

    public TaskDetailsModule(TaskDetailsActivity taskDetailsActivity)
    {
        this.taskDetailsActivity=taskDetailsActivity;
    }
    @Provides
    @ActivityScope
    public TaskDetailsView providesTaskDetailsViews(){
        return taskDetailsActivity;
    }

    @Provides
    @ActivityScope
    public TaskDetailsPresenter providesTaskDetailsPresenter(TaskDetailsPresenterImpl taskPresenter){
        return taskPresenter;
    }

    @Provides
    @ActivityScope
    public TaskDetailsInteractor providesTaskDetailsInteractor(TaskDetailsInteractorImpl interactor){
        return interactor;
    }

    @Provides
    @ActivityScope
    public InteractorExecutorOfTaskDetails providesTaskDetailsInteractorExecutor(InteractorExecuterOfTaskDetailsImpl interactorExecutor){
        return interactorExecutor;
    }

    @Provides
    @ActivityScope
    public MainThread providesMainThreadDetails(MainThreadImpl mainThread){
        return mainThread;
    }

}
