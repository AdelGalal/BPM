package psystems.co.bpm.api.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ADEL on 12/6/2017.
 */

public class TaskInitiatiableURL implements Parcelable {
    @SerializedName("newTaskUrl")
    private String taskURL;

    @SerializedName("token")
    private String token;

    protected TaskInitiatiableURL(Parcel in) {
    }

    public static final Creator<TaskInitiatiableURL> CREATOR = new Creator<TaskInitiatiableURL>() {
        @Override
        public TaskInitiatiableURL createFromParcel(Parcel in) {
            return new TaskInitiatiableURL(in);
        }

        @Override
        public TaskInitiatiableURL[] newArray(int size) {
            return new TaskInitiatiableURL[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }

    public String getTaskURL() {
        return taskURL;
    }

    public void setTaskURL(String taskURL) {
        this.taskURL = taskURL;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
