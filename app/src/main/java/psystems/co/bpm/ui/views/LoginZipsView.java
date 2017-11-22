

package psystems.co.bpm.ui.views;


import psystems.co.bpm.api.model.response.LoginDataResponse;

public interface LoginZipsView {

    void loginIsSucess(LoginDataResponse loginDataResponse);

    void showWaitingDialog();

    void hideWaitingDialog();

    void showUserNameORPasswordErrorMessage();

    void showErrorInRequest();

}
