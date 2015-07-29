package com.terry.materialsample;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class MainActivity extends AppCompatActivity implements HuanFragment.OnFragmentInteractionListener {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private TextView textViewTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTitle = (TextView) findViewById(R.id.title);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        navigationView = (NavigationView) findViewById(R.id.nav_view);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setCheckable(true);
                drawerLayout.closeDrawers();
                textViewTitle.setText(menuItem.getTitle().toString());
                doDrawerthing(menuItem);
                return true;
            }
        });
    }

    private void doDrawerthing(MenuItem menuItem) {
        View titleArea = findViewById(R.id.title_area);

        if (menuItem.getGroupId() == R.id.menu_group_huan) {
            titleArea.setBackgroundColor(getResources().getColor(R.color.md_amber_300));
            HuanFragment huanFragment = HuanFragment.newInstance("huan", menuItem.getTitle().toString());
            this.getFragmentManager().beginTransaction().replace(R.id.contentPanel, huanFragment).commit();
        } else if (menuItem.getGroupId() == R.id.menu_group_dui) {
            titleArea.setBackgroundColor(getResources().getColor(R.color.md_deep_orange_600));
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
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
