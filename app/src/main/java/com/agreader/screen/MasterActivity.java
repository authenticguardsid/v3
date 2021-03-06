package com.agreader.screen;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.agreader.R;
import com.agreader.adapter.SectionPagesAdapter;
import com.agreader.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MasterActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MenuItem prevMenuItem;
    private TextView pointt;
    private RelativeLayout goPoint;
    private RelativeLayout goLogin;
    private Intent ada;

    String total = "";
    boolean doubleBackToExitPressedOnce = false;
    private BottomNavigationViewEx bottomNavigationViewEx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);
        pointt = (TextView)findViewById(R.id.point);
        goPoint = (RelativeLayout) findViewById(R.id.toPoint);
        goLogin = (RelativeLayout) findViewById(R.id.toLogin);
        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MasterActivity.this,LoginScreenActivity.class);
                startActivity(intent);
            }
        });
        loadData();

        goPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MasterActivity.this, PointActivity.class);
               startActivity(intent);
            }
        });

        //changeStatusBarColor();

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottom_nav_view);
        bottomNavigationViewEx.setIconSize(20, 20);
        bottomNavigationViewEx.setTextSize(12);
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.setTextVisibility(true);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.setIconTintList(0, getResources().getColorStateList(R.color.colorGold));
        bottomNavigationViewEx.setTextTintList(0, getResources().getColorStateList(R.color.colorGold));

        SectionPagesAdapter adapter = new SectionPagesAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        bottomNavigationViewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_home:
                        viewPager.setCurrentItem(0);
                        bottomNavigationViewEx.setIconTintList(0, getResources().getColorStateList(R.color.colorGold));
                        bottomNavigationViewEx.setTextTintList(0, getResources().getColorStateList(R.color.colorGold));
                        bottomNavigationViewEx.setIconTintList(1, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setTextTintList(1, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setIconTintList(2, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setTextTintList(2, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setIconTintList(3, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setTextTintList(3, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setIconTintList(4, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setTextTintList(4, getResources().getColorStateList(R.color.colorGREY));
                        //getSupportActionBar().setTitle("Home");
                        break;
                    case R.id.ic_product:
                        viewPager.setCurrentItem(1);
                        bottomNavigationViewEx.setIconTintList(0, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setTextTintList(0, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setIconTintList(1, getResources().getColorStateList(R.color.colorGold));
                        bottomNavigationViewEx.setTextTintList(1, getResources().getColorStateList(R.color.colorGold));
                        bottomNavigationViewEx.setIconTintList(2, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setTextTintList(2, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setIconTintList(3, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setTextTintList(3, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setIconTintList(4, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setTextTintList(4, getResources().getColorStateList(R.color.colorGREY));
                        //getSupportActionBar().setTitle("QR Code");
                        break;
                    case R.id.ic_qrcode:
                        viewPager.setCurrentItem(2);
                        bottomNavigationViewEx.setIconTintList(0, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setTextTintList(0, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setIconTintList(1, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setTextTintList(1, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setIconTintList(2, getResources().getColorStateList(R.color.colorGold));
                        bottomNavigationViewEx.setTextTintList(2, getResources().getColorStateList(R.color.colorGold));
                        bottomNavigationViewEx.setIconTintList(3, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setTextTintList(3, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setIconTintList(4, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setTextTintList(4, getResources().getColorStateList(R.color.colorGREY));
                        //getSupportActionBar().setTitle("QR Code");
                        break;
                    case R.id.ic_notification:
                        viewPager.setCurrentItem(3);
                        bottomNavigationViewEx.setIconTintList(0, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setTextTintList(0, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setIconTintList(1, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setTextTintList(1, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setIconTintList(2, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setTextTintList(2, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setIconTintList(3, getResources().getColorStateList(R.color.colorGold));
                        bottomNavigationViewEx.setTextTintList(3, getResources().getColorStateList(R.color.colorGold));
                        bottomNavigationViewEx.setIconTintList(4, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setTextTintList(4, getResources().getColorStateList(R.color.colorGREY));
                        //getSupportActionBar().setTitle("QR Code");
                        break;
                    case R.id.ic_profile:
                        viewPager.setCurrentItem(4);
                        bottomNavigationViewEx.setIconTintList(0, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setTextTintList(0, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setIconTintList(1, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setTextTintList(1, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setIconTintList(2, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setTextTintList(2, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setIconTintList(3, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setTextTintList(3, getResources().getColorStateList(R.color.colorGREY));
                        bottomNavigationViewEx.setIconTintList(4, getResources().getColorStateList(R.color.colorGold));
                        bottomNavigationViewEx.setTextTintList(4, getResources().getColorStateList(R.color.colorGold));
                        //getSupportActionBar().setTitle("Profile");
                        break;
                }
                return false;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigationViewEx.getMenu().getItem(0).setChecked(false);
                }
                bottomNavigationViewEx.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationViewEx.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void loadData(){
        FirebaseAuth mFirebaseAuth;
        mFirebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mFirebaseAuth.getCurrentUser();
        if (currentUser != null) {
            goLogin.setVisibility(View.GONE);
            goPoint.setVisibility(View.VISIBLE);
            currentUser = FirebaseAuth.getInstance().getCurrentUser();
            final DatabaseReference dbf = FirebaseDatabase.getInstance().getReference("user").child(currentUser.getUid());
            dbf.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    User us = dataSnapshot.getValue(User.class);
                    try {
                        String point = us.getTotalPoint();
                        double parsepoint = Double.parseDouble(point);
                        NumberFormat formatter = new DecimalFormat("#,###");
                        String formattedNumber = formatter.format(parsepoint);
                        if (us.getTotalPoint() != null)
                            pointt.setText(formattedNumber + " pts");
                        else {
                            pointt.setText("0 pts");
                        }
                    } catch (NullPointerException e) {
                        Log.e("errorbangsat", "onDataChange: ", e);
                    }
                }


                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

}
