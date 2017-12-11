package psystems.co.bpm.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import psystems.co.bpm.R;
import psystems.co.bpm.api.model.response.TaskInitiate;
import psystems.co.bpm.api.model.response.TasksEntityResponse;
import psystems.co.bpm.ui.activities.MainActivity;
import psystems.co.bpm.ui.activities.TaskInitiatiableActivity;

/**
 * Created by ADEL on 12/6/2017.
 */

public class TaskInitiateAdapter extends RecyclerView.Adapter<TaskInitiateAdapter.MyViewHolder>  {

    private ArrayList<TaskInitiate> taskInitiates;
    private Context mContext;
    MyViewHolder viewHolder;
   // private String token;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView titleOfTask;
        private RelativeLayout main_layout;


        public MyViewHolder(View view) {
            super(view);
            titleOfTask = (TextView) view.findViewById(R.id.task_title_tv);
            main_layout=(RelativeLayout)view.findViewById(R.id.main_layout);
        }
    }


    public TaskInitiateAdapter(ArrayList<TaskInitiate> taskInitiates, Context mContext) {
        this.taskInitiates = taskInitiates;
        this.mContext=mContext;
        //this.token=token;
    }

    @Override
    public TaskInitiateAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tasks_initiate_items, parent, false);

        viewHolder = new TaskInitiateAdapter.MyViewHolder(itemView);
        return new TaskInitiateAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TaskInitiateAdapter.MyViewHolder holder, int position) {
        final TaskInitiate taskElement = taskInitiates.get(position);
        holder.titleOfTask.setText(taskElement.getApplicationLinkDisplayName().trim());
        holder.main_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, TaskInitiatiableActivity.class);
               // intent.putExtra("token",token);
                intent.putExtra("initcompositeDN",taskElement.getInitcompositeDN());
                ((Activity) mContext).startActivityForResult(intent, MainActivity.REQUEST_CODE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return taskInitiates.size();
    }

}
