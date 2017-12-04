package psystems.co.bpm.ui.views;

import java.util.ArrayList;

import psystems.co.bpm.api.model.response.TaskElement;
import psystems.co.bpm.api.model.response.TasksEntityResponse;

/**
 * Created by ADEL on 11/15/2017.
 */

public interface TasksView {
    void isSucess(ArrayList<TasksEntityResponse> taskElementArrayList);

    void showWaitingDialog();

    void hideWaitingDialog();

    void showErrorInRequest();
}
