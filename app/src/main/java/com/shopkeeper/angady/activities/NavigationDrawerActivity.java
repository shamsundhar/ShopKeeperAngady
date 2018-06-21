package com.shopkeeper.angady.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import angady.com.customer.R;
import angady.com.customer.fragments.ContactDetailsFragment;
import angady.com.customer.fragments.FeedbackFragment;
import angady.com.customer.fragments.OrderHistoryFragment;
import angady.com.customer.fragments.PaymentOptionsFragment;
import angady.com.customer.fragments.ResetPasswordFragment;
import angady.com.customer.fragments.ShopListFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.location_layout)
    LinearLayout _locationLayout;
    String market_uri = "https://play.google.com/store/apps/details?id=";
    private static final String PAYMENT_OPTIONS_FRAGMENT_TAG = "PAYMENT_OPTIONS_FRAGMENT";
    private static final String CHANGE_PASSWORD_FRAGMENT_TAG = "CHANGE_PASSWORD_FRAGMENT";
    private static final String CONTACT_DETAILS_FRAGMENT_TAG = "CONTACT_DETAILS_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        displayShopListFragment();
    }
    @OnClick(R.id.location_layout)
    public void locationLayoutOnClick(){
        Toast.makeText(NavigationDrawerActivity.this, "location clicked..", Toast.LENGTH_LONG).show();
    }
    private void setTitle(String title){
        getSupportActionBar().setTitle(title);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.navigation_drawer, menu);
//
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchManager searchManager = (SearchManager) NavigationDrawerActivity.this.getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView = null;
//        if (searchItem != null) {
//            searchView = (SearchView) searchItem.getActionView();
//        }
//        if (searchView != null) {
//            searchView.setSearchableInfo(searchManager.getSearchableInfo(NavigationDrawerActivity.this.getComponentName()));
//        }
//        return super.onCreateOptionsMenu(menu);
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
    public void displayShopListFragment(){
        setTitle(null);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,  ShopListFragment.newInstance(), CONTACT_DETAILS_FRAGMENT_TAG)
                .commit();
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id == R.id.nav_home){
            _locationLayout.setVisibility(View.VISIBLE);
        }else{
            _locationLayout.setVisibility(View.GONE);
        }

        if (id == R.id.nav_signout) {
            // Handle the camera action
        } else if(id == R.id.nav_home){
            displayShopListFragment();
        }else if (id == R.id.nav_contact_details) {
            setTitle(getString(R.string.text_contact_details));
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container,  ContactDetailsFragment.newInstance(), CONTACT_DETAILS_FRAGMENT_TAG)
                    .commit();

        } else if (id == R.id.nav_payment_options) {
            setTitle(getString(R.string.text_payment_options));
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container,  PaymentOptionsFragment.newInstance(), PAYMENT_OPTIONS_FRAGMENT_TAG)
                    .commit();
        } else if (id == R.id.nav_order_history) {
            setTitle(getString(R.string.text_order_history));
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new OrderHistoryFragment(), "")
                    .commit();
        } else if (id == R.id.nav_change_password) {
            setTitle(getString(R.string.text_change_password));
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, ResetPasswordFragment.newInstance(), CHANGE_PASSWORD_FRAGMENT_TAG)
                    .commit();
        } else if (id == R.id.nav_feedback) {
            setTitle(getString(R.string.text_about_feedback));
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, FeedbackFragment.newInstance(), "")
                    .commit();

        } else if (id == R.id.nav_share) {
            market_uri = market_uri + getPackageName();
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareSub = "I found a cool Android App";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
            sharingIntent.putExtra(Intent.EXTRA_TEXT, market_uri);
            startActivity(Intent.createChooser(sharingIntent, "Share using"));
        }else if (id == R.id.nav_rateapp) {
            Uri uri = Uri.parse("market://details?id=" + getPackageName());
            Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
            try {
                startActivity(myAppLinkToMarket);
            } catch (ActivityNotFoundException e) {
                uri = Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName()+"");
                Intent goMarket = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(goMarket);
            }
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}












