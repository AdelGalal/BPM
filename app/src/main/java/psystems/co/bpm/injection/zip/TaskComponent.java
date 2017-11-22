package psystems.co.bpm.injection.zip;

import dagger.Component;
import psystems.co.bpm.domain.threads.InteractorExecutor;
import psystems.co.bpm.domain.threads.MainThread;
import psystems.co.bpm.injection.ActivityScope;
import psystems.co.bpm.injection.application.ApplicationComponent;
import psystems.co.bpm.presenters.tasks.TaskPresenter;
import psystems.co.bpm.ui.activities.MainActivity;

/**
 * Created by ADEL on 11/15/2017.
 */

@ActivityScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = TasksModule.class
)
public interface TaskComponent {
    void inject(MainActivity activity);

    TaskPresenter providesPresenter();

    InteractorExecutor providesInteractorExecutor();

    MainThread providesMainThread();

}
