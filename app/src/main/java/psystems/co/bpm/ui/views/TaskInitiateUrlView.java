package psystems.co.bpm.ui.views;

import java.util.ArrayList;

import psystems.co.bpm.api.model.response.TaskInitiate;

/**
 * Created by ADEL on 12/6/2017.
 */

public interface TaskInitiateUrlView {
    void isSucess(String taskUrl);

    void showWaitingDialog();

    void hideWaitingDialog();

    void showErrorInRequest();
}