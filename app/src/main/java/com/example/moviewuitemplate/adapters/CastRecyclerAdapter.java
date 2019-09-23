package com.example.moviewuitemplate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviewuitemplate.R;
import com.example.moviewuitemplate.models.Cast;

import java.util.List;
import java.util.zip.Inflater;

public class CastRecyclerAdapter extends RecyclerView.Adapter<CastRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Cast> casts;

    public CastRecyclerAdapter(Context context, List<Cast> casts) {
        this.context = context;
        this.casts = casts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cast_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(casts.get(position).getImgLink()).into(holder.castImage);
    }

    @Override
    public int getItemCount() {
        return casts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView castImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            castImage = itemView.findViewById(R.id.cast_image);
        }
    }
}
