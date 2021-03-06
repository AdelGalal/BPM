package psystems.co.bpm.injection.zip;

import dagger.Component;
import psystems.co.bpm.injection.ActivityScope;
import psystems.co.bpm.injection.application.ApplicationComponent;
import psystems.co.bpm.ui.activities.TaskDetailsActivity;

/**
 * Created by ADEL on 11/23/2017.
 */

@ActivityScope

@Component(
        dependencies = ApplicationComponent.class,
        modules = TaskDetailsModule.class
)
public interface TaskDetailsComponent {
    void inject(TaskDetailsActivity activity);
}
