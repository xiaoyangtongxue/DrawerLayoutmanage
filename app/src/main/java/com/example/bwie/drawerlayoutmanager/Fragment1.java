package com.example.bwie.drawerlayoutmanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {


    TabLayout tabLayout;
    ViewPager viewPager;
    private List<String> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment1, null);

        tabLayout = (TabLayout) view.findViewById(R.id.tab);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);

        data.add("第一页");
        data.add("第二页");
        data.add("第三页");

        viewPager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {




            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                //当选中的位置是对应的索引值的话 就加载那个Fragment
                switch (position) {
                    case 0:
                        fragment = new Fragment4();
                        break;

                    case 1:
                        fragment = new Fragment5();
                        break;

                    case 2:
                        fragment = new Fragment6();
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

            public CharSequence getPageTitle(int position) {
                return data.get(position);
            }
        });
        //进行关联
        tabLayout.setupWithViewPager(viewPager);


      return view;
    }
}









