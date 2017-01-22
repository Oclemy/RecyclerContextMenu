package com.tutorials.hp.recyclercontextmenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Oclemmy on 3/29/2016 for ProgrammingWizards Channel.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Movie> movies;
    private String name;

    public MyAdapter(Context c, ArrayList<Movie> movies) {
        this.c = c;
        this.movies = movies;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
        MyHolder holder=new MyHolder(v);

        return holder;
    }

    //BIND DATA TO VIEWS
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.nameTxt.setText(movies.get(position).getName());
        holder.img.setImageResource(movies.get(position).getImage());

        holder.setLongClickListener(new LongClickListener() {
            @Override
            public void onItemLongClick(int pos) {
                name=movies.get(pos).getName();
                Toast.makeText(c,name,Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void getItenSelected(MenuItem item)
    {
        Toast.makeText(c,name+" : "+item.getTitle(),Toast.LENGTH_SHORT).show();
    }
}
