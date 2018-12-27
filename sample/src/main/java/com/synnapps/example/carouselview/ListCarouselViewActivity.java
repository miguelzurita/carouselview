package com.synnapps.example.carouselview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;
import com.synnapps.carouselview.ViewListener;

import hb.xvideoplayer.MxVideoPlayer;
import hb.xvideoplayer.MxVideoPlayerWidget;

public class ListCarouselViewActivity extends AppCompatActivity {

    CarouselView customCarouselView;
    CarouselView customCarouselView2;
    CarouselView customCarouselView3;

    int[] sampleImages = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4, R.drawable.image_5};
    String[] sampleTitles = {"Orange", "Grapes", "Strawberry", "Cherry", "Apricot"};
    String[] sampleNetworkImageURLs = {
            "https://placeholdit.imgix.net/~text?txtsize=15&txt=image1&txt=350%C3%97150&w=350&h=150",
            "https://placeholdit.imgix.net/~text?txtsize=15&txt=image2&txt=350%C3%97150&w=350&h=150",
            "https://placeholdit.imgix.net/~text?txtsize=15&txt=image3&txt=350%C3%97150&w=350&h=150"
//            "https://placeholdit.imgix.net/~text?txtsize=15&txt=image4&txt=350%C3%97150&w=350&h=150",
//            "https://placeholdit.imgix.net/~text?txtsize=15&txt=image5&txt=350%C3%97150&w=350&h=150"
    };

    String[] sampleNetworkImageURLs2 = {
            "http://techslides.com/demos/sample-videos/small.mp4",
            "https://placeholdit.imgix.net/~text?txtsize=15&txt=image1&txt=350%C3%97150&w=350&h=150",
            "http://techslides.com/demos/sample-videos/small.mp4"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_carousel_view);

        customCarouselView = findViewById(R.id.customCarouselView);

        customCarouselView.setPageCount(sampleNetworkImageURLs.length);
        customCarouselView.setViewListener(viewListener);
        customCarouselView.stopCarousel();

        customCarouselView2 = findViewById(R.id.customCarouselView2);
        customCarouselView2.setPageCount(sampleNetworkImageURLs.length);
        customCarouselView2.setViewListener(viewListener);
        customCarouselView2.stopCarousel();

        customCarouselView3 = findViewById(R.id.customCarouselView3);
        customCarouselView3.setPageCount(sampleNetworkImageURLs.length);
        customCarouselView3.setViewListener(viewListener);
        customCarouselView3.stopCarousel();

    }

    // To set custom views
    ViewListener viewListener = new ViewListener() {
        @Override
        public View setViewForPosition(int position) {
            View customView = getLayoutInflater().inflate(R.layout.view_custom, null);

            TextView labelTextView = customView.findViewById(R.id.labelTextView);
            ImageView fruitImageView = customView.findViewById(R.id.fruitImageView);
            MxVideoPlayer listVideoPlayer = (MxVideoPlayerWidget) customView.findViewById(R.id.list_video_player);

            listVideoPlayer.setVisibility(View.GONE);
            fruitImageView.setVisibility(View.GONE);

            if (position == 1) {
                Picasso.with(getApplicationContext())
                        .load(sampleNetworkImageURLs[position])
                        .placeholder(sampleImages[0])
                        .error(sampleImages[3])
                        .fit()
                        .centerCrop()
                        .into(fruitImageView);
                fruitImageView.setVisibility(View.VISIBLE);
            } else {
                listVideoPlayer.startPlay(sampleNetworkImageURLs2[position], MxVideoPlayer.SCREEN_LAYOUT_LIST, "");
                listVideoPlayer.setVisibility(View.VISIBLE);
            }

            labelTextView.setText(sampleTitles[position]);

            return customView;
        }
    };

    // To set custom views
    /*ViewListener viewListener2 = new ViewListener() {
        @Override
        public View setViewForPosition(int position) {
            View customView = getLayoutInflater().inflate(R.layout.view_custom, null);

            TextView labelTextView = customView.findViewById(R.id.labelTextView);
            ImageView fruitImageView = customView.findViewById(R.id.fruitImageView);

            MxVideoPlayer listVideoPlayer = (MxVideoPlayerWidget) customView.findViewById(R.id.list_video_player);
            listVideoPlayer.startPlay(sampleNetworkImageURLs2[position], MxVideoPlayer.SCREEN_LAYOUT_LIST, "");

            Picasso.with(getApplicationContext())
                    .load(sampleNetworkImageURLs[position])
                    .placeholder(sampleImages[0])
                    .error(sampleImages[3])
                    .fit()
                    .centerCrop()
                    .into(fruitImageView);

            labelTextView.setText(sampleTitles[position]);

            return customView;
        }
    };*/
}
