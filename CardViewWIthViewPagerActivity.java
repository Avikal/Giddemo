package com.slidermenu.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.slidermenu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by avikaljain on 8/9/17.
 */

public class CardViewWIthViewPagerActivity extends BaseActivity {


    @BindView(R.id.pager)
    ViewPager mViewPager;

    CustomPagerAdapter customPagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        ButterKnife.bind(this);

        customPagerAdapter = new CustomPagerAdapter(this);
        mViewPager.setAdapter(customPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    class CustomPagerAdapter extends PagerAdapter {

        Context mContext;
        LayoutInflater mLayoutInflater;

/*        @BindView(R.id.cardViewTest)
        CardView cardViewTest;*/

        @BindView(R.id.imageViewTest)
        ImageView imageViewTest;

        @BindView(R.id.textViewDetail)
        TextView textViewDetail;

//        @BindView(R.id.fab)
//        FloatingActionButton fab;


        int image[] = {R.drawable.banner_one, R.drawable.banner_two, R.drawable.banner_one};

        boolean isPlay;

        String text[] = {"Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum",
                "Lorem ipsum dolor sit amet, ad sea democritum omittantur, ex mel ridens vulputate omittantur, no erant partem legimus nam. Mel no alienum dolores legendos, id quando nostrum vel, nec nullam commune rationibus at. Vero liber elaboraret cu pri, vis id ipsum scribentur. An forensibus percipitur mea.\n" +
                        "\n" +
                        "Nec an posse suscipiantur, tritani aperiri nec ea. Ne diceret nonumes mea. At mel adhuc munere vidisse. Ei mea eros velit convenire, simul latine volumus ex eam, ad mel veri maiorum imperdiet. Nam assum insolens an. Labitur perpetua vix ut.\n" +
                        "\n" +
                        "Eum falli veniam doctus id, tempor quodsi partiendo eu nam. An eros noster tritani mei, mei et nihil senserit postulant. Impetus mandamus id sit, novum insolens consectetuer ea mea. Nam ne erat iusto referrentur, has novum oportere ne. Est modo etiam scriptorem id, facete antiopam qui et.\n" +
                        "\n" +
                        "Nec no choro quidam omnesque, veri summo ex vis. Atqui hendrerit consetetur pri in, solum erant ut pri, ne sed meis erroribus. An nostrum ancillae vix, ne ubique albucius per. Et vix mucius eligendi, ea qui primis tritani, cum rebum noster complectitur an.\n" +
                        "\n" +
                        "Ex paulo urbanitas sed, etiam eruditi vis id, ei fastidii urbanitas eos. Eos vitae perfecto ad, at vim nostro regione scribentur. Eu pri sale audiam volumus, impetus expetenda efficiantur ei mei. His no ludus ponderum vulputate, ad diam velit sed. At feugait concludaturque usu. Usu id expetendis definiebas referrentur, vix nusquam docendi et. Congue platonem deterruisset eos ne, ut vix ignota eligendi eloquentiam.",

                "Lorem ipsum dolor sit amet, ad sea democritum omittantur, ex mel ridens vulputate omittantur, no erant partem legimus nam. Mel no alienum dolores legendos, id quando nostrum vel, nec nullam commune rationibus at. Vero liber elaboraret cu pri, vis id ipsum scribentur. An forensibus percipitur mea.\n" +
                        "\n" +
                        "Nec an posse suscipiantur, tritani aperiri nec ea. Ne diceret nonumes mea. At mel adhuc munere vidisse. Ei mea eros velit convenire, simul latine volumus ex eam, ad mel veri maiorum imperdiet. Nam assum insolens an. Labitur perpetua vix ut.\n" +
                        "\n" +
                        "Eum falli veniam doctus id, tempor quodsi partiendo eu nam. An eros noster tritani mei, mei et nihil senserit postulant. Impetus mandamus id sit, novum insolens consectetuer ea mea. Nam ne erat iusto referrentur, has novum oportere ne. Est modo etiam scriptorem id, facete antiopam qui et.\n" +
                        "\n" +
                        "Nec no choro quidam omnesque, veri summo ex vis. Atqui hendrerit consetetur pri in, solum erant ut pri, ne sed meis erroribus. An nostrum ancillae vix, ne ubique albucius per. Et vix mucius eligendi, ea qui primis tritani, cum rebum noster complectitur an.\n" +
                        "\n" +
                        "Ex paulo urbanitas sed, etiam eruditi vis id, ei fastidii urbanitas eos. Eos vitae perfecto ad, at vim nostro regione scribentur. Eu pri sale audiam volumus, impetus expetenda efficiantur ei mei. His no ludus ponderum vulputate, ad diam velit sed. At feugait concludaturque usu. Usu id expetendis definiebas referrentur, vix nusquam docendi et. Congue platonem deterruisset eos ne, ut vix ignota eligendi eloquentiam."};


        public CustomPagerAdapter(Context context) {
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return image.length;
        }

        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((NestedScrollView) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.item_pager, container, false);
            ButterKnife.bind(this, itemView);

            final FloatingActionButton fab = (FloatingActionButton) itemView.findViewById(R.id.fab);
            imageViewTest.setImageResource(image[position]);
            textViewDetail.setText(text[position]);
//            fab.setTag(position);

            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isPlay) {
                        isPlay = false;
                        fab.setImageResource(R.drawable.settings);
                    } else {
                        isPlay = true;
                        fab.setImageResource(R.drawable.cart);
                    }
                }
            });
            container.addView(itemView);
            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((NestedScrollView) object);
        }

        public void setCustomTextSize(/*float size*/) {
//            value = size;
            notifyDataSetChanged();
        }


    }
}
