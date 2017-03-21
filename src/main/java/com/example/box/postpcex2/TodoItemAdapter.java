package com.example.box.postpcex2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by box on 21/03/17.
 */

public class TodoItemAdapter extends RecyclerView.Adapter<TodoItemAdapter.MyViewHolder> {
    public TodoItemAdapter(ArrayList<String> tasks){
        this.tasks = tasks;
    }
    public TodoItemAdapter(){}
    private ArrayList<String> tasks;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView task;

        public MyViewHolder(View view) {
            super(view);
            task = (TextView) view.findViewById(R.id.description);
        }
    }
    public int getItemCount(){
        return tasks.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int type){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        String taskDescription = tasks.get(position);
        holder.task.setText(taskDescription);
    }



}
