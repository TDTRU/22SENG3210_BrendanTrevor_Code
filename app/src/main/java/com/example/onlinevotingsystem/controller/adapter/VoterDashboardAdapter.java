package com.example.onlinevotingsystem.controller.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinevotingsystem.model.Topic;
import com.example.onlinevotingsystem.R;

import java.util.ArrayList;

public class VoterDashboardAdapter extends RecyclerView.Adapter<VoterDashboardAdapter.ViewHolder> {

    // variable for storing topics
    private ArrayList<Topic> dataModalArrayList = new ArrayList<>();

    // pass in variable for storing topics into constructor
    public VoterDashboardAdapter(ArrayList<Topic> dataModalArrayList) {
        this.dataModalArrayList = dataModalArrayList;
    }

    @Override
    public VoterDashboardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        return new VoterDashboardAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_voter_dashboard, parent, false));
    }

    @Override
    public void onBindViewHolder(VoterDashboardAdapter.ViewHolder holder, int position) {
        // get the data model based on position
        Topic topic = dataModalArrayList.get(position);

        // set item views
        Button button = holder.dynamicButton;

        // button name
        button.setText(topic.getTitle());

        // storing the topic id with the button
        // to help us identify which topic's options to show if the topic is clicked
        button.setTag(topic.getTopicID());

    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return dataModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our
        // views of recycler items.
        private Button dynamicButton;

        public ViewHolder(View itemView) {
            super(itemView);
            dynamicButton = itemView.findViewById(R.id.dynamicButton);
        }
    }
}