package psystems.co.bpm.api;

import psystems.co.bpm.api.model.request.login.LoginRequestEnvelope;
import psystems.co.bpm.api.model.request.TasksRequestEnvelope;
import psystems.co.bpm.api.model.response.LoginResponseEnvelope;
import psystems.co.bpm.api.model.response.TaskResponseEnvelope;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

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
