package com.example.user.bar;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private DrawerLayout d;
private ActionBarDrawerToggle a;
private NavigationView n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        d=(DrawerLayout)findViewById(R.id.draw);
        a=new ActionBarDrawerToggle(this,d,R.string.open,R.string.close);
        d.addDrawerListener(a);
        a.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       n=(NavigationView)findViewById(R.id.nav);
       n.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
              int id=menuItem.getItemId();
               if(id==R.id.prof)
               {
                   Toast.makeText(MainActivity.this,"profile is click",Toast.LENGTH_SHORT).show();
               }
               return false;
           }
       });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(a.onOptionsItemSelected(item))
        {
            return true;
        }
        
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(d.isDrawerOpen(GravityCompat.START))
        {
            d.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}
