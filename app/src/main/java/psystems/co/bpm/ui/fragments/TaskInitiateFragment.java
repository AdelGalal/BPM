package psystems.co.bpm.ui.fragments;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import psystems.co.bpm.BPMApplication;
import psystems.co.bpm.R;
import psystems.co.bpm.api.model.response.TaskInitiate;
import psystems.co.bpm.api.model.response.TaskInitiatiable;
import psystems.co.bpm.injection.zip.DaggerTaskInitiateComponent;
import psystems.co.bpm.injection.zip.TaskInitiateComponent;
import psystems.co.bpm.injection.zip.TaskInitiateModule;
import psystems.co.bpm.presenters.tasks.TaskInitiatePresenter;
import psystems.co.bpm.ui.adapter.SimpleDividerItemDecoration;
import psystems.co.bpm.ui.adapter.SpacesItemDecoration;
import psystems.co.bpm.ui.adapter.TaskInitiateAdapter;
import psystems.co.bpm.ui.adapter.TasksAdapter;
import psystems.co.bpm.ui.views.TaskInitiateView;
import psystems.co.bpm.util.SharedPreference;

/**
 * Created by ADEL on 12/6/2017.
 */

@SuppressLint("ValidFragment")
public class TaskInitiateFragment  extends DialogFragment implements View.OnClickListener,TaskInitiateView {
    private View rootView;
    private RecyclerView recyclerView;
    //private String token;

    @Inject
    TaskInitiatePresenter presenter;

    private ProgressBar progressbar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            rootView = inflater.inflate(R.layout.task_initiate, container, false);
           // getDialog().setTitle(getString(R.string.filter_title));
           initInjection();
           initViews();
        }
        return rootView;
    }

    private void initInjection() {

        TaskInitiateComponent taskInitiateComponent = DaggerTaskInitiateComponent.builder()
                .applicationComponent(((BPMApplication) getActivity().getApplication()).getComponent())
                .taskInitiateModule(new TaskInitiateModule(this))
                .build();

        taskInitiateComponent.inject(this);

    }
    private void initViews()
    {

        recyclerView=(RecyclerView)rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(2);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
        progressbar=(ProgressBar)rootView.findViewById(R.id.progressbar);
        presenter.startToGetTasksInitiate(SharedPreference.loadToken(getActivity()));
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void isSucess(TaskInitiatiable taskInitiatiable) {
        recyclerView.setAdapter(new TaskInitiateAdapter(taskInitiatiable.getTaskInitiateArrayList(),getActivity()));
        SharedPreference.saveToken(getActivity(),taskInitiatiable.getToken());
        Log.e("new","new token in fragment="+taskInitiatiable.getToken());
    }

    @Override
    public void showWaitingDialog() {
        progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideWaitingDialog() {
            progressbar.setVisibility(View.GONE);
    }

    @Override
    public void showErrorInRequest() {
        Toast.makeText(getActivity(), R.string.error_connection, Toast.LENGTH_SHORT).show();
    }
}
