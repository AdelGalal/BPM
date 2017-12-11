package psystems.co.bpm.domain.interactors.tasks;

import android.util.Log;

import com.google.gson.JsonElement;

import javax.inject.Inject;

import psystems.co.bpm.api.Gson;
import psystems.co.bpm.api.JsonClientApi;
import psystems.co.bpm.api.model.response.TaskInitiatiable;
import psystems.co.bpm.domain.threads.InteractorExecutorOfInitiateTasks;
import psystems.co.bpm.domain.threads.MainThread;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by ADEL on 12/6/2017.
 */

public class TaskInitiateInteractorImpl implements TaskInitiateInteractor {

    private CallbackOfTaskInitiate callback;
    private String token;
    private TaskInitiatiable taskInitiatiable;
    @Inject
    JsonClientApi jsonClientApi;

    @Inject
    MainThread mainThread;

    @Inject
    InteractorExecutorOfInitiateTasks interactorExecutor;

    @Inject
    public TaskInitiateInteractorImpl() {

    }

    @Override
    public void execute(String token, CallbackOfTaskInitiate taskInitiateCallback) {

        this.token=token;
        this.callback= taskInitiateCallback;
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
        Call<JsonElement> call = jsonClientApi.getInitiateTasks(token);
        call.enqueue(new retrofit2.Callback<JsonElement>() {

            @Override
            public void onResponse(Call<JsonElement> call, final Response<JsonElement> response) {
                Log.e("response","response of InitiateTasks json=="+response.code());
                mainThread.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        if (response.isSuccessful())
                        {
                            taskInitiatiable = Gson.parseInitiateTasks(response.body());
                            Log.e("response","response=="+response.body());
                            //   Log.e("response","task sorted array size=="+taskListResponse.getTasksEntityResponseArrayList().size());
                            callback.onSucess(taskInitiatiable);
                            Log.e("response","size of inita tasks=="+taskInitiatiable.getTaskInitiateArrayList().size());
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

    }

    @Override
    public void runInitiatbleTaskUrl() {

    }
}
