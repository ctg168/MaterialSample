package com.terry.materialsample;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements HuanFragment.OnFragmentInteractionListener {

    private DrawerLayout drawerLayout;
    private TextView textViewTitle;

    private int CurrentThemeColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTitle = (TextView) findViewById(R.id.title);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

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

        //load default form
        HuanFragment huanFragment = HuanFragment.newInstance("huan", getResources().getString(R.string.menu_huan_title_Length));
        this.getFragmentManager().beginTransaction().replace(R.id.contentPanel, huanFragment).commit();
        textViewTitle.setText(getResources().getString(R.string.menu_huan_title_Length));
    }

    private void doDrawerthing(MenuItem menuItem) {


        if (menuItem.getGroupId() == R.id.menu_group_huan) {

            HuanFragment huanFragment = HuanFragment.newInstance("huan", menuItem.getTitle().toString());
            this.getFragmentManager().beginTransaction().replace(R.id.contentPanel, huanFragment).commit();
            //titleArea.setBackgroundColor(getResources().getColor(R.color.md_amber_300));
            //huanFragment.LoadData();




        } else if (menuItem.getGroupId() == R.id.menu_group_dui) {
            findViewById(R.id.title_area).setBackgroundColor(getResources().getColor(R.color.md_deep_orange_600));
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onFragmentInteraction(HuanFragment sender) {
        CurrentThemeColor = sender.CurrentThemeColor;

        View titleArea = findViewById(R.id.title_area);
        titleArea.setBackgroundColor(getResources().getColor(CurrentThemeColor));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(CurrentThemeColor));
            window.setNavigationBarColor(getResources().getColor(CurrentThemeColor));
        }
    }
}
