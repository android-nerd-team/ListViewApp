package com.example.recepinanc.listviewapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Recepinanc on 28.08.2015.
 */
public class GameListFragment extends Fragment {
    ListView gameList;
    ArrayList<Game> games;
    Game game;
    Communicator comm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.game_list_fragment_layout, container, false);

        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        gameList = (ListView) view.findViewById(R.id.game_list_listView);
        gameList.setAdapter(new GameListAdapter(getActivity()));

        gameList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //TODO : DEBUGGING HERE CHECK IF THE GAME IS NULL
                /**
                 * Bende crash olmuyor.
                 * Senin debug'ta ne gözüküyordu? game'in null olma ihtimali yok. comm olabilir
                 * belki, bunu benim değişikliklerimden önceki committe kontrol edebilir misin?
                 *
                 */
                Game game = (Game) parent.getAdapter().getItem(position);
                comm.passGameData(game.gameTitle, game.gameIcon);

            }
        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        /**
         * TODO:
         * Listenerları onAttach'te ekleyip onDetach'te kaldırırsan daha sağlıklı olur.
         *
         * Tavsiyem şurayı iyice oku: http://developer.android.com/guide/components/fragments.html :)
         */
        try {
            comm = (Communicator) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        comm = null;
    }

    public interface Communicator {
        public void passGameData(String data1, int data);
    }
}

