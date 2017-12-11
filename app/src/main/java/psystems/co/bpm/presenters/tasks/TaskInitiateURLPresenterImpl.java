package psystems.co.bpm.presenters.tasks;

import java.util.ArrayList;

import javax.inject.Inject;

import psystems.co.bpm.api.model.response.TaskInitiate;
import psystems.co.bpm.domain.interactors.tasks.TaskInitiateInteractor;
import psystems.co.bpm.domain.interactors.tasks.TaskInitiateUrlInteractor;
import psystems.co.bpm.ui.views.TaskInitiateUrlView;

/**
 * Created by ADEL on 12/6/2017.
 */

public class TaskInitiateURLPresenterImpl implements TaskInitiateURLPresenter,TaskInitiateUrlInteractor.CallbackOfTaskInitiateURL{

    @Inject
    TaskInitiateUrlView taskInitiateUrlView;

    @Inject
    TaskInitiateUrlInteractor taskInitiateUrlInteractor;

    @Inject
    TaskInitiateURLPresenterImpl()
    {

    }

    @Override
    public void startToGetTasksInitiateURL(String token, String initcompositeDN) {
        taskInitiateUrlView.showWaitingDialog();
        taskInitiateUrlInteractor.execute(token,initcompositeDN,this);
    }


    @Override
    public void onSucess(String URL) {
        taskInitiateUrlView.hideWaitingDialog();
        taskInitiateUrlView.isSucess(URL);
    }

    @Override
    public void onError() {
        taskInitiateUrlView.hideWaitingDialog();
        taskInitiateUrlView.showErrorInRequest();
    }
}
