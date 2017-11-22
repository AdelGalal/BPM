package psystems.co.bpm.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import psystems.co.bpm.R;
import psystems.co.bpm.api.model.response.TaskElement;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.MyViewHolder> {

    private ArrayList<TaskElement> taskElementArrayList;
    private Context mContext;
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

        }
    }


    public TasksAdapter(ArrayList<TaskElement> taskElementArrayList,Context mContext) {
        this.taskElementArrayList = taskElementArrayList;
        this.mContext=mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tasks_layout, parent, false);
         height = parent.getMeasuredHeight() / 5;
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TaskElement taskElement = taskElementArrayList.get(position);
        holder.titleOfTask.setText(taskElement.getTitle());
        holder.requestNumber.setText("REQUEST NO. "+taskElement.getTaskProcessInfoResponse().getInstanceId());
        holder.employeeName.setText(taskElement.getCreator());
        String assignedDate = taskElement.getTaskSystemAttributes().getAssignedDate();
        StringTokenizer st = new StringTokenizer(assignedDate, "T+");
        String date = st.nextToken();
        String time = st.nextToken();
        StringTokenizer hoursAndMinutesOnly = new StringTokenizer(time, ":");
        String hour = hoursAndMinutesOnly.nextToken();
        String minutes = hoursAndMinutesOnly.nextToken();
        holder.assignedDate.setText(date+" "+hour+":"+minutes);
        holder.priority_layout.setMinimumHeight(height);
        if (getCountOfDays(date)!=0)
        {
            holder.numberOfDays.setText(getCountOfDays(date)+"d");
        }

        if (taskElement.getPriority().equals("1"))
        {
            holder.priority_layout.setBackgroundColor(mContext.getResources().getColor(R.color.red));
        }
        else if (taskElement.getPriority().equals("3"))
        {
            holder.priority_layout.setBackgroundColor(mContext.getResources().getColor(R.color.blue));
        }
        else if (taskElement.getPriority().equals("5"))
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

}