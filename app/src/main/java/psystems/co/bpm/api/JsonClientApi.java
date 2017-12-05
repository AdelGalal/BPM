package psystems.co.bpm.api;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by ADEL on 11/23/2017.
 */

public interface JsonClientApi {
    @GET("/MobileProxy/resources/iworkspace/getTaskDisplayURL?")
    Call<JsonElement> getTaskURLOfDetails(@Query("taskid") String
                                                  taskId, @Header("token") String token);

    @GET("/MobileProxy/resources/iworkspace/getUserInbox?")
    Call<JsonElement> getSortedTasks(@Query("orderColumn") String
                                             taskId,@Query("order")String order,
                                     @Query("fromDate")String fromDate, @Query("toDate")String toDate,
                                     @Query("filter")String filter, @Query("state")String state,@Query("keywords")String keywords,
                                     @Header("token") String token);

}
