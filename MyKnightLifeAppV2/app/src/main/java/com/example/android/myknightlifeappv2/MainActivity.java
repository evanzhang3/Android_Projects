package com.example.android.myknightlifeappv2;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements SettingsFragment.FragmentSettingListener {
    private SettingsFragment settingsFragment;
    private HomeFragment homeFragment;
    private CharSequence aInput = "A-Block";
    private CharSequence cInput = "C-Block";
    private CharSequence bInput = "B-Block";
    private CharSequence dInput = "D-Block";
    private CharSequence eInput = "E-Block";
    private CharSequence fInput = "F-Block";
    private CharSequence gInput = "G-Block";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeFragment = new HomeFragment();
        settingsFragment = new SettingsFragment();
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }
    public void onInputSettingSent(CharSequence aInput,CharSequence bInput,CharSequence cInput,CharSequence dInput,CharSequence eInput,CharSequence fInput,CharSequence gInput) {
        Log.i("Evan","onInputSettingSent()>   " + aInput);
        this.aInput = aInput;
        this.bInput = bInput;
        this.cInput = cInput;
        this.dInput = dInput;
        this.eInput = eInput;
        this.fInput = fInput;
        this.gInput = gInput;
        homeFragment.updateEditText(aInput,bInput,cInput,dInput,eInput,fInput,gInput);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch (menuItem.getItemId()) {
                case R.id.nav_home:
                    Log.i("Evan","Event 1");
                    Bundle bundle = new Bundle();
                    bundle.putString("ABlockInfo",aInput.toString());
                    bundle.putString("BBlockInfo",bInput.toString());
                    bundle.putString("CBlockInfo",cInput.toString());
                    bundle.putString("DBlockInfo",dInput.toString());
                    bundle.putString("EBlockInfo",eInput.toString());
                    bundle.putString("FBlockInfo",fInput.toString());
                    bundle.putString("GBlockInfo",gInput.toString());
                    selectedFragment = new HomeFragment();
                    selectedFragment.setArguments(bundle);
                    break;
                case R.id.nav_setting:
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("ABlockInfo",aInput.toString());
                    bundle1.putString("BBlockInfo",bInput.toString());
                    bundle1.putString("CBlockInfo",cInput.toString());
                    bundle1.putString("DBlockInfo",dInput.toString());
                    bundle1.putString("EBlockInfo",eInput.toString());
                    bundle1.putString("FBlockInfo",fInput.toString());
                    bundle1.putString("GBlockInfo",gInput.toString());
                    Log.i("Evan","MainActivity");
                    selectedFragment = new SettingsFragment();
                    selectedFragment.setArguments(bundle1);
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return true;
        }
    };
}
