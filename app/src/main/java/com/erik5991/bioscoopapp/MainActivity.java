package com.erik5991.bioscoopapp;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private ArrayList<Locatie> locaties = new ArrayList<>();
    private ArrayList<String> menuLijst = new ArrayList<>();
    private DrawerLayout mDrawerLayout;
    private ListView locatieListView, menuLinksListView;
    private BaseAdapter locatieAdapter, linksMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Locatie l1 = new Locatie("Tilburg");
        locaties.add(l1);

        String menu = "MENU";
        menuLijst.add(menu);

        menuLinksListView = (ListView) findViewById(R.id.left_drawer);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        locatieListView = (ListView) findViewById(R.id.right_drawer);
        // Set the adapter for the list view
        locatieAdapter = new LocatieAdapter(this, getLayoutInflater(), locaties);
        linksMenuAdapter = new MenuAdapter(this, getLayoutInflater(), menuLijst);
        locatieListView.setAdapter(locatieAdapter);
        menuLinksListView.setAdapter(linksMenuAdapter);
        locatieAdapter.notifyDataSetChanged();
        linksMenuAdapter.notifyDataSetChanged();
        // Set the list's click listener
        locatieListView.setOnItemClickListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        //Krijg positie van Item waarop je hebt geklikt. Intent start nieuwe Activity op.
        Locatie locatie = locaties.get(position);
        Intent intent = new Intent(getApplicationContext(), Login.class);
       // intent.putExtra(EXTRA_PRODUCT, p);
        startActivity(intent);
    }



    }

