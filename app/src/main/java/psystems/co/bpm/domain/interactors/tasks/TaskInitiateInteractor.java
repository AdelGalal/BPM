package psystems.co.bpm.domain.interactors.tasks;

import java.util.ArrayList;

import psystems.co.bpm.api.model.response.TaskInitiate;
import psystems.co.bpm.api.model.response.TaskInitiatiable;
import psystems.co.bpm.domain.interactors.Interactor;

/**
 * Created by ADEL on 12/6/2017.
 */

public interface TaskInitiateInteractor  extends Interactor {
    interface CallbackOfTaskInitiate {

        void onSucess(TaskInitiatiable taskInitiatiable);

        void onError();

    }
    void execute(String token,CallbackOfTaskInitiate callbackOfTaskInitiate);

}
