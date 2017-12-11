package psystems.co.bpm.api.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ADEL on 12/6/2017.
 */

public class TaskInitiatiable implements Parcelable {
    @SerializedName("InitiatiableTasks")
    private ArrayList<TaskInitiate> taskInitiateArrayList;

    @SerializedName("token")
    private String token;

    protected TaskInitiatiable(Parcel in) {
    }

    public static final Creator<TaskInitiatiable> CREATOR = new Creator<TaskInitiatiable>() {
        @Override
        public TaskInitiatiable createFromParcel(Parcel in) {
            return new TaskInitiatiable(in);
        }

        @Override
        public TaskInitiatiable[] newArray(int size) {
            return new TaskInitiatiable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(taskInitiateArrayList);
    }

    public ArrayList<TaskInitiate> getTaskInitiateArrayList() {
        return taskInitiateArrayList;
    }

    public void setTaskInitiateArrayList(ArrayList<TaskInitiate> taskInitiateArrayList) {
        this.taskInitiateArrayList = taskInitiateArrayList;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
