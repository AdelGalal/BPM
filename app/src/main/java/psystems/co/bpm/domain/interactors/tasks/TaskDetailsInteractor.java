package psystems.co.bpm.domain.interactors.tasks;

import java.util.ArrayList;

import psystems.co.bpm.domain.interactors.Interactor;


/**
 * Created by ADEL on 11/23/2017.
 */

public interface TaskDetailsInteractor extends Interactor {
    interface CallbackOfTaskDetails {

        void onSucess(String taskURL);

        void onError();

    }
    void execute(String taskID, String token,CallbackOfTaskDetails callbackOfTaskDetails);

}
