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

    public static void saveOrderColumn(Context mContext, String  orderColumn){

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ORDER_COLUMN, orderColumn);
        editor.apply();
    }
    public static String loadOrderColumn(Context mContext){
        SharedPreferences  sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

        String order_column = sharedPreferences.getString(ORDER_COLUMN,"Date");
        return order_column;
    }

    public static void saveOrderIn(Context mContext, String orderIn){

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ORDER_IN, orderIn);
        editor.apply();
    }
    public static String loadOrderIn(Context mContext){
        SharedPreferences  sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

        String orderIn = sharedPreferences.getString(ORDER_IN, "ASC");
        return orderIn;
    }
}
