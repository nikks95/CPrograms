package com.prognoobie.nikhil.getc;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
  private boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "nkhil gola and tushar saxena", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_introduction) {
            // Handle the camera action

            Fragment fragment= new Introduction_fragment();
            android.support.v4.app.FragmentManager ft = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fT = ft.beginTransaction();
            fT.replace(R.id.fragment_container,fragment).commit();

        } else if (id == R.id.nav_operators) {

            Fragment fragment= new Operator_Fragment();
            android.support.v4.app.FragmentManager ft = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fT = ft.beginTransaction();
            //fT.add(R.id.fragment_container,fragment).commit();
            fT.replace(R.id.fragment_container,fragment).commit();

        } else if (id == R.id.nav_program1) {

            this.getProgram(0);

        } else if (id == R.id.nav_program2) {

            this.getProgram(1);

        } else if (id == R.id.nav_program3) {


        } else if (id == R.id.nav_program4) {


        }
        else if(id == R.id.program)
        {
            if(!flag)
            {

            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void getProgram(int id)
    {
        ProgramWriter.setProgID(id);
        Fragment fragment= new ProgramFragment();
        android.support.v4.app.FragmentManager ft = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fT = ft.beginTransaction();
        //fT.add(R.id.fragment_container,fragment).commit();
        fT.replace(R.id.fragment_container,fragment).commit();
    }
}
