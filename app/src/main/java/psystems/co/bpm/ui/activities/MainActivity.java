package psystems.co.bpm.ui.activities;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBar;
import java.util.ArrayList;

import javax.inject.Inject;

import psystems.co.bpm.BPMApplication;
import psystems.co.bpm.R;

import psystems.co.bpm.api.model.response.TaskElement;
//import psystems.co.bpm.injection.zip.DaggerTaskComponent;
import psystems.co.bpm.api.model.response.TasksEntityResponse;
import psystems.co.bpm.injection.zip.DaggerTaskComponent;
import psystems.co.bpm.injection.zip.TaskComponent;
import psystems.co.bpm.injection.zip.TasksModule;
import psystems.co.bpm.presenters.tasks.TaskPresenter;
import psystems.co.bpm.ui.adapter.SimpleDividerItemDecoration;
import psystems.co.bpm.ui.adapter.SpacesItemDecoration;
import psystems.co.bpm.ui.adapter.TasksAdapter;
import psystems.co.bpm.ui.views.TasksView;
import psystems.co.bpm.util.SharedPreference;

public class MainActivity extends AppCompatActivity implements TasksView,View.OnClickListener{
    private TextView userName;
    private String user;
    private String token;
    private ImageView sort_imageView;
    private  RadioGroup firstRadioGroup;
    private RadioGroup secondRadioGroup;
    private  Button okBtn;
    private String orderColumn;
    private String orderIn;
    public static final int REQUEST_CODE=100;

    @Inject
    TaskPresenter presenter;

    private ProgressDialog progressDialog;

    private RecyclerView recyclerView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        initInjection();
        userName=(TextView)findViewById(R.id.tv_user);
        sort_imageView=(ImageView)findViewById(R.id.sort_imageView);
        sort_imageView.setOnClickListener(this);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(2);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        user = getIntent().getStringExtra("userName");
        token = getIntent().getStringExtra("token");
        userName.setVisibility(View.VISIBLE);
        userName.setText(user+"");
//        presenter.startSortingSearch(token,null,null);
//        presenter.makeSearch(token,"TASKID","TITLE","TASKNUMBER","STARTDATE",
//                "STATE","textAttribute1",
//                "Comments","ALL_ACTIONS","My+Group");
//        if (SharedPreference.loadSecondRadioButtons(this)==0)
//        {
//            orderColumn="Date";
//            orderIn="ASC";
//            presenter.startSortingSearch(token,orderColumn,orderIn);
//        }
//        else

            presenter.startSortingSearch(token,SharedPreference.loadOrderColumn(this),SharedPreference.loadOrderIn(this));

    }

    private void initInjection() {

        TaskComponent taskComponent = DaggerTaskComponent.builder()
                .applicationComponent(((BPMApplication) getApplication()).getComponent())
                .tasksModule(new TasksModule(this))
                .build();

        taskComponent.inject(this);

    }

    private void showDailog()
    {
       final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.sort_dailog);
        dialog.setTitle("Sort By");
        dialog.setCancelable(true);

        firstRadioGroup = (RadioGroup)dialog.findViewById(R.id.group_one);
        secondRadioGroup=(RadioGroup)dialog.findViewById(R.id.group_two) ;
      if (SharedPreference.loadFirstRadioButtons(MainActivity.this)!=0)
      {
          RadioButton radioButton = (RadioButton) dialog.findViewById(SharedPreference.loadFirstRadioButtons(MainActivity.this));
          radioButton.setChecked(true);
      }
        if (SharedPreference.loadSecondRadioButtons(MainActivity.this)!=0)
        {
            RadioButton radioButton = (RadioButton) dialog.findViewById(SharedPreference.loadSecondRadioButtons(MainActivity.this));
            radioButton.setChecked(true);
        }
        okBtn = (Button) dialog.findViewById(R.id.ok_Btn);

        okBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int firstSelectedId = firstRadioGroup.getCheckedRadioButtonId();
                int secondSelectedId = secondRadioGroup.getCheckedRadioButtonId();

                RadioButton firstRadioButton = (RadioButton) dialog.findViewById(firstSelectedId);
                RadioButton secondRadioButton = (RadioButton) dialog.findViewById(secondSelectedId);
                SharedPreference.saveFirstRadioButtons(MainActivity.this,firstSelectedId);
                SharedPreference.saveSecondRadioButtons(MainActivity.this,secondSelectedId);

                orderColumn=firstRadioButton.getText().toString();
                 orderIn=secondRadioButton.getText().toString();
                 if (orderColumn.equalsIgnoreCase(getString(R.string.sort_by_state)))
                 {
                     orderColumn="Status";
                 }
                if (orderIn.equalsIgnoreCase(getString(R.string.sort_by_Ascending)))
                {
                  orderIn="ASC";
                }
                else
                {
                    orderIn="DESC";
                }

                dialog.dismiss();
                Log.e("orderIn","orderIn="+orderIn);
                Log.e("orderColumn","orderColumn="+orderColumn);
                SharedPreference.saveOrderColumn(MainActivity.this,orderColumn);
                SharedPreference.saveOrderIn(MainActivity.this,orderIn);
                presenter.startSortingSearch(token,orderColumn,orderIn);
            }

        });

        // now that the dialog is set up, it's time to show it
        dialog.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        MenuItem item = menu.findItem(R.id.spinner);
//        ArrayList<String> list = new ArrayList<String>();
//        list.add(getString(R.string.sort_by_date));
//        list.add(getString(R.string.sort_by_priority));
//        list.add(getString(R.string.sort_by_state));
//        list.add(getString(R.string.sort_by_Ascending));
//        list.add(getString(R.string.sort_by_Descending));
//
//        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,list);
//
//        adapter.setDropDownViewResource(R.layout.spinner_item);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
////                Toast.makeText(MainActivity.this,"test",Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK ) {

            Log.e("onActivityResult","onActivityResult");
                presenter.startSortingSearch(token,SharedPreference.loadOrderColumn(MainActivity.this),SharedPreference.loadOrderIn(MainActivity.this));

        }
    }



    @Override
    public void isSucess(ArrayList<TasksEntityResponse> taskElementArrayList) {
        recyclerView.setAdapter(new TasksAdapter(taskElementArrayList,this,token,user));
    }

    @Override
    public void showWaitingDialog() {
        if (progressDialog == null) {

            progressDialog = new ProgressDialog( this );

            progressDialog.setIndeterminate( true );

            progressDialog.setProgressStyle( ProgressDialog.STYLE_SPINNER );

           // progressDialog.setTitle( getString( R.string.dialog_title ) );

            progressDialog.setMessage( getString( R.string.dialog_message ) );

        }

        progressDialog.show();
    }

    @Override
    public void hideWaitingDialog() {
        if (progressDialog.isShowing()) {

            progressDialog.hide();

        }
    }

    @Override
    public void showErrorInRequest() {
        Toast.makeText(this, R.string.enter_user_name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        if (view==sort_imageView)
        {
            showDailog();
        }
    }
}
