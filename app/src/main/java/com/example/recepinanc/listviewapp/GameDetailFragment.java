package com.example.recepinanc.listviewapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Recepinanc on 29.08.2015.
 */
public class GameDetailFragment extends Fragment {


    TextView gameTitle;
    ImageView gameIcon;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.game_detail_fragment_layout, container, false);

        gameIcon = (ImageView) v.findViewById(R.id.detailed_icon_imageView);
        gameTitle = (TextView) v.findViewById(R.id.detailed_title_textView);

        return v;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    public void setGame(String data, int icon) {
        try {
            gameTitle.setText(data);
            gameIcon.setImageResource(icon);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
