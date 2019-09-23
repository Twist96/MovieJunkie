package com.example.moviewuitemplate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.moviewuitemplate.R;
import com.example.moviewuitemplate.models.Slide;

import java.util.List;

public class SlidePagerAdapter extends PagerAdapter {

    Context context;
    List<Slide> slides;

    public SlidePagerAdapter(Context context, List<Slide> slides) {
        this.context = context;
        this.slides = slides;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View slideLayout = layoutInflater.inflate(R.layout.slide_item, null);

        ImageView moviePoster = slideLayout.findViewById(R.id.slide_image);
        TextView movieTitle = slideLayout.findViewById(R.id.slide_title);
        moviePoster.setImageResource(slides.get(position).getImage());
        movieTitle.setText(slides.get(position).getTitle());

        container.addView(slideLayout);
        return slideLayout;
    }

    @Override
    public int getCount() {
        return slides.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
