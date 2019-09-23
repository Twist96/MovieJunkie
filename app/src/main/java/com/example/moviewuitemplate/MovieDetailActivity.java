package com.example.moviewuitemplate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviewuitemplate.adapters.CastRecyclerAdapter;
import com.example.moviewuitemplate.models.Cast;
import com.example.moviewuitemplate.models.Movie;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends AppCompatActivity {

    ImageView moviePoster, movieCover;
    TextView movieTitle, movieDescription;
    FloatingActionButton playFAB;
    RecyclerView rvCast;
    List<Cast> casts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        moviePoster = findViewById(R.id.movie_poster);
        movieTitle = findViewById(R.id.movie_title);
        movieCover = findViewById(R.id.movie_cover);
        movieDescription = findViewById(R.id.movie_desc);
        playFAB = findViewById(R.id.play_fab);
        rvCast = findViewById(R.id.Rv_cast);

        Movie movie = (Movie) getIntent().getSerializableExtra("movie");
        moviePoster.setImageResource(movie.getThumbnail());
        Glide.with(this).load(movie.getThumbnail()).into(moviePoster);
        movieCover.setImageResource(movie.getCoverPhoto());
        //Glide.with(this).load(R.drawable.slide_1).into(movieCover);
        movieTitle.setText(movie.getTitle());
        getSupportActionBar().setTitle(movie.getTitle());
        //movieDescription.setText(movie.getDescription());
        movieCover.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
        playFAB.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));

        initRvCast();

    }

    private void initRvCast(){
        casts = new ArrayList<>();
        casts.add(new Cast("Jason Statham", R.drawable.jason_statham));
        casts.add(new Cast("Jason Statham", R.drawable.jason_statham));
        casts.add(new Cast("Jason Statham", R.drawable.jason_statham));
        casts.add(new Cast("Jason Statham", R.drawable.jason_statham));
        CastRecyclerAdapter castAdapter = new CastRecyclerAdapter(this, casts);
        rvCast.setAdapter(castAdapter);
        rvCast.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

}
