package media.sigma.getit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import media.sigma.getit.adapter.BuyClass;
import media.sigma.getit.adapter.NewArrivalClass;
import media.sigma.getit.adapter.PopulerClass;
import media.sigma.getit.adapter.RentClass;

/**
 * Created by intel on 1/23/2016.
 */
public class MenuActivity1 extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Bundle bundle;
    int valueclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_fragment);
        bundle=getIntent().getExtras();
        valueclick=bundle.getInt("valueclick");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setSupportActionBar(toolbar);
        if(valueclick==1)
        {
            toolbar.setTitle("Rent");
        }if(valueclick==2)
        {
            toolbar.setTitle("Buy");
        }

        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        //toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

                Intent offers = new Intent(MenuActivity1.this,MainActivity.class);
                offers.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                offers.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(offers);

            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),MenuActivity1.this, valueclick);

        adapter.addFragment(new NewArrivalClass(MenuActivity1.this,valueclick), "New Arrival");
        adapter.addFragment(new PopulerClass(MenuActivity1.this,valueclick), "Populer");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        int valueclickget;
        Context context;
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager , Context context,int  valueclick) {

            super(manager);
            this.context = context;
            this.valueclickget=valueclick;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();

        Intent offers = new Intent(MenuActivity1.this, MainActivity.class);
        offers.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        offers.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(offers);
    }
}
