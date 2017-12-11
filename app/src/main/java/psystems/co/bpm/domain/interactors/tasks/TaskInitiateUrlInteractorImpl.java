package psystems.co.bpm.domain.interactors.tasks;

import android.util.Log;

import com.google.gson.JsonElement;

import javax.inject.Inject;

import psystems.co.bpm.api.Gson;
import psystems.co.bpm.api.JsonClientApi;
import psystems.co.bpm.api.model.response.TaskInitiatiableURL;
import psystems.co.bpm.domain.threads.InteractorExecutorOfInitiateTaskUrl;
import psystems.co.bpm.domain.threads.MainThread;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by ADEL on 12/6/2017.
 */

public class TaskInitiateUrlInteractorImpl implements TaskInitiateUrlInteractor {
    private CallbackOfTaskInitiateURL callbackOfTaskInitiateURL;
    private String token;
    private String initcompositeDN;
    private TaskInitiatiableURL taskInitiatiableURL;
    @Inject
    JsonClientApi jsonClientApi;

    @Inject
    MainThread mainThread;

    @Inject
    InteractorExecutorOfInitiateTaskUrl interactorExecutor;

    @Inject
    public TaskInitiateUrlInteractorImpl() {

    }
    @Override
    public void execute(String token, String initcompositeDN, CallbackOfTaskInitiateURL callbackOfTaskInitiateURL) {
        this.token=token;
        this.initcompositeDN=initcompositeDN;
        this.callbackOfTaskInitiateURL= callbackOfTaskInitiateURL;
        interactorExecutor.run(this);
    }

    @Override
    public void run() {

    }

    @Override
    public void runSorting() {

    }

    @Override
    public void runInitiateTask() {

    }

    @Override
    public void runInitiatbleTaskUrl() {
        Call<JsonElement> call = jsonClientApi.getinitiateTaskURL(initcompositeDN,token);
        call.enqueue(new retrofit2.Callback<JsonElement>() {

            @Override
            public void onResponse(Call<JsonElement> call, final Response<JsonElement> response) {
                Log.e("response","response of json=="+response.code());
                mainThread.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        if (response.isSuccessful())
                        {
                            taskInitiatiableURL = Gson.parseInitiatiableURL(response.body());
                            Log.e("response","response=="+response.body());
                            Log.e("response","task url=="+taskInitiatiableURL.getTaskURL());
                            callbackOfTaskInitiateURL.onSucess(taskInitiatiableURL.getTaskURL());
                            //Log.e("response","size=="+response.body().getBody().getTaskElements().size());
                        }

                        else
                        {
                            callbackOfTaskInitiateURL.onError();
                        }

                    }

                });

            }

            @Override
            public void onFailure(final Call<JsonElement> call, final Throwable t) {

                mainThread.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        Log.e("response","erorr of tasks=="+t.getMessage());
                        callbackOfTaskInitiateURL.onError();

                    }
                });

            }
        });
    }
}
