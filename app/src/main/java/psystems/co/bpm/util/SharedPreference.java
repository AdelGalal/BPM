package psystems.co.bpm.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.RadioButton;

import com.google.gson.Gson;

public class SharedPreference {

    private static final String SP_NAME = "BPM";
    private static final String FIRST_RADIO_BUTTONS="first_order";
    private static final String SECOND_RADIO_BUTTONS="second_order";
    private static final String ORDER_COLUMN="order_column";
    private static final String ORDER_IN="order_in";
    private static final String FILTER_BY_GROUP="filter_by_group";
    private static final String FILTER_BY_GROUP_ITEM="filter_by_group_item";
    private static final String FILTER_BY_SEVERITY="filter_by_severity";
    private static final String FILTER_BY_SEVERITY_ITEM="filter_by_severity_item";
    private static final String FROM_DATE="from_date";
    private static final String TO_DATE="to_date";
    private static final String FILTER_ASSIGNED="filter_assigned";
    private static final String FILTER_COMPLETED="filter_completed";
    private static final String FILTER_REQUEST_INFO="filter_request_info";
    private static final String FILTER_KEYWORD="filter_keyword";


    public static final String SP_USER_INFO = "userInfo";

    public static void save_SP_Data(Context mContext, String key,
                                    Object object) {

        SharedPreferences sharedPref = mContext
                .getSharedPreferences(SP_NAME,
                        Context.MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPref
                .edit();

        Gson gson = new Gson();
        String json = gson.toJson(object);

        prefsEditor.putString(key, json);
        prefsEditor.commit();
    }

    public static Object load_SP_Data(Context mContext, String key,
                                      Class<?> returnType) {

        SharedPreferences sharedPref = mContext.getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);

        Gson gson = new Gson();

        String json = sharedPref.getString(key, null);

        if (json != null) {

            return gson.fromJson(json, returnType);
        }

        return null;
    }


    public static void removeAllKeySP(Context mContext)
    {
        SharedPreferences sharedPref = mContext.getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);

        sharedPref.edit().clear().commit();
    }

    public static void saveFirstRadioButtons(Context mContext, int id){

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(FIRST_RADIO_BUTTONS, id);
        editor.apply();
    }
    public static int loadFirstRadioButtons(Context mContext){
        SharedPreferences  sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

        int answerD = sharedPreferences.getInt(FIRST_RADIO_BUTTONS, 0);
        return answerD;
    }

    public static void saveSecondRadioButtons(Context mContext, int id){

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SECOND_RADIO_BUTTONS, id);
        editor.apply();
    }
    public static int loadSecondRadioButtons(Context mContext){
        SharedPreferences  sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

        int answerD = sharedPreferences.getInt(SECOND_RADIO_BUTTONS, 0);
        return answerD;
    }

    public static void saveOrderColumn(Context mContext, String  orderColumn)
    {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ORDER_COLUMN, orderColumn);
        editor.apply();
    }
    public static String loadOrderColumn(Context mContext)
    {
        SharedPreferences  sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

        String order_column = sharedPreferences.getString(ORDER_COLUMN,"Date");
        return order_column;
    }

    public static void saveOrderIn(Context mContext, String orderIn)
    {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ORDER_IN, orderIn);
        editor.apply();
    }
    public static String loadOrderIn(Context mContext)
    {
        SharedPreferences  sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

        String orderIn = sharedPreferences.getString(ORDER_IN, "ASC");
        return orderIn;
    }

    public static void saveFilterByGroup(Context mContext, String filterByGroup)
    {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FILTER_BY_GROUP, filterByGroup);
        editor.apply();
    }
    public static String loadFilterByGroup(Context mContext)
    {
        SharedPreferences  sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

        String filterByGroup = sharedPreferences.getString(FILTER_BY_GROUP, null);
        return filterByGroup;
    }

    public static void saveFilterByGroupId(Context mContext, int filterByGroupItem)
    {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(FILTER_BY_GROUP_ITEM, filterByGroupItem);
        editor.apply();
    }
    public static int loadFilterByGroupId(Context mContext)
    {
        SharedPreferences  sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

        int filterByGroupItem = sharedPreferences.getInt(FILTER_BY_GROUP_ITEM, 0);
        return filterByGroupItem;
    }

    public static void saveFilterBySeverity(Context mContext, String filterBySeverity)
    {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FILTER_BY_SEVERITY, filterBySeverity);
        editor.apply();
    }
    public static String loadFilterBySeverity(Context mContext)
    {
        SharedPreferences  sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

        String filterBySeverity = sharedPreferences.getString(FILTER_BY_SEVERITY, null);
        return filterBySeverity;
    }

    public static void saveFilterBySeverityId(Context mContext, int filterBySeverityItem)
    {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(FILTER_BY_SEVERITY_ITEM, filterBySeverityItem);
        editor.apply();
    }
    public static int loadFilterBySeverityId(Context mContext)
    {
        SharedPreferences  sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

        int filterBySeverityItem = sharedPreferences.getInt(FILTER_BY_SEVERITY_ITEM, 0);
        return filterBySeverityItem;
    }

    public static void saveFromDate(Context mContext, String fromDate)
    {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FROM_DATE, fromDate);
        editor.apply();
    }
    public static String loadFilterFromDate(Context mContext)
    {
        SharedPreferences  sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

        String FromDate = sharedPreferences.getString(FROM_DATE, null);
        return FromDate;
    }

    public static void saveToDate(Context mContext, String toDate)
    {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TO_DATE, toDate);
        editor.apply();
    }
    public static String loadFilterToDate(Context mContext)
    {
        SharedPreferences  sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

        String toDate = sharedPreferences.getString(TO_DATE, null);
        return toDate;
    }

    public static void saveFilterAssigned(Context mContext, String assigned)
    {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FILTER_ASSIGNED, assigned);
        editor.apply();
    }
    public static String loadFilterAssigned(Context mContext)
    {
        SharedPreferences  sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

        String assigned = sharedPreferences.getString(FILTER_ASSIGNED, null);
        return assigned;
    }

    public static void saveFilterCompleted(Context mContext, String completed)
    {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FILTER_COMPLETED, completed);
        editor.apply();
    }
    public static String loadFilterCompleted(Context mContext)
    {
        SharedPreferences  sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

        String completed = sharedPreferences.getString(FILTER_COMPLETED, null);
        return completed;
    }

    public static void saveFilterRequestInfo(Context mContext, String requestInfo)
    {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FILTER_REQUEST_INFO, requestInfo);
        editor.apply();
    }
    public static String loadFilterRequestInfo(Context mContext)
    {
        SharedPreferences  sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

        String requestInfo = sharedPreferences.getString(FILTER_REQUEST_INFO, null);
        return requestInfo;
    }

    public static void saveFilterKeyWord(Context mContext, String KeyWord)
    {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FILTER_KEYWORD, KeyWord);
        editor.apply();
    }
    public static String loadFilterKeyWord(Context mContext)
    {
        SharedPreferences  sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

        String KeyWord = sharedPreferences.getString(FILTER_KEYWORD, null);
        return KeyWord;
    }
}
