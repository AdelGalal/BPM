package psystems.co.bpm.api.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ADEL on 11/29/2017.
 */

public class TaskSystemActionEntity implements Parcelable {
    @SerializedName("displayName")
    private String displayName;

    @SerializedName("action")
    private String action;

    protected TaskSystemActionEntity(Parcel in) {
    }

    public static final Creator<TaskSystemActionEntity> CREATOR = new Creator<TaskSystemActionEntity>() {
        @Override
        public TaskSystemActionEntity createFromParcel(Parcel in) {
            return new TaskSystemActionEntity(in);
        }

        @Override
        public TaskSystemActionEntity[] newArray(int size) {
            return new TaskSystemActionEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
