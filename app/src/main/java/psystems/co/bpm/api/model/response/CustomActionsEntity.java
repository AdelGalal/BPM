package psystems.co.bpm.api.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ADEL on 11/29/2017.
 */

public class CustomActionsEntity implements Parcelable {
    @SerializedName("customActions")
    private String customActions;
    protected CustomActionsEntity(Parcel in) {
    }

    public static final Creator<CustomActionsEntity> CREATOR = new Creator<CustomActionsEntity>() {
        @Override
        public CustomActionsEntity createFromParcel(Parcel in) {
            return new CustomActionsEntity(in);
        }

        @Override
        public CustomActionsEntity[] newArray(int size) {
            return new CustomActionsEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
