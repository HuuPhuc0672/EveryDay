package com.example.everyday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.everyday.Function.Fragment.CalendarFragment;
import com.example.everyday.Function.Fragment.DiscoverFragment;
import com.example.everyday.Function.Fragment.EverydayFragment;
import com.example.everyday.Function.Fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private FrameLayout fragmetLayot;
    private FloatingActionButton fab;
    private BottomNavigationView bottomNavigationView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Manmoi();

            }
        });
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectfrag=null;
                switch (item.getItemId()){
                    case R.id.navigation_Everyday:
                        selectfrag=new EverydayFragment();
                        break;
                    case R.id.navigation_Calendar:
                        selectfrag=new CalendarFragment();
                        break;
                    case R.id.navigation_Discover:
                        selectfrag=new DiscoverFragment();
                        break;
                    case R.id.navigation_Profile:
                        selectfrag=new ProfileFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main,selectfrag).commit();
                return true;
            }
        });
    }
    private void Manmoi(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View viewT = LayoutInflater.from(builder.getContext()).inflate(R.layout.dilog_menu_them, null);
        builder.setView(viewT);
        Dialog dialog = builder.create();
        dialog.show();
    }
}