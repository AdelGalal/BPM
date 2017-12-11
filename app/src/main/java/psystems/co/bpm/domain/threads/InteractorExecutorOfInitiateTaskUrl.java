package psystems.co.bpm.domain.threads;
import psystems.co.bpm.domain.interactors.tasks.TaskInitiateUrlInteractor;

/**
 * Created by ADEL on 12/6/2017.
 */

public interface InteractorExecutorOfInitiateTaskUrl {
    void run(TaskInitiateUrlInteractor interactor);
}
