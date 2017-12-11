package psystems.co.bpm.ui.views;

import java.util.ArrayList;

import psystems.co.bpm.api.model.response.TaskInitiate;
import psystems.co.bpm.api.model.response.TaskInitiatiable;

/**
 * Created by ADEL on 12/6/2017.
 */

public interface TaskInitiateView {
    void isSucess(TaskInitiatiable taskInitiatiable);

    void showWaitingDialog();

    void hideWaitingDialog();

    void showErrorInRequest();
}
