package psystems.co.bpm.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

import psystems.co.bpm.R;
import psystems.co.bpm.api.model.response.TaskElement;
import psystems.co.bpm.api.model.response.TasksEntityResponse;
import psystems.co.bpm.ui.activities.MainActivity;
import psystems.co.bpm.ui.activities.TaskDetailsActivity;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.MyViewHolder> {

    private ArrayList<TasksEntityResponse> taskElementArrayList;
    private Context mContext;
    MyViewHolder viewHolder;
    private String userName;
    int height;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView titleOfTask, requestNumber,employeeName,assignedDate,numberOfDays;
        private RelativeLayout parent_layout;
        private LinearLayout priority_layout;

        public MyViewHolder(View view) {
            super(view);
            titleOfTask = (TextView) view.findViewById(R.id.title_textView);
            requestNumber=(TextView)view.findViewById(R.id.request_number_textView);
            employeeName=(TextView)view.findViewById(R.id.employee_textView);
            assignedDate=(TextView)view.findViewById(R.id.assignedDate_textView);
            numberOfDays=(TextView)view.findViewById(R.id.number_of_days_textView);
            parent_layout=(RelativeLayout)view.findViewById(R.id.parent_layout);
            priority_layout=(LinearLayout)view.findViewById(R.id.priority_layout);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, TaskDetailsActivity.class);
                    intent.putExtra("taskID", taskElementArrayList.get(getLayoutPosition()).getTaskId());
                 //   intent.putExtra("token",token);
                    intent.putExtra("userName",userName);
                    ((Activity) mContext).startActivityForResult(intent, MainActivity.REQUEST_CODE);
             }
            });
        }
    }


    public TasksAdapter(ArrayList<TasksEntityResponse> taskElementArrayList, Context mContext, String userName) {
        this.taskElementArrayList = taskElementArrayList;
        this.mContext=mContext;
       // this.token=token;
        this.userName=userName;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tasks_layout, parent, false);
         height = parent.getMeasuredHeight() / 5;
        viewHolder = new MyViewHolder(itemView);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TasksEntityResponse taskElement = taskElementArrayList.get(position);
        holder.titleOfTask.setText(taskElement.getTitle());
        holder.requestNumber.setText("REQUEST NO. "+taskElement.getInstanceId());
        holder.employeeName.setText(taskElement.getCreator());
        long assignedDate = Long.parseLong(taskElement.getAssignedDate());

//        StringTokenizer st = new StringTokenizer(assignedDate, "T+");
//        String date = st.nextToken();
//        String time = st.nextToken();
//        StringTokenizer hoursAndMinutesOnly = new StringTokenizer(time, ":");
//        String hour = hoursAndMinutesOnly.nextToken();
//        String minutes = hoursAndMinutesOnly.nextToken();
        holder.assignedDate.setText(getDate(assignedDate));//+" "+hour+":"+minutes);
        holder.priority_layout.setMinimumHeight(height);
//        if (getCountOfDays(date)!=0)
//        {
//            holder.numberOfDays.setText(getCountOfDays(date)+"d");
//        }

        if (taskElement.getPriority()==1)
        {
            holder.priority_layout.setBackgroundColor(mContext.getResources().getColor(R.color.red));
        }
        else if (taskElement.getPriority()==3)
        {
            holder.priority_layout.setBackgroundColor(mContext.getResources().getColor(R.color.blue));
        }
        else if (taskElement.getPriority()==5)
        {
            holder.priority_layout.setBackgroundColor(mContext.getResources().getColor(R.color.green));
        }
        if (position%2==0)
        {
            holder.parent_layout.setBackgroundColor(Color.WHITE);

        }
        else
        {
            holder.parent_layout.setBackgroundColor(mContext.getResources().getColor(R.color.gray_dimmed));
        }


    }

    @Override
    public int getItemCount() {
        return taskElementArrayList.size();
    }


    private int getCountOfDays(String date)
    {
        Date userDob = null;
        try {
            userDob = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date today = new Date();
        long diff =  today.getTime() - userDob.getTime();
        int numOfYear = (int) ((diff / (1000 * 60 * 60 * 24))/365);
        int numOfDays = (int) (diff / (1000 * 60 * 60 * 24));
        int hours = (int) (diff / (1000 * 60 * 60));
        int noOfMinutes = (int) (diff / (1000 * 60));
        int seconds = (int) (diff / (1000));
        return numOfDays;
    }
    private String getDate(long time) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(time);
        String date = DateFormat.format("dd-MM-yyyy HH:mm", cal).toString();
        return date;
    }
}