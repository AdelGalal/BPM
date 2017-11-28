package psystems.co.bpm.domain.interactors.tasks;

import android.util.Log;

import com.google.gson.JsonElement;

import javax.inject.Inject;

import psystems.co.bpm.api.Gson;
import psystems.co.bpm.api.JsonClientApi;
import psystems.co.bpm.api.model.response.TaskDetailsURLResponse;
import psystems.co.bpm.domain.threads.InteractorExecutorOfTaskDetails;
import psystems.co.bpm.domain.threads.MainThread;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by ADEL on 11/23/2017.
 */

public class TaskDetailsInteractorImpl implements TaskDetailsInteractor {

    private CallbackOfTaskDetails callback;
    private String token;
    private String taskID;
    private TaskDetailsURLResponse taskDetailsURLResponse;

    @Inject
    JsonClientApi jsonClientApi;

    @Inject
    MainThread mainThread;

    @Inject
    InteractorExecutorOfTaskDetails interactorExecutor;

    @Inject
    public TaskDetailsInteractorImpl() {

    }


    @Override
    public void execute(String taskID, String token,CallbackOfTaskDetails callbackOfTaskDetails) {
        this.taskID=taskID;
        this.token=token;
        this.callback=callbackOfTaskDetails;
        interactorExecutor.run(this);
    }

    @Override
    public void run() {
        Call<JsonElement> call = jsonClientApi.getTaskURLOfDetails(taskID,token);
        call.enqueue(new retrofit2.Callback<JsonElement>() {

            @Override
            public void onResponse(Call<JsonElement> call, final Response<JsonElement> response) {
                Log.e("response","response1111 of json=="+response.code());
                mainThread.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        if (response.isSuccessful())
                        {
                            taskDetailsURLResponse = Gson.parseTaskDetailsURL(response.body());
                            Log.e("response","response=="+response.body());
                            Log.e("response","task url=="+taskDetailsURLResponse.getTaskURL());
                            callback.onSucess(taskDetailsURLResponse.getTaskURL());
                            //Log.e("response","size=="+response.body().getBody().getTaskElements().size());
                        }

                        else
                        {
                              callback.onError();
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
                        callback.onError();

                    }
                });

            }
        });
        ////////////////////////////////////////////////////////////////
    }
}
