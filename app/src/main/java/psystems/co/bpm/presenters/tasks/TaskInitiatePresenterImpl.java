package psystems.co.bpm.presenters.tasks;

import java.util.ArrayList;

import javax.inject.Inject;

import psystems.co.bpm.api.model.response.TaskInitiate;
import psystems.co.bpm.api.model.response.TaskInitiatiable;
import psystems.co.bpm.domain.interactors.tasks.TaskInitiateInteractor;
import psystems.co.bpm.ui.views.TaskInitiateView;

/**
 * Created by ADEL on 12/6/2017.
 */

public class TaskInitiatePresenterImpl implements TaskInitiatePresenter,TaskInitiateInteractor.CallbackOfTaskInitiate {
    @Inject
    TaskInitiateView view;

    @Inject
    TaskInitiateInteractor taskInteractor;

    @Inject
    TaskInitiatePresenterImpl()
    {

    }
    @Override
    public void startToGetTasksInitiate(String token) {
        view.showWaitingDialog();
        taskInteractor.execute(token,this);
    }

    @Override
    public void onSucess(TaskInitiatiable taskInitiatiable) {
        view.hideWaitingDialog();
        view.isSucess(taskInitiatiable);
    }

    @Override
    public void onError() {
        view.hideWaitingDialog();

        view.showErrorInRequest();
    }
}
