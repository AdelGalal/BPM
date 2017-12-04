package psystems.co.bpm.api;

import com.google.gson.JsonElement;

import psystems.co.bpm.api.model.response.TaskDetailsURLResponse;
import psystems.co.bpm.api.model.response.TaskListResponse;

/**
 * Created by ADEL on 11/23/2017.
 */

public class Gson {
    public static TaskDetailsURLResponse parseTaskDetailsURL(JsonElement json) {
        TaskDetailsURLResponse response;
        com.google.gson.Gson gson = new com.google.gson.Gson();
        try {
            response = gson.fromJson(json, TaskDetailsURLResponse.class);
        } catch (Exception ex) {
            return null;
        }
        return response;
    }

    public static  TaskListResponse parseSortedTasksURL(JsonElement json) {
        TaskListResponse response;
        com.google.gson.Gson gson = new com.google.gson.Gson();
        try {
            response = gson.fromJson(json, TaskListResponse.class);
        } catch (Exception ex) {
            return null;
        }
        return response;
    }
}
