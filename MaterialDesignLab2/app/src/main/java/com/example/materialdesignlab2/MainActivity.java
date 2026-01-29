package com.example.materialdesignlab2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.materialdesignlab2.Fragment3;
import com.example.materialdesignlab2.Fragment4;
import com.example.materialdesignlab2.Fragment5;
import com.example.materialdesignlab2.R;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ImageView menuButton;
    private LinearLayout navHome, navSettings, navShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        drawerLayout = findViewById(R.id.main);
        menuButton = findViewById(R.id.menu);
        navHome = findViewById(R.id.nav_home);
        navSettings = findViewById(R.id.nav_settings);
        navShare = findViewById(R.id.nav_share);

        // Set up menu button to open/close drawer
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        // Set up navigation item clicks
        navHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Fragment3());
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        navSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Fragment4());
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        navShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Fragment5());
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        // Load default fragment (Home) when app starts
        if (savedInstanceState == null) {
            loadFragment(new Fragment3());
        }
    }

    // Method to load fragments
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment);
        fragmentTransaction.commit();
    }

}