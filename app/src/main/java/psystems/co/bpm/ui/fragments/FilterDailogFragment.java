package psystems.co.bpm.ui.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import psystems.co.bpm.R;
import psystems.co.bpm.ui.activities.MainActivity;
import psystems.co.bpm.util.SharedPreference;

/**
 * Created by ADEL on 12/4/2017.
 */

public class FilterDailogFragment extends DialogFragment implements View.OnClickListener {
    private static FilterDailogFragment fragment;
    private View rootView;
    private Calendar myCalendar1 ;
    private Calendar myCalendar2 ;
    private String[]filterByGroup;
    private String[]filterBySeverity;
    private Spinner filter_by_group_spinner;
    private Spinner filter_by_severity_spinner;
    private EditText from_date_edit;
    private ImageView from_date_imageView;
    private EditText to_date_edit;
    private EditText filter_editText;
    private ImageView to_date_imageView;
    private Button apply_btn;
    private CheckBox assigned_checkBox;
    private CheckBox completed_checkBox;
    private CheckBox request_checkBox;

    public static FilterDailogFragment newInstance() {
        return new FilterDailogFragment();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setStyle(DialogFragment.STYLE_NO_TITLE, R.style.dialog);
       // AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.dialog);

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
           rootView = inflater.inflate(R.layout.filter_dailog, container, false);
            getDialog().setTitle(getString(R.string.filter_title));
            initViews();
        }
        return rootView;
    }

    private void initViews() {
       // ((MainActivity)getContext()).showErrorInRequest();
        myCalendar1 = Calendar.getInstance();
        myCalendar2 = Calendar.getInstance();
        filterByGroup= new String[]{getString(R.string.select_filter_group_By),getString(R.string.me),getString(R.string.me_and_mygroup), getString(R.string.group), getString(R.string.me_previous), getString(R.string.reviewer)};
        filterBySeverity=new String[]{getString(R.string.select_filter_by_severity),getString(R.string.any_severity),getString(R.string.very_important),getString(R.string.important),getString(R.string.normal),getString(R.string.low),getString(R.string.very_low)};
        filter_by_group_spinner=(Spinner)rootView.findViewById(R.id.filter_by_group_spinner);
        ArrayAdapter filterByGropuAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,filterByGroup);
        filterByGropuAdapter.setDropDownViewResource(R.layout.spinner_item);
        filter_by_group_spinner.setAdapter(filterByGropuAdapter);
        if (SharedPreference.loadFilterByGroupId(getActivity())!=0)
        {
            filter_by_group_spinner.setSelection(SharedPreference.loadFilterByGroupId(getActivity()));
        }


        ArrayAdapter filterByseverityAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,filterBySeverity);
        filterByseverityAdapter.setDropDownViewResource(R.layout.spinner_item);
        filter_by_severity_spinner=(Spinner)rootView.findViewById(R.id.filter_by_severity_spinner);
        filter_by_severity_spinner.setAdapter(filterByseverityAdapter);
        filter_by_severity_spinner.setAdapter(filterByGropuAdapter);
        if (SharedPreference.loadFilterByGroupId(getActivity())!=0)
        {
            filter_by_severity_spinner.setSelection(SharedPreference.loadFilterBySeverityId(getActivity()));
        }

        from_date_edit=(EditText)rootView.findViewById(R.id.from_date_edit);
        if (SharedPreference.loadFilterFromDate(getActivity())!=null)
        {
            from_date_edit.setText(""+SharedPreference.loadFilterFromDate(getActivity()));
        }
        from_date_imageView=(ImageView)rootView.findViewById(R.id.from_date_imageView);
        from_date_imageView.setOnClickListener(this);
        to_date_edit=(EditText)rootView.findViewById(R.id.to_date_edit);
        if (SharedPreference.loadFilterToDate(getActivity())!=null)
        {
            to_date_edit.setText(""+SharedPreference.loadFilterToDate(getActivity()));
        }
        to_date_imageView=(ImageView)rootView.findViewById(R.id.to_date_imageView);
        to_date_imageView.setOnClickListener(this);
        apply_btn=(Button)rootView.findViewById(R.id.apply_btn);
        apply_btn.setOnClickListener(this);
        filter_editText=(EditText)rootView.findViewById(R.id.filter_editText);
        if (SharedPreference.loadFilterKeyWord(getActivity())!=null)
        {
            filter_editText.setText(SharedPreference.loadFilterKeyWord(getActivity()));
        }
        assigned_checkBox=(CheckBox)rootView.findViewById(R.id.assigned_checkBox);
        if (SharedPreference.loadFilterAssigned(getActivity())!=null)
        {
            assigned_checkBox.setChecked(true);
        }
        completed_checkBox=(CheckBox)rootView.findViewById(R.id.completed_checkBox);
        if (SharedPreference.loadFilterCompleted(getActivity())!=null)
        {
            completed_checkBox.setChecked(true);
        }
        request_checkBox=(CheckBox)rootView.findViewById(R.id.request_checkBox);
        if (SharedPreference.loadFilterRequestInfo(getActivity())!=null)
        {
            request_checkBox.setChecked(true);
        }
    }


    private void ShowDatePicker(DatePickerDialog.OnDateSetListener listener, Calendar myCalendar) {
        new DatePickerDialog(getActivity(), listener, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }
    DatePickerDialog.OnDateSetListener mDateChangeListener1 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
            myCalendar1.set(Calendar.YEAR, year);
            myCalendar1.set(Calendar.MONTH, monthOfYear);
            myCalendar1.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateEdits(from_date_edit, myCalendar1);

        }
    };

    DatePickerDialog.OnDateSetListener mDateChangeListener2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
            myCalendar2.set(Calendar.YEAR, year);
            myCalendar2.set(Calendar.MONTH, monthOfYear);
            myCalendar2.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateEdits(to_date_edit, myCalendar2);

        }
    };

    private void updateEdits(EditText mEditText, Calendar myCalendar) {
        String dateFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);
        mEditText.setText(sdf.format(myCalendar.getTime()));
        if (myCalendar==myCalendar1)
        {
            SharedPreference.saveFromDate(getActivity(),sdf.format(myCalendar.getTime()));
            Log.e("filter dailog","from date="+SharedPreference.loadFilterFromDate(getActivity()));

        }
        else if (myCalendar==myCalendar2)
        {
            SharedPreference.saveToDate(getActivity(),sdf.format(myCalendar.getTime()));
            Log.e("filter dailog","to date="+SharedPreference.loadFilterToDate(getActivity()));

        }
    }

    private void setSpinners()
    {
        filter_by_group_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {

                SharedPreference.saveFilterByGroupId(getActivity(),arg2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

        filter_by_severity_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {

                SharedPreference.saveFilterBySeverityId(getActivity(),arg2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
    }

    private void checkOfCheckBox()
    {
        if(assigned_checkBox.isChecked())
        {
            String assignedValue=assigned_checkBox.getText().toString();
            SharedPreference.saveFilterAssigned(getActivity(),assignedValue);
        }

       else if(completed_checkBox.isChecked())
        {
            String completedValue=completed_checkBox.getText().toString();
            SharedPreference.saveFilterAssigned(getActivity(),completedValue);
        }

       else if(request_checkBox.isChecked())
        {
            String requestInfoValue=request_checkBox.getText().toString();
            SharedPreference.saveFilterAssigned(getActivity(),requestInfoValue);
        }
    }
    @Override
    public void onClick(View view) {
        if (view==from_date_imageView)
        {
            ShowDatePicker(mDateChangeListener1, myCalendar1);
        }

        if (view==to_date_imageView)
        {
            ShowDatePicker(mDateChangeListener2, myCalendar2);
        }
        if (view==apply_btn)
        {

             String filterByGroupItem = filter_by_group_spinner.getSelectedItem().toString();
            if (filterByGroupItem.equalsIgnoreCase(getString(R.string.select_filter_group_By)))
            {
                SharedPreference.saveFilterByGroup(getActivity(),null);
            }
            else if (filterByGroupItem.equalsIgnoreCase(getString(R.string.me)))
             {
                 SharedPreference.saveFilterByGroup(getActivity(),"me");
             }
             else if (filterByGroupItem.equalsIgnoreCase(getString(R.string.me_and_mygroup)))
             {
                 SharedPreference.saveFilterByGroup(getActivity(),"megroup");
             }
             else if (filterByGroupItem.equalsIgnoreCase(getString(R.string.group)))
             {
                 SharedPreference.saveFilterByGroup(getActivity(),"group");
             }
             else if (filterByGroupItem.equalsIgnoreCase(getString(R.string.me_previous)))
             {
                 SharedPreference.saveFilterByGroup(getActivity(),"previous");
             }
             else if (filterByGroupItem.equalsIgnoreCase(getString(R.string.reviewer)))
             {
                 SharedPreference.saveFilterByGroup(getActivity(),"reviewer");
             }

             String filterBySeverity=filter_by_severity_spinner.getSelectedItem().toString();

             //SharedPreference.saveFilterBySeverity(getActivity(),filterBySeverity);

            checkOfCheckBox();
            if (filter_editText.getText().toString()!=null||!filter_editText.getText().toString().equalsIgnoreCase(""))
            {
                SharedPreference.saveFilterKeyWord(getActivity(),filter_editText.getText().toString());
            }

             setSpinners();
             Log.e("text","text of spinner"+filterByGroupItem);
            ((MainActivity)getActivity()).startConnection();
             this.dismiss();
        }
    }
}
