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

package psystems.co.bpm.domain.interactors.login;

import android.util.Log;


import javax.inject.Inject;

import psystems.co.bpm.api.UsStatesApi;
import psystems.co.bpm.api.model.request.login.LoginRequestBody;
import psystems.co.bpm.api.model.request.login.LoginRequestData;
import psystems.co.bpm.api.model.request.login.LoginRequestEnvelope;
import psystems.co.bpm.api.model.response.LoginResponseEnvelope;
import psystems.co.bpm.domain.threads.InteractorExecutor;
import psystems.co.bpm.domain.threads.MainThread;
//import psystems.co.bpm.util.ZipCodeMapperDomain;
import retrofit2.Call;
import retrofit2.Response;


public class LoginInteractorImpl implements LoginInteractor {

    private String userName;

    private String password;

    private Callback callback;

    @Inject
    UsStatesApi usStatesApi;

//    @Inject
//    ZipCodeMapperDomain zipCodeMapperDomain;

    @Inject
    MainThread mainThread;

    @Inject
    InteractorExecutor interactorExecutor;

    @Inject
    public LoginInteractorImpl() {
    }

    @Override
    public void execute(String cityName, String password, Callback callback) {

        this.userName = cityName;

        this.password=password;

        this.callback = callback;

        interactorExecutor.run( this );

    }

    @Override
    public void run() {

        //Creation of the envelope and the message.
        LoginRequestEnvelope loginRequestEnvelope=new LoginRequestEnvelope();

        LoginRequestBody loginRequestBody=new LoginRequestBody();

        LoginRequestData loginRequestData=new LoginRequestData();

        loginRequestData.setUserName(userName);
        loginRequestData.setPassword(password);

        loginRequestBody.setLoginRequestData(loginRequestData);
        loginRequestEnvelope.setBody(loginRequestBody);

        Call<LoginResponseEnvelope> call = usStatesApi.requestLoginInfo(loginRequestEnvelope);
        call.enqueue(new retrofit2.Callback<LoginResponseEnvelope>() {

            @Override
            public void onResponse(Call<LoginResponseEnvelope> call, final Response<LoginResponseEnvelope> response) {

                mainThread.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        if (response.code()==200)
                        {
                         //   Log.e("response","response=="+response.code());
                            callback.onSucess(response.body().getBody());
                        }

                        else
                        {
                            callback.onError();
                        }

                    }

                });

            }

            @Override
            public void onFailure(Call<LoginResponseEnvelope> call, Throwable t) {

                mainThread.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        Log.e("response","erorr==");
                        callback.onError();

                    }
                });

            }
        });

    }

    @Override
    public void runSorting() {

    }

}
