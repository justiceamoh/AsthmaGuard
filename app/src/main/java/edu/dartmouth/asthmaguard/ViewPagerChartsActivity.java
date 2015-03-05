package edu.dartmouth.asthmaguard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Calendar;

import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.BubbleChartData;
import lecho.lib.hellocharts.model.BubbleValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.BubbleChartView;
import lecho.lib.hellocharts.view.ColumnChartView;
import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.view.PieChartView;
import lecho.lib.hellocharts.view.PreviewLineChartView;

public class ViewPagerChartsActivity extends ActionBarActivity implements ActionBar.TabListener {

    private DatabaseHelper db;
    private static List<Entry> all_entries;
    private static Calendar cal = Calendar.getInstance();
    static HashMap<String,Double> map1 = new HashMap<String,Double>();
    static HashMap<String,Double> map2 = new HashMap<String,Double>();
    static HashMap<String,Double> map3 = new HashMap<String,Double>();
    static HashMap<String,Integer> map4 = new HashMap<String,Integer>();
    static HashMap<String,Integer> map5 = new HashMap<String,Integer>();
    static HashMap<String,Integer> map6 = new HashMap<String,Integer>();
    static ArrayList<String> recent = new ArrayList<String>();


	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which will keep every loaded fragment in memory. If this becomes too
	 * memory intensive, it may be best to switch to a {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link android.support.v4.view.ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_pager_charts);

        db  = new DatabaseHelper(this);
        all_entries = db.getAllEntries();
        inRecentWeek();
		// Set up the action bar.
		final ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.hide();

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				actionBar.setSelectedNavigationItem(position);
			}
		});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab().setText(mSectionsPagerAdapter.getPageTitle(i)).setTabListener(this));
		}
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link android.support.v4.app.FragmentPagerAdapter} that returns a fragment corresponding to one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a PlaceholderFragment (defined as a static inner class below).
			return PlaceholderFragment.newInstance(position + 1);
		}

		@Override
		public int getCount() {
			return 4;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
			case 0:
				return "LineChart";
			case 1:
				return "ColumnChart";
			case 2:
				return "BubbleChart";
			case 3:
				return "PieChart";

			}
			return null;
		}

	}

    public void inRecentWeek(){
        Log.d("data","start");
        int dd = cal.get(Calendar.DAY_OF_MONTH);
        int mm = cal.get(Calendar.MONTH);

        for(int i=0;i<7;i++){
            Calendar slot = Calendar.getInstance();
            slot.add(Calendar.DATE, -i);
            //System.out.println("Date = "+ slot.getTime());
            String s= android.text.format.DateFormat.format("MMM dd yyyy",slot.getTimeInMillis()).toString();
            System.out.println(s);
            recent.add(s);
        }

        for(String s:recent){
            Log.d("recent",""+s);
            map1.put(s,0.0);
            map2.put(s,0.0);
            map3.put(s,0.0);
            map4.put(s,0);
            map5.put(s,0);
            map6.put(s,0);
        }
        for(Entry e:all_entries){
            String entry_datetime = e.getDate();
            Log.d("all_entries",""+entry_datetime);
            String type = e.getEventType();
            if(type.equals("Coughing")){
                map4.put(entry_datetime,map4.get(entry_datetime)+1);
                if(map1.containsKey(entry_datetime))
                    map1.put(entry_datetime,map1.get(entry_datetime)+e.getDuration());
            }
            if(type.equals("Wheezing")){
                map5.put(entry_datetime,map5.get(entry_datetime)+1);
                if(map2.containsKey(entry_datetime))
                    map2.put(entry_datetime,map2.get(entry_datetime)+e.getDuration());
            }
            if(type.equals("Dyspnea")){
                map6.put(entry_datetime,map6.get(entry_datetime)+1);
                if(map3.containsKey(entry_datetime))
                    map3.put(entry_datetime,map3.get(entry_datetime)+e.getDuration());
            }
        }
    }

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_view_pager_charts, container, false);
			RelativeLayout layout = (RelativeLayout) rootView;
			int sectionNum = getArguments().getInt(ARG_SECTION_NUMBER);
			switch (sectionNum) {
			case 1:
				LineChartView lineChartView = new LineChartView(getActivity());
				lineChartView.setLineChartData(generateLineChartData());
				lineChartView.setZoomType(ZoomType.HORIZONTAL);

				/** Note: Chart is within ViewPager so enable container scroll mode. **/
				lineChartView.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);

				layout.addView(lineChartView);
				break;
			case 2:
				ColumnChartView columnChartView = new ColumnChartView(getActivity());
				columnChartView.setColumnChartData(generateColumnChartData());
				columnChartView.setZoomType(ZoomType.HORIZONTAL);

				/** Note: Chart is within ViewPager so enable container scroll mode. **/
				columnChartView.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);

				layout.addView(columnChartView);
				break;
			case 3:
				BubbleChartView bubbleChartView = new BubbleChartView(getActivity());
				bubbleChartView.setBubbleChartData(generateBubbleChartData());
				bubbleChartView.setZoomType(ZoomType.HORIZONTAL_AND_VERTICAL);

				/** Note: Chart is within ViewPager so enable container scroll mode. **/
				bubbleChartView.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);

				layout.addView(bubbleChartView);
				break;
			case 4:
                PieChartView pieChartView = new PieChartView(getActivity());
                pieChartView.setPieChartData(generatePieChartData());

                /** Note: Chart is within ViewPager so enable container scroll mode. **/
                pieChartView.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);

                layout.addView(pieChartView);
                break;
			}

			return rootView;
		}

		private LineChartData generateLineChartData() {
			int numValues = 7;
			List<PointValue> values_c = new ArrayList<PointValue>();
            List<PointValue> values_w = new ArrayList<PointValue>();
            List<PointValue> values_d = new ArrayList<PointValue>();
			for (int i = 0; i < numValues; ++i) {
				values_c.add(new PointValue(i, (float)(map4.get(recent.get(i)))));
                values_w.add(new PointValue(i, (float) (map5.get(recent.get(i)))));
                values_d.add(new PointValue(i, (float) (map6.get(recent.get(i)))));
			}

			Line line_coughing = new Line(values_c);
            Line line_wheezing = new Line(values_w);
            Line line_dyspena = new Line(values_d);
            line_coughing.setColor(ChartUtils.COLOR_BLUE);
            line_wheezing.setColor(ChartUtils.COLOR_RED);
            line_dyspena.setColor(ChartUtils.COLOR_ORANGE);



			List<Line> lines = new ArrayList<Line>();
			lines.add(line_coughing);
            lines.add(line_wheezing);
            lines.add(line_dyspena);

			LineChartData data = new LineChartData(lines);
			data.setAxisXBottom(new Axis().setName("Day in Week"));
			data.setAxisYLeft(new Axis().setName("Frequency").setHasLines(true));
			return data;

		}

		private ColumnChartData generateColumnChartData() {
			//int numSubcolumns = 3;
			int numColumns = 7;


			// Column can have many subcolumns, here by default I use 1 subcolumn in each of 8 columns.
			List<Column> columns = new ArrayList<Column>();
			List<SubcolumnValue> values;
			for (int i = 0; i < numColumns; ++i) {

				values = new ArrayList<SubcolumnValue>();
                String s = recent.get(7-1-i);
                    values.add(new SubcolumnValue((float) map1.get(s).floatValue(), ChartUtils.COLOR_BLUE));
                    values.add(new SubcolumnValue((float) map2.get(s).floatValue(), ChartUtils.COLOR_RED));
                    values.add(new SubcolumnValue((float) map3.get(s).floatValue(), ChartUtils.COLOR_ORANGE));

				columns.add(new Column(values));
			}

			ColumnChartData data = new ColumnChartData(columns);

			data.setAxisXBottom(new Axis().setName("Day in Week"));
			data.setAxisYLeft(new Axis().setName("Duration").setHasLines(true));
			return data;

		}

		private BubbleChartData generateBubbleChartData() {
			int numBubbles = 10;
            int size = all_entries.size();
			List<BubbleValue> values = new ArrayList<BubbleValue>();
			for (int i = 0; i < 10; ++i) {
                //前面是位置，后面是直径 random：(float) Math.random() * 50f + 5
                if(size-1-i<0)  break;
                int pos = (all_entries.get(size-1-i).getDateTime().charAt(0)-'0')*10 + (all_entries.get(size-1-i).getDateTime().charAt(1)-'0');
                Log.d("here",""+pos);
                //Log.d("here",""+all_entries.get(i).getDateTime().charAt(0)+","+all_entries.get(i).getDateTime().charAt(1));
                BubbleValue value = new BubbleValue(i,pos, all_entries.get(i).getDegree());
                if(all_entries.get(i).getEventType().equals("Coughing"))
                    value.setColor(ChartUtils.COLOR_BLUE);
                if(all_entries.get(i).getEventType().equals("Wheezing"))
                    value.setColor(ChartUtils.COLOR_RED);
                if(all_entries.get(i).getEventType().equals("Dyspnea"))
                    value.setColor(ChartUtils.COLOR_ORANGE);

				values.add(value);
			}

			BubbleChartData data = new BubbleChartData(values);
			data.setAxisXBottom(new Axis().setName("Most 10 Recent Events"));
			data.setAxisYLeft(new Axis().setName("Event Happening Time").setHasLines(true));
			return data;
		}

		private LineChartData generatePreviewLineChartData() {
			int numValues = 50;

			List<PointValue> values = new ArrayList<PointValue>();
			for (int i = 0; i < numValues; ++i) {
				values.add(new PointValue(i, (float) Math.random() * 100f));
			}

			Line line = new Line(values);
			line.setColor(ChartUtils.DEFAULT_DARKEN_COLOR);
			line.setHasPoints(false);// too many values so don't draw points.

			List<Line> lines = new ArrayList<Line>();
			lines.add(line);

			LineChartData data = new LineChartData(lines);
			data.setAxisXBottom(new Axis());
			data.setAxisYLeft(new Axis().setHasLines(true));

			return data;

		}

		private PieChartData generatePieChartData() {
			int cnt_c = 0, cnt_w = 0, cnt_d = 0;
            for(Entry a:all_entries){
                if(a.getEventType().equals("Coughing"))
                     cnt_c++;
                if(a.getEventType().equals("Wheezing"))
                    cnt_w++;
                if(a.getEventType().equals("Dyspnea"))
                    cnt_d++;
            }
			List<SliceValue> values = new ArrayList<SliceValue>();
            values.add(new SliceValue((float)(cnt_c),ChartUtils.COLOR_BLUE));
            values.add(new SliceValue((float)(cnt_w),ChartUtils.COLOR_RED));
            values.add(new SliceValue((float)(cnt_d),ChartUtils.COLOR_ORANGE));


			PieChartData data = new PieChartData(values);
			return data;
		}

	}

}
