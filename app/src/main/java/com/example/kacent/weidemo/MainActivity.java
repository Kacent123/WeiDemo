package com.example.kacent.weidemo;


import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kacent.weidemo.fragment.ChatFragment;
import com.example.kacent.weidemo.fragment.FaFragment;
import com.example.kacent.weidemo.fragment.TongFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    public List<Fragment> fraList;
    public ViewPager viewPager;
    public FragmentPagerAdapter adapter;
    public TextView chatView, FaView, TongView;
    public ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        intview();
    }

    private void intview() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        chatView = (TextView) findViewById(R.id.liaotian);
        FaView = (TextView) findViewById(R.id.faxian);
        TongView = (TextView) findViewById(R.id.tongxun);
        imageView = (ImageView) findViewById(R.id.id_iv_tabline);


        ChatFragment tab1 = new ChatFragment();
        FaFragment tab2 = new FaFragment();
        TongFragment tab3 = new TongFragment();
        fraList = new ArrayList<>();
        fraList.add(tab1);
        fraList.add(tab2);
        fraList.add(tab3);

        viewPager.setAdapter(adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return fraList.get(position);
            }

            @Override
            public int getCount() {
                return fraList.size();
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //d
                ObjectAnimator.ofFloat(imageView, "translationX", 200F * (position + positionOffset)).setDuration(1000).start();

            }

            @Override
            public void onPageSelected(int position) {
                reset();

                switch (position) {
                    case 0:
                        chatView.setTextColor(Color.parseColor("#008000"));


                        break;
                    case 1:
                        FaView.setTextColor(Color.parseColor("#008000"));
                       /* ObjectAnimator.ofFloat(imageView, "translationX", 200F * position).setDuration(1000).start();*/

                        break;
                    case 2:
                        TongView.setTextColor(Color.parseColor("#008000"));
                      /*  ObjectAnimator.ofFloat(imageView, "translationX", 200F * position).setDuration(1000).start();*/

                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });


    }

    public void reset() {
        chatView.setTextColor(Color.BLACK);
        FaView.setTextColor(Color.BLACK);
        TongView.setTextColor(Color.BLACK);
    }
}
