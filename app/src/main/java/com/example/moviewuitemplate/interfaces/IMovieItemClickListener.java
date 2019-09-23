package com.example.moviewuitemplate.interfaces;

import android.widget.ImageView;

import com.example.moviewuitemplate.models.Movie;

public interface IMovieItemClickListener {
    void onMovieClick(Movie movie, ImageView moviePosterImageView); // the image view is used for animation during transition to the next activity
}
