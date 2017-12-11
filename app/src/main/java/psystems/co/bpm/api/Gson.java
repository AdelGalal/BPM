package psystems.co.bpm.api;

import com.google.gson.JsonElement;

import psystems.co.bpm.api.model.login.LoginResponse;
import psystems.co.bpm.api.model.response.TaskDetailsURLResponse;
import psystems.co.bpm.api.model.response.TaskInitiate;
import psystems.co.bpm.api.model.response.TaskInitiatiable;
import psystems.co.bpm.api.model.response.TaskInitiatiableURL;
import psystems.co.bpm.api.model.response.TaskListResponse;

/**
 * Created by ADEL on 11/23/2017.
 */

public class Gson {

    public static LoginResponse parseAuthenticateURL(JsonElement json) {
        LoginResponse response;
        com.google.gson.Gson gson = new com.google.gson.Gson();
        try {
            response = gson.fromJson(json, LoginResponse.class);
        } catch (Exception ex) {
            return null;
        }
        return response;
    }

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

    public static TaskInitiatiable parseInitiateTasks(JsonElement json) {
        TaskInitiatiable response;
        com.google.gson.Gson gson = new com.google.gson.Gson();
        try {
            response = gson.fromJson(json, TaskInitiatiable.class);
        } catch (Exception ex) {
            return null;
        }
        return response;
    }

    public static TaskInitiatiableURL parseInitiatiableURL(JsonElement json) {
        TaskInitiatiableURL response;
        com.google.gson.Gson gson = new com.google.gson.Gson();
        try {
            response = gson.fromJson(json, TaskInitiatiableURL.class);
        } catch (Exception ex) {
            return null;
        }
        return response;
    }
}
