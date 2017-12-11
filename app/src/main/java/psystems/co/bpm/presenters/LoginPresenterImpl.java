/*
 * Copyright 2016. Alejandro Sánchez
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package psystems.co.bpm.presenters;

import javax.inject.Inject;

import psystems.co.bpm.api.model.response.LoginDataResponse;
import psystems.co.bpm.domain.interactors.login.LoginInteractor;
import psystems.co.bpm.ui.views.LoginZipsView;
import psystems.co.bpm.util.ZipCodeMapperUi;


public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.Callback {

    @Inject
    LoginZipsView view;

    @Inject
    ZipCodeMapperUi zipCodeMapper;

    @Inject
    LoginInteractor searchCodesByCityInteractor;

    @Inject
    public LoginPresenterImpl() {

    }

    @Override
    public void makeSearch(String userName, String password) {

        if( userName == null || userName.isEmpty()|| password==null || password.isEmpty()){

            view.showUserNameORPasswordErrorMessage();

        }else{

            view.showWaitingDialog();
            searchCodesByCityInteractor.execute( userName,password, this );

        }
    }


    @Override
    public void onSucess(String token) {
        view.hideWaitingDialog();
        view.loginIsSucess(token);
    }

    @Override
    public void onError() {

        view.hideWaitingDialog();

        view.showErrorInRequest();

    }
}
