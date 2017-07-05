package com.example.lehiteixeira.appedu.MainHome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lehiteixeira.appedu.Model.City;
import com.example.lehiteixeira.appedu.Quiz.Quiz;
import com.example.lehiteixeira.appedu.R;

import java.util.ArrayList;


public class ListCardMainAdapter extends RecyclerView.Adapter<ListCardMainAdapter.MyViewHolder>  {

    private ArrayList<City> list_item_city;

    public Context mcontext;
    public  Activity mactivity;

    public ListCardMainAdapter(ArrayList<City> cities, Context context, Activity activity) {
        list_item_city = cities;
        mcontext = context;
        mactivity = activity;
    }

    // Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
    @Override
    public ListCardMainAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        // create a layout
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.main_list_item, null);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    // Called by RecyclerView to display the data at the specified position.
    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, final int position ) {

        viewHolder.cidade.setText(list_item_city.get(position).getTitle().toString());


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext, Quiz.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(mactivity, viewHolder.img ,"imgQuiz");
                mcontext.startActivity(intent,options.toBundle());
            }
        });
    }

    // initializes some private fields to be used by RecyclerView.
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView cidade;
        public TextView estado;
        public ImageView img;

        public MyViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            cidade = (TextView) itemLayoutView.findViewById(R.id.title);
            img = (ImageView) itemLayoutView.findViewById(R.id.image);

        }
    }

    //Returns the total number of items in the data set hold by the adapter.
    @Override
    public int getItemCount() {
        return list_item_city.size();
    }

}