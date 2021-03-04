package com.unit1.parstagram;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.unit1.parstagram.fragments.ComposeFragment;
import com.unit1.parstagram.fragments.PostsFragment;
import com.unit1.parstagram.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    final FragmentManager fragmentManager = getSupportFragmentManager();
    private BottomNavigationView bottomNavigationView;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        menu = bottomNavigationView.getMenu();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.action_home:
                        fragment = new PostsFragment();
//                        item.setIcon(R.drawable.instagram_home_filled_24);
                        //menu.getItem(R.id.action_home).setIcon(R.drawable.instagram_new_post_outline_24);
                        //menu.getItem(R.id.action_profile).setIcon(R.drawable.instagram_user_outline_24);
                        break;
                    case R.id.action_compose:
                        fragment = new ComposeFragment();
//                        item.setIcon(R.drawable.instagram_new_post_filled_24);
                        //menu.getItem(R.id.action_profile).setIcon(R.drawable.instagram_user_outline_24);
//                        menu.getItem(R.id.action_home).setIcon(R.drawable.instagram_home_outline_24);
                        break;
                    case R.id.action_profile:
                    default:
                        fragment = new ProfileFragment();
//                        item.setIcon(R.drawable.instagram_user_filled_24);
//                        menu.getItem(R.id.action_home).setIcon(R.drawable.instagram_home_outline_24);
//                        menu.getItem(R.id.action_compose).setIcon(R.drawable.instagram_new_post_outline_24);
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }
}