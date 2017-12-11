package psystems.co.bpm.ui.fragments;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

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
    private int filterByGroupId;
    private int filterBySeverityId;

    public static FilterDailogFragment newInstance() {
        return new FilterDailogFragment();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
           rootView = inflater.inflate(R.layout.filter_dailog, container, false);
           // getDialog().setTitle(getString(R.string.filter_title));
            initViews();
        }
        return rootView;
    }

    private void initViews() {
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

        if (SharedPreference.loadFilterBySeverityId(getActivity())!=0)
        {
            filter_by_severity_spinner.setSelection(SharedPreference.loadFilterBySeverityId(getActivity()));
        }

        from_date_edit=(EditText)rootView.findViewById(R.id.from_date_edit);
        from_date_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
              if (from_date_edit.getText().toString().matches(""))
              {
                  SharedPreference.saveFromDate(getActivity(),null);
              }
              else
              {
                  SharedPreference.saveFromDate(getActivity(),from_date_edit.getText().toString());
              }
            }
        });
        if (SharedPreference.loadFilterFromDate(getActivity())!=null)
        {
            from_date_edit.setText(""+SharedPreference.loadFilterFromDate(getActivity()));
        }
        from_date_imageView=(ImageView)rootView.findViewById(R.id.from_date_imageView);
        from_date_imageView.setOnClickListener(this);
        to_date_edit=(EditText)rootView.findViewById(R.id.to_date_edit);
        to_date_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (to_date_edit.getText().toString().matches(""))
                {
                    SharedPreference.saveToDate(getActivity(),null);
                }
                else
                {
                    SharedPreference.saveToDate(getActivity(),to_date_edit.getText().toString());
                }
            }
        });
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

        if (SharedPreference.loadFilterState(getActivity())!=null&&SharedPreference.loadFilterState(getActivity()).equalsIgnoreCase("assigned"))
        {
            assigned_checkBox.setChecked(true);
        }
        completed_checkBox=(CheckBox)rootView.findViewById(R.id.completed_checkBox);
        if (SharedPreference.loadFilterState(getActivity())!=null&&SharedPreference.loadFilterState(getActivity()).equalsIgnoreCase("completed"))
        {
            completed_checkBox.setChecked(true);
        }
        request_checkBox=(CheckBox)rootView.findViewById(R.id.request_checkBox);
        if (SharedPreference.loadFilterState(getActivity())!=null&&SharedPreference.loadFilterState(getActivity()).equalsIgnoreCase("info"))
        {
            request_checkBox.setChecked(true);
        }
        if (SharedPreference.loadFilterState(getActivity())!=null&&SharedPreference.loadFilterState(getActivity()).equalsIgnoreCase("assigned,completed"))
        {
            assigned_checkBox.setChecked(true);
            completed_checkBox.setChecked(true);
        }
        if (SharedPreference.loadFilterState(getActivity())!=null&&SharedPreference.loadFilterState(getActivity()).equalsIgnoreCase("assigned,info"))
        {
            assigned_checkBox.setChecked(true);
            request_checkBox.setChecked(true);
        }
        if (SharedPreference.loadFilterState(getActivity())!=null&&SharedPreference.loadFilterState(getActivity()).equalsIgnoreCase("completed,info"))
        {
            request_checkBox.setChecked(true);
            completed_checkBox.setChecked(true);
        }
        else if (SharedPreference.loadFilterState(getActivity())!=null&&SharedPreference.loadFilterState(getActivity()).equalsIgnoreCase("assigned,completed,info"))
        {
            assigned_checkBox.setChecked(true);
            completed_checkBox.setChecked(true);
            request_checkBox.setChecked(true);
        }
        setSpinners();
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
        }

        else if (myCalendar==myCalendar2)
        {
            SharedPreference.saveToDate(getActivity(),sdf.format(myCalendar.getTime()));
        }
    }

    private void setSpinners()
    {
        filter_by_group_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                filterByGroupId=arg2;
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
                filterBySeverityId=arg2;
                SharedPreference.saveFilterBySeverityId(getActivity(),filterBySeverityId);
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
            SharedPreference.saveFilterState(getActivity(),"assigned");
            Log.e("CheckBox","1111111111");
        }

//        else
//        {
//            SharedPreference.saveFilterState(getActivity(),null);
//        }

        if(completed_checkBox.isChecked())
        {
           // String completedValue=completed_checkBox.getText().toString();
            SharedPreference.saveFilterState(getActivity(),"completed");
            Log.e("CheckBox","222222222222");
        }
//        else {
//            SharedPreference.saveFilterState(getActivity(),null);
//        }

        if(request_checkBox.isChecked())
        {
            //String requestInfoValue=request_checkBox.getText().toString();
            SharedPreference.saveFilterState(getActivity(),"info");
            Log.e("CheckBox","333333333333333");
        }
        if(assigned_checkBox.isChecked()&&completed_checkBox.isChecked())
        {
            SharedPreference.saveFilterState(getActivity(),"assigned,completed");
            Log.e("CheckBox","444444444444");
        }

        if(assigned_checkBox.isChecked()&&request_checkBox.isChecked())
        {
            SharedPreference.saveFilterState(getActivity(),"assigned,info");
            Log.e("CheckBox","555555555555");
        }

        if(completed_checkBox.isChecked()&&request_checkBox.isChecked())
        {
            SharedPreference.saveFilterState(getActivity(),"completed,info");
            Log.e("CheckBox","666666666666666");
        }
//        else
//        {
//            SharedPreference.saveFilterState(getActivity(),null);
//        }



        if (assigned_checkBox.isChecked()&&completed_checkBox.isChecked()&&request_checkBox.isChecked())
        {
            SharedPreference.saveFilterState(getActivity(),"assigned,completed,info");
            Log.e("CheckBox","77777777777");
        }
        if (!assigned_checkBox.isChecked()&&!completed_checkBox.isChecked()&&!request_checkBox.isChecked())
        {
            SharedPreference.saveFilterState(getActivity(),null);
            Log.e("CheckBox","00000000000");
        }

    }

    private void filterByGroup()
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

    }
    private void filterBySeverity()
    {
        String filterBySeverity=filter_by_severity_spinner.getSelectedItem().toString();
        if (filterBySeverity.equalsIgnoreCase(getString(R.string.select_filter_by_severity)))
        {
            SharedPreference.saveFilterBySeverity(getActivity(),null);
        }
        if (filterBySeverity.equalsIgnoreCase(getString(R.string.any_severity)))
        {
            SharedPreference.saveFilterBySeverity(getActivity(),"AnySeverity");
        }
        if (filterBySeverity.equalsIgnoreCase(getString(R.string.very_important)))
        {
            SharedPreference.saveFilterBySeverity(getActivity(),"VeryImportant");
        }
        if (filterBySeverity.equalsIgnoreCase(getString(R.string.important)))
        {
            SharedPreference.saveFilterBySeverity(getActivity(),"Important");
        }
        if (filterBySeverity.equalsIgnoreCase(getString(R.string.normal)))
        {
            SharedPreference.saveFilterBySeverity(getActivity(),"Normal");
        }
        if (filterBySeverity.equalsIgnoreCase(getString(R.string.low)))
        {
            SharedPreference.saveFilterBySeverity(getActivity(),"Low");
        }
        if (filterBySeverity.equalsIgnoreCase(getString(R.string.very_low)))
        {
            SharedPreference.saveFilterBySeverity(getActivity(),"VeryLow");
        }
    }

    private void filterKeyword()
    {
        String text=filter_editText.getText().toString();
        if (text.matches(""))
        {
            SharedPreference.saveFilterKeyWord(getActivity(),null);
        }
        else
        {
            SharedPreference.saveFilterKeyWord(getActivity(),filter_editText.getText().toString());
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

            filterByGroup();
            filterBySeverity();
            checkOfCheckBox();
            filterKeyword();

            SharedPreference.saveFilterByGroupId(getActivity(),filterByGroupId);
            SharedPreference.saveFilterBySeverityId(getActivity(),filterBySeverityId);

            ((MainActivity)getActivity()).startConnection();
             this.dismiss();
        }
    }
}
