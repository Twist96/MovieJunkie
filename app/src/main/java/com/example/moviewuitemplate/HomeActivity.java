package com.example.moviewuitemplate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.moviewuitemplate.adapters.MovieRecyclerAdapter;
import com.example.moviewuitemplate.adapters.SlidePagerAdapter;
import com.example.moviewuitemplate.interfaces.IMovieItemClickListener;
import com.example.moviewuitemplate.models.Movie;
import com.example.moviewuitemplate.models.Slide;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity implements IMovieItemClickListener {

    private List<Slide> slideList;
    private ViewPager slidePager;
    private RecyclerView popMoviesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        slidePager = findViewById(R.id.slider_pager);
        TabLayout indicator = findViewById(R.id.indicator);
        popMoviesRecyclerView = findViewById(R.id.Rv_movies);

        slideList = new ArrayList<>();
        slideList.add(new Slide(R.drawable.slide_1, "SlideText \nmore text here"));
        slideList.add(new Slide(R.drawable.slide_2, "Slide Text \nmore text here"));
        slideList.add(new Slide(R.drawable.slide_1, "SlideText \nmore text here"));
        slideList.add(new Slide(R.drawable.slide_2, "Slide Text \nmore text here"));
        slideList.add(new Slide(R.drawable.slide_1, "SlideText \nmore text here"));
        slideList.add(new Slide(R.drawable.slide_2, "Slide Text \nmore text here"));

        SlidePagerAdapter slidePagerAdapter = new SlidePagerAdapter(this, slideList);
        slidePager.setAdapter(slidePagerAdapter);

        //setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new HomeActivity.SlideTime(), 4000, 6000);
        indicator.setupWithViewPager(slidePager, true);

        //popular movies
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Hobs and Shaw", R.drawable.slide_1, R.drawable.alita));
        movies.add(new Movie("Avengers: End game",  R.drawable.slide_1, R.drawable.little));
        movies.add(new Movie("It", R.drawable.slide_1, R.drawable.alita));
        movies.add(new Movie("Joker",  R.drawable.slide_1, R.drawable.little));
        movies.add(new Movie("Men in black", R.drawable.slide_1, R.drawable.alita));
        movies.add(new Movie("Chief Daddy",  R.drawable.slide_1, R.drawable.little));
        MovieRecyclerAdapter moviesAdapter = new MovieRecyclerAdapter(this, movies, this);
        popMoviesRecyclerView.setAdapter(moviesAdapter);
        popMoviesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }

    @Override
    public void onMovieClick(Movie movie, ImageView moviePosterImageView) {
        // here we move information to details activity
        // transition animation will also be done here

        Intent intent = new Intent(this, MovieDetailActivity.class);
        intent.putExtra("movie", movie);

        //animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, moviePosterImageView, "posterAnimation");
        startActivity(intent, options.toBundle());

    }

    class SlideTime extends TimerTask{

        @Override
        public void run() {
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (slidePager.getCurrentItem() < slideList.size()-1){
                        slidePager.setCurrentItem(slidePager.getCurrentItem()+1);
                    }else {
                        slidePager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
