package psystems.co.bpm.api.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ADEL on 12/6/2017.
 */

public class TaskInitiate implements Parcelable {

    @SerializedName("applicationLinkDisplayName")
    private String applicationLinkDisplayName;

    @SerializedName("initcompositeDN")
    private String initcompositeDN;
    protected TaskInitiate(Parcel in) {
    }

    public static final Creator<TaskInitiate> CREATOR = new Creator<TaskInitiate>() {
        @Override
        public TaskInitiate createFromParcel(Parcel in) {
            return new TaskInitiate(in);
        }

        @Override
        public TaskInitiate[] newArray(int size) {
            return new TaskInitiate[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(applicationLinkDisplayName);
        parcel.writeString(initcompositeDN);
    }

    public String getApplicationLinkDisplayName() {
        return applicationLinkDisplayName;
    }

    public void setApplicationLinkDisplayName(String applicationLinkDisplayName) {
        this.applicationLinkDisplayName = applicationLinkDisplayName;
    }

    public String getInitcompositeDN() {
        return initcompositeDN;
    }

    public void setInitcompositeDN(String initcompositeDN) {
        this.initcompositeDN = initcompositeDN;
    }
}
