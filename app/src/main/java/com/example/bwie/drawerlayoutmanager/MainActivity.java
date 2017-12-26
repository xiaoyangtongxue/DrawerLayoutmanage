package com.example.bwie.drawerlayoutmanager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


       BottomTabBar bottomTabBar;
       ViewPager viewPager;
       RadioButton  btn,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        // bottomTabBar=(BottomTabBar)findViewById(R.id.botm);
        viewPager=(ViewPager)findViewById(R.id.viewpager22) ;
        btn = (RadioButton) findViewById(R.id.btn);
        btn2 = (RadioButton) findViewById(R.id.btn2);
        btn3 = (RadioButton) findViewById(R.id.btn3);
          viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
              @Override
              public Fragment getItem(int position) {
                  Fragment fragment=null;
                  switch (position){
                      case 0:
                         fragment = new Fragment1();
                         break;

                     case 1:
                         fragment = new Fragment2();
                         break;
                     case 2:
                         fragment = new Fragment3();
                         break;
                     default:

                         break;
                  }
                  return fragment;
              }

              @Override
              public int getCount() {
                  return 3;
              }
          });
        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        btn.setText("sss");
                        btn.setTextColor(Color.RED);
                        btn2.setTextColor(Color.BLACK);
                        btn3.setTextColor(Color.BLACK);
                        break;
                    case 1:
                        btn.setText("sss1");
                        viewPager.setCurrentItem(1);
                        btn2.setTextColor(Color.RED);
                        btn.setTextColor(Color.BLACK);
                        btn3.setTextColor(Color.BLACK);
                        break;
                    case 2:
                        viewPager.setCurrentItem(2);
                        btn3.setTextColor(Color.RED);
                        btn2.setTextColor(Color.BLACK);
                        btn.setTextColor(Color.BLACK);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                viewPager.setCurrentItem(0);
//                //btn.setTextColor(Color.RED);
//                btn.setBackgroundColor(Color.RED);
//            }
//        });
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                viewPager.setCurrentItem(1);
//            }
//        });
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                viewPager.setCurrentItem(2);
//            }
//        });

//        bottomTabBar.init(getSupportFragmentManager())
//                .setImgSize(30,30)
//                .setFontSize(12)
//                .setTabPadding(4,6,10)
//                .setChangeColor(Color.RED,Color.DKGRAY)
//                .addTabItem("Home",R.mipmap.ic_launcher,Fragment1.class)
//                .addTabItem("Read",R.mipmap.ic_launcher,Fragment2.class)
//                .addTabItem("Me",R.mipmap.ic_launcher,Fragment3.class)
//                .isShowDivider(false)
//                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
//                    @Override
//                    public void onTabChange(int position, String name) {
//
//                    }
//                });
//        //viewPager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
//         viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
//
//
//             @Override
//             public Fragment getItem(int position) {
//                 Fragment fragment = null;
//                 switch (position) {
//                     case 0:
//                         fragment = new Fragment1();
//                         break;
//
//                     case 1:
//                         fragment = new Fragment2();
//                         break;
//                     case 2:
//                         fragment = new Fragment3();
//                         break;
//                     default:
//
//                         break;
//
//                 }
//                 return fragment;
//             }
//                 @Override
//                 public int getCount() {
//                     return 3;
//                 }
//
//             public CharSequence getPageTitle(int position) {
//                 return data.get(position);
//             }
//         });
//


    }

    @Override
    public void onClick(View v) {
             switch (v.getId()){
                 case R.id.btn:
                     viewPager.setCurrentItem(0);
                     btn.setTextColor(Color.RED);
                     btn2.setTextColor(Color.BLACK);
                     btn3.setTextColor(Color.BLACK);
                     break;
                 case R.id.btn2:
                     viewPager.setCurrentItem(1);
                     btn2.setTextColor(Color.RED);
                     btn.setTextColor(Color.BLACK);
                     btn3.setTextColor(Color.BLACK);
                     break;
                 case R.id.btn3:
                     viewPager.setCurrentItem(2);
                     btn3.setTextColor(Color.RED);
                     btn2.setTextColor(Color.BLACK);
                     btn.setTextColor(Color.BLACK);
                     break;

             }
    }



}
