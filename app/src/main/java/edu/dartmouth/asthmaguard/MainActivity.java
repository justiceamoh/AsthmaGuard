package edu.dartmouth.asthmaguard;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import java.util.ArrayList;
import com.example.menglingli.asthma.view.SlidingTabLayout;

/**
 * Created by menglingli on 2/21/15.
 */
public class MainActivity extends Activity {

    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments;
    private ActionTabsViewPagerAdapter myViewPageAdapter;
    private HistoryFragment historyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Define SlidingTabLayout(top) and ViewPager(bottom) in the layout
        //Get their instances
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.tab);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        //create a fragment list in order
        fragments = new ArrayList<Fragment>();
        historyFragment = new HistoryFragment();
        fragments.add(new StartFragment());
        fragments.add(historyFragment);
        // fragments.add(new SettingFragment());


        //use FragmentPagerAdapter to bind the slidingTabLayout
        //and ViewPager (different pages of fragment) together
        myViewPageAdapter = new ActionTabsViewPagerAdapter(getFragmentManager(),
                fragments);
        viewPager.setAdapter(myViewPageAdapter);

        slidingTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if (position == 1) {
                    historyFragment.onResume();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
        });
        // make sure the tabs are equally spaced
        slidingTabLayout.setDistributeEvenly(true);
        //slidingTabLayout.setOnClickListener();
        slidingTabLayout.setViewPager(viewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

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

}

