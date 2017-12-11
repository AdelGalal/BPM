package psystems.co.bpm.api.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ADEL on 11/23/2017.
 */

public class TaskDetailsURLResponse implements Parcelable {
    @SerializedName("taskURL")
    private String taskURL;

    @SerializedName("token")
    private String token;

    protected TaskDetailsURLResponse(Parcel in) {
        taskURL = in.readString();
    }

    public static final Creator<TaskDetailsURLResponse> CREATOR = new Creator<TaskDetailsURLResponse>() {
        @Override
        public TaskDetailsURLResponse createFromParcel(Parcel in) {
            return new TaskDetailsURLResponse(in);
        }

        @Override
        public TaskDetailsURLResponse[] newArray(int size) {
            return new TaskDetailsURLResponse[size];
        }
    };

    public String getTaskURL() {
        return taskURL;
    }

    public void setTaskURL(String taskURL) {
        this.taskURL = taskURL;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(taskURL);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
