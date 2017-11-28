package psystems.co.bpm.ui.views;


/**
 * Created by ADEL on 11/23/2017.
 */

public interface TaskDetailsView {

    void isSucess(String taskURL);

    void showWaitingDialog();

    void hideWaitingDialog();

    void showErrorInRequest();

}
