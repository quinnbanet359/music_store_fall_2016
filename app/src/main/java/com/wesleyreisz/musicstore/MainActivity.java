package com.wesleyreisz.musicstore;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.wesleyreisz.musicstore.account.AccountFragment;
import com.wesleyreisz.musicstore.home.HomeFragment;
import com.wesleyreisz.musicstore.itune.ItuneFragment;
import com.wesleyreisz.musicstore.mysong.MySongFragment;
import com.wesleyreisz.musicstore.navigation.NavigationFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        loadFragment(new NavigationFragment());


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void loadFragment(Fragment fragment2load) {
        if(findViewById(R.id.fragmentContent)!=null){
            //show this when in in landscape
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentMain, fragment2load)
                    .replace(R.id.fragmentContent, new HomeFragment())
                    .commit();

        }else {
            //show this when in in portrait
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentMain, fragment2load)
                    .commit();
        }
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
        }else   if (id == R.id.action_home) {
            loadFragment(new NavigationFragment());
        }

        return super.onOptionsItemSelected(item);
    }
}
