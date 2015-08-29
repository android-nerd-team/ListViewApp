package com.example.recepinanc.listviewapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements GameListFragment.Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GameListFragment gameListFragment = new GameListFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.container, gameListFragment);
        transaction.commit();


    }


    @Override
    public void passGameData(String data1, int data) {
        FragmentManager fm = getFragmentManager();
        GameDetailFragment gameDetailFragment = new GameDetailFragment();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.container, gameDetailFragment);
        transaction.commit();
        gameDetailFragment.setGame(data1, data);
    }
}
