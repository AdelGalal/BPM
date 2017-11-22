package psystems.co.bpm.domain.interactors.tasks;

import android.util.Log;

import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;

import psystems.co.bpm.api.UsStatesApi;
import psystems.co.bpm.api.model.request.TaskClauseRequest;
import psystems.co.bpm.api.model.request.TaskColumnNameRequest;
import psystems.co.bpm.api.model.request.TaskDisplayColumnListRequest;
import psystems.co.bpm.api.model.request.TaskListRequest;
import psystems.co.bpm.api.model.request.TaskOptionalInfoRequest;
import psystems.co.bpm.api.model.request.TaskPredicateQueryRequest;
import psystems.co.bpm.api.model.request.TaskPredicateRequest;
import psystems.co.bpm.api.model.request.TaskRequestBody;
import psystems.co.bpm.api.model.request.TaskValuesList;
import psystems.co.bpm.api.model.request.TaskWorkFlowContextRequest;
import psystems.co.bpm.api.model.request.TasksRequestEnvelope;
import psystems.co.bpm.api.model.response.TaskResponseBody;
import psystems.co.bpm.api.model.response.TaskResponseEnvelope;
import psystems.co.bpm.domain.threads.InteractorExecutor;
import psystems.co.bpm.domain.threads.MainThread;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by ADEL on 11/15/2017.
 */

public class TaskInteractorImpl implements TaskInteractor {

    private String token;
    private String displayFirstColumn;
    private String displaySecondColumn;
    private String displayThirdColumn;
    private String displayFourthColumn;
    private String displayFifthColumn;
    private String displaySixthColumn;
    private String taskFirstOptionalInfo;
    private String taskSecondOptionalInfo;
    private String assignmentFilter;

    private Callback callback;

    @Inject
    UsStatesApi usStatesApi;

    @Inject
    MainThread mainThread;

    @Inject
    InteractorExecutor interactorExecutor;

    @Inject
    public TaskInteractorImpl() {

    }

    @Override
    public void run() {

        //Creation of the envelope and the message.
        TasksRequestEnvelope tasksRequestEnvelope=new TasksRequestEnvelope();
        TaskRequestBody taskRequestBody=new TaskRequestBody();
        TaskListRequest taskListRequest=new TaskListRequest();
        TaskWorkFlowContextRequest taskWorkFlowContextRequest=new TaskWorkFlowContextRequest();
        taskWorkFlowContextRequest.setToken(token);

        TaskPredicateQueryRequest taskPredicateQueryRequest=new TaskPredicateQueryRequest();
        TaskDisplayColumnListRequest taskDisplayColumnListRequest =new TaskDisplayColumnListRequest();

            taskDisplayColumnListRequest.setDisplayFirstColumn(displayFirstColumn);

            taskDisplayColumnListRequest.setDisplaySecondColumn(displaySecondColumn);

            taskDisplayColumnListRequest.setDisplayThirdColumn(displayThirdColumn);

           taskDisplayColumnListRequest.setDisplayFourthColumn(displayFourthColumn);
            taskDisplayColumnListRequest.setDisplayFifthColumn(displayFifthColumn);

           taskDisplayColumnListRequest.setDisplaySixthColumn(displaySixthColumn);
        taskPredicateQueryRequest.setTaskDisplayColumn(taskDisplayColumnListRequest);

        TaskOptionalInfoRequest taskOptionalInfoRequest=new TaskOptionalInfoRequest();
        taskOptionalInfoRequest.setTaskFirstOptionalInfo(taskFirstOptionalInfo);
        taskOptionalInfoRequest.setTaskSecondOptionalInfo(taskSecondOptionalInfo);
        taskPredicateQueryRequest.setTaskOptionalInfo(taskOptionalInfoRequest);

        TaskPredicateRequest taskPredicateRequest=new TaskPredicateRequest();
        taskPredicateRequest.setAssignmentFilter(assignmentFilter);
        TaskClauseRequest taskClauseRequest=new TaskClauseRequest();
       // taskClauseRequest.setTableName("tableName=\"WFTask\"");
        TaskColumnNameRequest taskColumnNameRequest=new TaskColumnNameRequest();
        taskColumnNameRequest.setColumnName("state");
        taskClauseRequest.setTaskColumnNameRequest(taskColumnNameRequest);
        taskClauseRequest.setTaskOperatorRequest("IN");
        TaskValuesList taskValuesList=new TaskValuesList();
        taskValuesList.setFirstValue("ASSIGNED");
        taskValuesList.setSecondValue("INFO_REQUESTED");
        taskValuesList.setThirdValue("COMPLETED");
        taskClauseRequest.setTaskValuesList(taskValuesList);

        taskPredicateRequest.setTaskClauseRequest(taskClauseRequest);
        taskPredicateQueryRequest.setTaskPredicateRequest(taskPredicateRequest);

        taskListRequest.setTaskWorkFlowContextRequest(taskWorkFlowContextRequest);
        taskListRequest.setTaskPredicateQueryRequest(taskPredicateQueryRequest);
        taskRequestBody.setTaskListRequest(taskListRequest);

        tasksRequestEnvelope.setBody(taskRequestBody);

        Call<TaskResponseEnvelope> call = usStatesApi.requestTasks(tasksRequestEnvelope);
        call.enqueue(new retrofit2.Callback<TaskResponseEnvelope>() {

            @Override
            public void onResponse(Call<TaskResponseEnvelope> call, final Response<TaskResponseEnvelope> response) {
                Log.e("response","response1111=="+response.code());
                mainThread.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        if (response.code()==200)
                        {
                            Log.e("response","response=="+response.code());
                           callback.onSucess(response.body().getBody().getTaskElements());
                            Log.e("response","size=="+response.body().getBody().getTaskElements().size());
                        }

                        else
                        {
                          //  callback.onError();
                        }

                    }

                });

            }

            @Override
            public void onFailure(final Call<TaskResponseEnvelope> call, final Throwable t) {

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
    public void execute(String token, String displayFirstColumn, String displaySecondColumn, String displayThirdColumn, String displayFourthColumn, String displayFifthColumn, String displaySixthColumn, String taskFirstOptionalInfo, String taskSecondOptionalInfo, String assignmentFilter, Callback callback) {
        this.token=token;
        this.displayFirstColumn=displayFirstColumn;
        this.displaySecondColumn=displaySecondColumn;
        this.displayThirdColumn=displayThirdColumn;
        this.displayFourthColumn=displayFourthColumn;
        this.displayFifthColumn=displayFifthColumn;
        this.displaySixthColumn=displaySixthColumn;
        this.taskFirstOptionalInfo=taskFirstOptionalInfo;
        this.taskSecondOptionalInfo=taskSecondOptionalInfo;
        this.assignmentFilter=assignmentFilter;
        this.callback=callback;

        interactorExecutor.run( this );
    }
}
