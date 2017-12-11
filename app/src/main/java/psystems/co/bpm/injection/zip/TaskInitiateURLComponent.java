package psystems.co.bpm.injection.zip;

import dagger.Component;
import psystems.co.bpm.injection.ActivityScope;
import psystems.co.bpm.injection.application.ApplicationComponent;
import psystems.co.bpm.ui.activities.TaskInitiatiableActivity;

/**
 * Created by ADEL on 12/6/2017.
 */
@ActivityScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = TaskInitiateURLModule.class
)

public interface TaskInitiateURLComponent {
    void inject(TaskInitiatiableActivity taskInitiatiableActivity);
}

