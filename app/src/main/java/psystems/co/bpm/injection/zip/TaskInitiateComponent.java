package psystems.co.bpm.injection.zip;

import dagger.Component;
import dagger.Provides;
import psystems.co.bpm.domain.threads.InteractorExecutor;
import psystems.co.bpm.domain.threads.MainThread;
import psystems.co.bpm.injection.ActivityScope;
import psystems.co.bpm.injection.application.ApplicationComponent;
import psystems.co.bpm.presenters.tasks.TaskInitiatePresenter;
import psystems.co.bpm.ui.fragments.TaskInitiateFragment;

/**
 * Created by ADEL on 12/6/2017.
 */
@ActivityScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = TaskInitiateModule.class
)
public interface TaskInitiateComponent {
    void inject(TaskInitiateFragment taskInitiateFragment);
}
