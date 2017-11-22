package psystems.co.bpm.presenters.tasks;

import java.util.ArrayList;

import javax.inject.Inject;

import psystems.co.bpm.api.model.response.LoginDataResponse;
import psystems.co.bpm.api.model.response.TaskElement;
import psystems.co.bpm.domain.interactors.tasks.TaskInteractor;
import psystems.co.bpm.ui.views.TasksView;

/**
 * Created by ADEL on 11/15/2017.
 */

public class TaskPresenterImpl implements TaskPresenter,TaskInteractor.Callback {
    @Inject
    TasksView view;

    @Inject
    TaskInteractor taskInteractor;

    @Inject
    TaskPresenterImpl()
    {

    }
    @Override
    public void makeSearch(String token, String firstDisplayColumn, String secondDisplayColumn, String thirdDisplayColumn,String fourthDisplayColumn,String fifthDisplayColumn,String sixthDisplayColumn, String firstOptionalTask, String secondOptionalTask, String assignmentFilter) {
        view.showWaitingDialog();
        taskInteractor.execute( token,firstDisplayColumn,secondDisplayColumn,thirdDisplayColumn,fourthDisplayColumn,fifthDisplayColumn,sixthDisplayColumn,firstOptionalTask,secondOptionalTask, assignmentFilter,this );

    }

    @Override
    public void onSucess(ArrayList<TaskElement>taskElementsList) {
        view.hideWaitingDialog();
        view.isSucess(taskElementsList);
    }

    @Override
    public void onError() {
        view.hideWaitingDialog();

        view.showErrorInRequest();
    }
}
