package psystems.co.bpm.ui.views;

import java.util.ArrayList;

import psystems.co.bpm.api.model.response.TaskElement;

/**
 * Created by ADEL on 11/15/2017.
 */

public interface TasksView {
    void isSucess(ArrayList<TaskElement> taskElementArrayList);

    void showWaitingDialog();

    void hideWaitingDialog();

    void showErrorInRequest();
}
