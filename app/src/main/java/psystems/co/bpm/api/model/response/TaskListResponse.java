package psystems.co.bpm.api.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ADEL on 11/29/2017.
 */

public class TaskListResponse implements Parcelable {
    @SerializedName("tasks")
    private ArrayList<TasksEntityResponse> tasksEntityResponseArrayList;
    protected TaskListResponse(Parcel in) {
    }

    public static final Creator<TaskListResponse> CREATOR = new Creator<TaskListResponse>() {
        @Override
        public TaskListResponse createFromParcel(Parcel in) {
            return new TaskListResponse(in);
        }

        @Override
        public TaskListResponse[] newArray(int size) {
            return new TaskListResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(tasksEntityResponseArrayList);
    }

    public ArrayList<TasksEntityResponse> getTasksEntityResponseArrayList() {
        return tasksEntityResponseArrayList;
    }

    public void setTasksEntityResponseArrayList(ArrayList<TasksEntityResponse> tasksEntityResponseArrayList) {
        this.tasksEntityResponseArrayList = tasksEntityResponseArrayList;
    }
}
