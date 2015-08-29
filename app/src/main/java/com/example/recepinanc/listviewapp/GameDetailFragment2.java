package com.example.recepinanc.listviewapp;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class GameDetailFragment2 extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextView gameTitle;
    ImageView gameIcon;

    private String data;
    private int icon;

    public static GameDetailFragment2 newInstance(String data, int icon) {
        GameDetailFragment2 fragment = new GameDetailFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, data);
        args.putInt(ARG_PARAM2, icon);
        fragment.setArguments(args);
        return fragment;
    }

    public GameDetailFragment2() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO: Arguman olarak verdiğin değerler burda alınır.
        if (getArguments() != null) {
            data = getArguments().getString(ARG_PARAM1);
            icon = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.game_detail_fragment_layout, container, false);

        gameIcon = (ImageView) v.findViewById(R.id.detailed_icon_imageView);
        gameTitle = (TextView) v.findViewById(R.id.detailed_title_textView);


        gameIcon.setImageResource(icon);
        gameTitle.setText(data);
        return v;
    }


}
