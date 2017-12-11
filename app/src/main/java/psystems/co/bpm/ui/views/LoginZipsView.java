

package psystems.co.bpm.ui.views;


import psystems.co.bpm.api.model.response.LoginDataResponse;

public interface LoginZipsView {

    void loginIsSucess(String  token);

    void showWaitingDialog();

    void hideWaitingDialog();

    void showUserNameORPasswordErrorMessage();

    void showErrorInRequest();

}
