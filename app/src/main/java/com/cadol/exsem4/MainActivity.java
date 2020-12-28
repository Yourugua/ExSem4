package com.cadol.exsem4;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tablayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tablayout = findViewById(R.id.tablayout);
        viewpager = findViewById(R.id.viewpager);

        setUpViewPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mcontato :
                Intent intent = new Intent(MainActivity.this, contacto.class);
                startActivity(intent);
                break;
            case R.id.macerca:
                Intent i = new Intent(MainActivity.this, acerca.class);
                startActivity(i);
                break;
        };
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        /* Primer Fragments*/
        fragments.add(new FirstFragment());
        /* Segundo Fragments */
        fragments.add(new SecondFragment());

        return fragments;
    }

        private void setUpViewPager () {
        viewpager.setAdapter( new  PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tablayout.setupWithViewPager(viewpager);

        tablayout.getTabAt(0).setIcon(R.drawable.icons8_persona_100);
        tablayout.getTabAt(1).setIcon(R.drawable.icons8_person_perfil_48);
    }
}