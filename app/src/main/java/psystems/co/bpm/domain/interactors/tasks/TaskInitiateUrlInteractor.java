package psystems.co.bpm.domain.interactors.tasks;


import psystems.co.bpm.domain.interactors.Interactor;

/**
 * Created by ADEL on 12/6/2017.
 */

public interface TaskInitiateUrlInteractor extends Interactor {
    interface CallbackOfTaskInitiateURL {

        void onSucess(String URL);

        void onError();

    }
    void execute(String token,String initcompositeDN,CallbackOfTaskInitiateURL callbackOfTaskInitiateURL);

}
