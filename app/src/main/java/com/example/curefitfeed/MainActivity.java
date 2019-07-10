package com.example.curefitfeed;

import android.os.Bundle;

import com.example.curefitfeed.View.CultFragment;
import com.example.curefitfeed.View.EatFragment;
import com.example.curefitfeed.View.MindFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private Fragment fragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_cult);
                    //launch cult fragment
                    fragment = new CultFragment();
                    break;
                case R.id.navigation_dashboard:
                   // mTextMessage.setText(R.string.title_eat);
                    //launch eat fragment
                    fragment = new EatFragment();
                    break;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_mind);
                    //launch mind fragment
                    fragment = new MindFragment();
                    break;
            }
            return loadFragment(fragment);
        }
    };

    private boolean loadFragment(Fragment fragment){
        if(fragment!=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;
        }
        return false;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = new CultFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

}
