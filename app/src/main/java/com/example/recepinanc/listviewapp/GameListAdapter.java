package com.example.recepinanc.listviewapp;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Recepinanc on 28.08.2015.
 */
public class GameListAdapter extends BaseAdapter {

    ArrayList<Integer> icons;
    ArrayList<Game> games;
    Game game;
    Context context;

    public ImageView icon;
    public TextView title;

    GameListAdapter(Context c) {

        context = c;
        games = new ArrayList<Game>();

        //Icons
        icons = new ArrayList<>();
        icons.add(R.drawable.aeo3);
        icons.add(R.drawable.blur);
        icons.add(R.drawable.cod);
        icons.add(R.drawable.csgo);
        icons.add(R.drawable.farcry4);
        icons.add(R.drawable.l4d2);
        icons.add(R.drawable.minecraft);
        icons.add(R.drawable.nfs);
        icons.add(R.drawable.okey);
        icons.add(R.drawable.payday2);
        icons.add(R.drawable.pes2013);
        icons.add(R.drawable.tavla);
        icons.add(R.drawable.ut2004);

        Resources res = c.getResources();
        String[] titles = res.getStringArray(R.array.GameNames);

        //Creation of the game list elements
        for (int i = 1; i < icons.size(); i++) {
            Game game = new Game(titles[i], icons.get(i));
            games.add(game);
        }

    }

    @Override
    public int getCount() {
        return games.size();
    }

    @Override
    public Object getItem(int position) {
        return games.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        View v;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.single_row_layout,viewGroup,false);

        icon = (ImageView) v.findViewById(R.id.gameIcon_imageView);
        title = (TextView) v.findViewById(R.id.game_title_textView);

        Game temp = games.get(position);

        icon.setImageResource(temp.gameIcon);
        title.setText(temp.gameTitle);


        return v;
    }
}
