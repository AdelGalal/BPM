package psystems.co.bpm.ui.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import psystems.co.bpm.BPMApplication;
import psystems.co.bpm.R;

import psystems.co.bpm.api.model.response.TaskElement;
//import psystems.co.bpm.injection.zip.DaggerTaskComponent;
import psystems.co.bpm.injection.zip.DaggerTaskComponent;
import psystems.co.bpm.injection.zip.TaskComponent;
import psystems.co.bpm.injection.zip.TasksModule;
import psystems.co.bpm.presenters.tasks.TaskPresenter;
import psystems.co.bpm.ui.adapter.SimpleDividerItemDecoration;
import psystems.co.bpm.ui.adapter.SpacesItemDecoration;
import psystems.co.bpm.ui.adapter.TasksAdapter;
import psystems.co.bpm.ui.views.TasksView;

public class MainActivity extends AppCompatActivity implements TasksView {
    private TextView userName;
    private String user;
    private String token;

    @Inject
    TaskPresenter presenter;

    private ProgressDialog progressDialog;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInjection();
        userName=(TextView)findViewById(R.id.tv_user);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(2);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        user = getIntent().getStringExtra("userName");
        token = getIntent().getStringExtra("token");
        userName.setText(user+"'s Tasks");

        presenter.makeSearch(token,"TASKID","TITLE","TASKNUMBER","STARTDATE",
                "STATE","textAttribute1",
                "Comments","ALL_ACTIONS","My+Group");
    }

    private void initInjection() {

        TaskComponent taskComponent = DaggerTaskComponent.builder()
                .applicationComponent(((BPMApplication) getApplication()).getComponent())
                .tasksModule(new TasksModule(this))
                .build();

        taskComponent.inject(this);

    }


    @Override
    public void isSucess(ArrayList<TaskElement> taskElementArrayList) {
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
}
