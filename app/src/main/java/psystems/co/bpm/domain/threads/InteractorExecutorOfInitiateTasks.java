package psystems.co.bpm.domain.threads;

import psystems.co.bpm.domain.interactors.tasks.TaskInitiateInteractor;

/**
 * Created by ADEL on 12/6/2017.
 */

public interface InteractorExecutorOfInitiateTasks {
    void run(TaskInitiateInteractor interactor);
}
