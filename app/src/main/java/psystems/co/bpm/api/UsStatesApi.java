package psystems.co.bpm.api;

import com.google.gson.JsonElement;

import psystems.co.bpm.api.model.request.login.LoginRequestEnvelope;
import psystems.co.bpm.api.model.request.TasksRequestEnvelope;
import psystems.co.bpm.api.model.response.LoginResponseEnvelope;
import psystems.co.bpm.api.model.response.TaskResponseEnvelope;
import psystems.co.bpm.api.model.response.TaskDetailsURLResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UsStatesApi {

    @Headers({
            "Content-Type: text/xml",
            "Accept-Charset: utf-8"
    })
    @POST("/integration/services/TaskQueryService/TaskQueryService")
    Call<LoginResponseEnvelope> requestLoginInfo(@Body LoginRequestEnvelope body);

    @Headers({
            "Content-Type: text/xml",
            "Accept-Charset: utf-8"
    })
    @POST("/integration/services/TaskQueryService/TaskQueryService")
    Call<TaskResponseEnvelope> requestTasks(@Body TasksRequestEnvelope body);


}
