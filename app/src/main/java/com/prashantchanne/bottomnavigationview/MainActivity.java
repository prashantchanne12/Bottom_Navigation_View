package com.prashantchanne.bottomnavigationview;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(listener);


        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new HomeFragment(),null).commit();

    }



    private BottomNavigationView.OnNavigationItemSelectedListener listener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectFragment = null;

                    switch (item.getItemId()) {

                        case R.id.homeItem :
                            selectFragment = new HomeFragment();
                            break;

                        case R.id.notificationItem :
                            selectFragment = new NotFragment();
                            break;

                        case R.id.serachItem :
                            selectFragment = new SearchFragment();
                            break;

                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,selectFragment,null).commit();
                    return true;

                }
            };

}
