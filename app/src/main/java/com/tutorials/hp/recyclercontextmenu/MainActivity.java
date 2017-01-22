package com.tutorials.hp.recyclercontextmenu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        rv= (RecyclerView) findViewById(R.id.mRecycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());

        adapter=new MyAdapter(this,getMovies());
        rv.setAdapter(adapter);


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        adapter.getItenSelected(item);

        return super.onContextItemSelected(item);
    }

    private ArrayList<Movie> getMovies() {
        //COLECTION OF  MOVIES
        ArrayList<Movie> movies=new ArrayList<>();

        Movie movie=new Movie("Shuttle Carrier",R.drawable.shuttlecarrier);

        //ADD ITR TO COLLECTION
        movies.add(movie);

        movie=new Movie("Fruits",R.drawable.fruits);
        movies.add(movie);

        movie=new Movie("Breaking Bad",R.drawable.breaking);
        movies.add(movie);

        movie=new Movie("Crisis",R.drawable.crisis);
        movies.add(movie);

        movie=new Movie("Ghost Rider",R.drawable.rider);
        movies.add(movie);

        movie=new Movie("Star Wars",R.drawable.starwars);
        movies.add(movie);

        movie=new Movie("BlackList",R.drawable.red);
        movies.add(movie);



        movie=new Movie("Men In Black",R.drawable.meninblack);
        movies.add(movie);

        movie=new Movie("Game Of Thrones",R.drawable.thrones);
        movies.add(movie);



        return movies;
    }


}
