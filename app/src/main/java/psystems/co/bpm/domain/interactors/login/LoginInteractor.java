package psystems.co.bpm.domain.interactors.login;

import psystems.co.bpm.api.model.login.LoginResponse;
import psystems.co.bpm.api.model.response.LoginDataResponse;
import psystems.co.bpm.domain.interactors.Interactor;

public interface LoginInteractor extends Interactor {

    interface Callback{

        void onSucess(String token);
        void onError();

    }

    void execute(String cityName, String password, Callback callback);
}
