package psystems.co.bpm.presenters.tasks;

import java.util.ArrayList;

import javax.inject.Inject;

import psystems.co.bpm.api.model.response.TaskElement;
import psystems.co.bpm.domain.interactors.tasks.TaskDetailsInteractor;
import psystems.co.bpm.domain.interactors.tasks.TaskInteractor;
import psystems.co.bpm.ui.views.TaskDetailsView;
import psystems.co.bpm.ui.views.TasksView;

/**
 * Created by ADEL on 11/23/2017.
 */

public class TaskDetailsPresenterImpl implements TaskDetailsPresenter,TaskDetailsInteractor.CallbackOfTaskDetails {
    @Inject
    TaskDetailsView view;

    @Inject
    TaskDetailsInteractor taskInteractor;

    @Inject
    TaskDetailsPresenterImpl()
    {

    }

    @Override
    public void startToGetTaskDetailsURL(String taskID, String token) {
        view.showWaitingDialog();
        taskInteractor.execute(taskID,token,this);

    }

    @Override
    public void onSucess(String taskURL) {
        view.hideWaitingDialog();
        view.isSucess(taskURL);
    }

    @Override
    public void onError() {
        view.hideWaitingDialog();

        view.showErrorInRequest();
    }
}
