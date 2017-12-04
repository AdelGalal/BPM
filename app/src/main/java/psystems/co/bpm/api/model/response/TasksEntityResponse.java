package psystems.co.bpm.api.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ADEL on 11/29/2017.
 */

public class TasksEntityResponse implements Parcelable {

    @SerializedName("taskNumber")
    private int taskNumber;

    @SerializedName("flowID")
    private int taskFlowID;

    @SerializedName("title")
    private String title;

    @SerializedName("taskId")
    private String taskId;

    @SerializedName("priority")
    private int priority;

    @SerializedName("state")
    private String state;

    @SerializedName("assignedDate")
    private String assignedDate;

    @SerializedName("instanceId")
    private int instanceId;

    @SerializedName("systemActions")
    private ArrayList<TaskSystemActionEntity> taskSystemActionEntityArrayList;

    @SerializedName("customActions")
    private ArrayList<CustomActionsEntity> customActionsEntityArrayList;

    @SerializedName("participant")
    private String participant;

    @SerializedName("creator")
    private String creator;

    @SerializedName("outcome")
    private String outcome;

    @SerializedName("updatedBy")
    private String updatedBy;

    @SerializedName("startDate")
    private String startDate;


    @SerializedName("endDate")
    private String endDate;

    @SerializedName("updatedDate")
    private String updatedDate;

    @SerializedName("updatedByArabicName")
    private String updatedByArabicName;

    @SerializedName("updatedHijriDate")
    private String updatedHijriDate;

    @SerializedName("tstate")
    private String tstate;

    @SerializedName("taskDefinitionID")
    private String taskDefinitionID;

    protected TasksEntityResponse(Parcel in) {
    }

    public static final Creator<TasksEntityResponse> CREATOR = new Creator<TasksEntityResponse>() {
        @Override
        public TasksEntityResponse createFromParcel(Parcel in) {
            return new TasksEntityResponse(in);
        }

        @Override
        public TasksEntityResponse[] newArray(int size) {
            return new TasksEntityResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(taskNumber);
        parcel.writeInt(taskFlowID);
        parcel.writeString(title);
        parcel.writeString(taskId);
        parcel.writeInt(priority);
        parcel.writeString(state);
        parcel.writeString(assignedDate);
        parcel.writeInt(instanceId);
        parcel.writeSerializable(taskSystemActionEntityArrayList);
        parcel.writeSerializable(customActionsEntityArrayList);
        parcel.writeString(participant);
        parcel.writeString(creator);
        parcel.writeString(outcome);
        parcel.writeString(updatedBy);
        parcel.writeString(startDate);
        parcel.writeString(endDate);
        parcel.writeString(updatedDate);
        parcel.writeString(taskDefinitionID);
        parcel.writeString(updatedByArabicName);
        parcel.writeString(updatedHijriDate);
        parcel.writeString(tstate);
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public int getTaskFlowID() {
        return taskFlowID;
    }

    public void setTaskFlowID(int taskFlowID) {
        this.taskFlowID = taskFlowID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(String assignedDate) {
        this.assignedDate = assignedDate;
    }

    public int getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(int instanceId) {
        this.instanceId = instanceId;
    }


    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedHijriDate() {
        return updatedHijriDate;
    }

    public void setUpdatedHijriDate(String updatedHijriDate) {
        this.updatedHijriDate = updatedHijriDate;
    }

    public String getTstate() {
        return tstate;
    }

    public void setTstate(String tstate) {
        this.tstate = tstate;
    }

    public String getTaskDefinitionID() {
        return taskDefinitionID;
    }

    public void setTaskDefinitionID(String taskDefinitionID) {
        this.taskDefinitionID = taskDefinitionID;
    }

    public ArrayList<TaskSystemActionEntity> getTaskSystemActionEntityArrayList() {
        return taskSystemActionEntityArrayList;
    }

    public void setTaskSystemActionEntityArrayList(ArrayList<TaskSystemActionEntity> taskSystemActionEntityArrayList) {
        this.taskSystemActionEntityArrayList = taskSystemActionEntityArrayList;
    }

    public void setUpdatedByArabicName(String updatedByArabicName) {
        this.updatedByArabicName = updatedByArabicName;
    }
}
