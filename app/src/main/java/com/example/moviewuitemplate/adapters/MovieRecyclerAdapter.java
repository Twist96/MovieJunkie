package com.example.moviewuitemplate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviewuitemplate.R;
import com.example.moviewuitemplate.interfaces.IMovieItemClickListener;
import com.example.moviewuitemplate.models.Movie;

import java.util.List;

public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Movie> movies;
    private IMovieItemClickListener movieItemClickListener;

    public MovieRecyclerAdapter(Context context, List<Movie> movies, IMovieItemClickListener movieItemClickListener) {
        this.context = context;
        this.movies = movies;
        this.movieItemClickListener = movieItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.moviePoster.setImageResource(movies.get(position).getThumbnail());
        holder.movieTitle.setText(movies.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView moviePoster;
        TextView movieTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            moviePoster = itemView.findViewById(R.id.movie_poster);
            movieTitle = itemView.findViewById(R.id.movie_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movieItemClickListener.onMovieClick(movies.get(getAdapterPosition()), moviePoster);
                }
            });
        }
    }
}
