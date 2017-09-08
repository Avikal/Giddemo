package com.slidermenu;

import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.pager)
    ViewPager mViewPager;
    CustomPagerAdapter customPagerAdapter;
//    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    @OnClick(R.id.button)
    public void clickSize() {

        customPagerAdapter.setCustomTextSize(30);
    }


    class CustomPagerAdapter extends PagerAdapter {

        String test = "Lorem ipsum dolor sit amet, " +
                "\n" + "\n" +


                "ad sea democritum omittantur, ex mel ridens vulputate omittantur, no erant partem legimus nam. Mel no alienum dolores legendos, id quando nostrum vel, nec nullam commune rationibus at. Vero liber elaboraret cu pri, vis id ipsum scribentur. An forensibus percipitur mea.\n" +
                "\n" +
                "Nec an posse suscipiantur, tritani aperiri nec ea. Ne diceret nonumes mea. At mel adhuc munere vidisse. Ei mea eros velit convenire, simul latine volumus ex eam, ad mel veri maiorum imperdiet. Nam assum insolens an. Labitur perpetua vix ut.\n" +
                "\n" +
                "Eum falli veniam doctus id, tempor quodsi partiendo eu nam. An eros noster tritani mei, mei et nihil senserit postulant. Impetus mandamus id sit, novum insolens consectetuer ea mea. Nam ne erat iusto referrentur, has novum oportere ne. Est modo etiam scriptorem id, facete antiopam qui et.\n" +
                "\n" +
                "Nec no choro quidam omnesque, veri summo ex vis. Atqui hendrerit consetetur pri in, solum erant ut pri, ne sed meis erroribus. An nostrum ancillae vix, ne ubique albucius per. Et vix mucius eligendi, ea qui primis tritani, cum rebum noster complectitur an.\n" +
                "\n" +
                "Ex paulo urbanitas sed, etiam eruditi vis id, ei fastidii urbanitas eos. Eos vitae perfecto ad, at vim nostro regione scribentur. Eu pri sale audiam volumus, impetus expetenda efficiantur ei mei. His no ludus ponderum vulputate, ad diam velit sed. At feugait concludaturque usu. Usu id expetendis definiebas referrentur, vix nusquam docendi et. Congue platonem deterruisset eos ne, ut vix ignota eligendi eloquentiam." +

                "ad sea democritum omittantur, ex mel ridens vulputate omittantur, no erant partem legimus nam. Mel no alienum dolores legendos, id quando nostrum vel, nec nullam commune rationibus at. Vero liber elaboraret cu pri, vis id ipsum scribentur. An forensibus percipitur mea.\n" +
                "\n" +
                "Nec an posse suscipiantur, tritani aperiri nec ea. Ne diceret nonumes mea. At mel adhuc munere vidisse. Ei mea eros velit convenire, simul latine volumus ex eam, ad mel veri maiorum imperdiet. Nam assum insolens an. Labitur perpetua vix ut.\n" +
                "\n" +
                "Eum falli veniam doctus id, tempor quodsi partiendo eu nam. An eros noster tritani mei, mei et nihil senserit postulant. Impetus mandamus id sit, novum insolens consectetuer ea mea. Nam ne erat iusto referrentur, has novum oportere ne. Est modo etiam scriptorem id, facete antiopam qui et.\n" +
                "\n" +
                "Nec no choro quidam omnesque, veri summo ex vis. Atqui hendrerit consetetur pri in, solum erant ut pri, ne sed meis erroribus. An nostrum ancillae vix, ne ubique albucius per. Et vix mucius eligendi, ea qui primis tritani, cum rebum noster complectitur an.\n" +
                "\n" +
                "Ex paulo urbanitas sed, etiam eruditi vis id, ei fastidii urbanitas eos. Eos vitae perfecto ad, at vim nostro regione scribentur. Eu pri sale audiam volumus, impetus expetenda efficiantur ei mei. His no ludus ponderum vulputate, ad diam velit sed. At feugait concludaturque usu. Usu id expetendis definiebas referrentur, vix nusquam docendi et. Congue platonem deterruisset eos ne, ut vix ignota eligendi eloquentiam." +


                "Lorem ipsum dolor sit amet, ad sea democritum omittantur, ex mel ridens vulputate omittantur, no erant partem legimus nam. Mel no alienum dolores legendos, id quando nostrum vel, nec nullam commune rationibus at. Vero liber elaboraret cu pri, vis id ipsum scribentur. An forensibus percipitur mea.\n" +
                "\n" +
                "Nec an posse suscipiantur, tritani aperiri nec ea. Ne diceret nonumes mea. At mel adhuc munere vidisse. Ei mea eros velit convenire, simul latine volumus ex eam, ad mel veri maiorum imperdiet. Nam assum insolens an. Labitur perpetua vix ut.\n" +
                "\n" +
                "Eum falli veniam doctus id, tempor quodsi partiendo eu nam. An eros noster tritani mei, mei et nihil senserit postulant. Impetus mandamus id sit, novum insolens consectetuer ea mea. Nam ne erat iusto referrentur, has novum oportere ne. Est modo etiam scriptorem id, facete antiopam qui et.\n" +
                "\n" +
                "Nec no choro quidam omnesque, veri summo ex vis. Atqui hendrerit consetetur pri in, solum erant ut pri, ne sed meis erroribus. An nostrum ancillae vix, ne ubique albucius per. Et vix mucius eligendi, ea qui primis tritani, cum rebum noster complectitur an.\n" +
                "\n" +
                "Ex paulo urbanitas sed, etiam eruditi vis id, ei fastidii urbanitas eos. Eos vitae perfecto ad, at vim nostro regione scribentur. Eu pri sale audiam volumus, impetus expetenda efficiantur ei mei. His no ludus ponderum vulputate, ad diam velit sed. At feugait concludaturque usu. Usu id expetendis definiebas referrentur, vix nusquam docendi et. Congue platonem deterruisset eos ne, ut vix ignota eligendi eloquentiam.  Avikal Jain";
        Context mContext;
        LayoutInflater mLayoutInflater;

        TextView textView;

        @BindView(R.id.textView3)
        TextView textView3;


        float value = 0;
        TextToSpeech t1;

        public CustomPagerAdapter(Context context) {
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return 4;
        }

        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((RelativeLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.view_blue, container, false);
            ButterKnife.bind(this, itemView);
            test = test.replace("\n", "<br>");
            t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status != TextToSpeech.ERROR) {
                        t1.setLanguage(Locale.UK);
                    }
                }
            });

            t1.setSpeechRate(3);
            textView = (TextView) itemView.findViewById(R.id.textView);

            textView3.setText(Html.fromHtml(test));
            if (value == 0) {
                textView.setTextSize(10);
            } else {
                textView.setTextSize(30);
            }

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    speakOut();
                }
            });
            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((RelativeLayout) object);
        }

        public void setCustomTextSize(float size) {
            value = size;
            notifyDataSetChanged();
        }

//        @OnClick(R.id.textView)
//        public void speak() {
//            speakOut();
//        }

        public void speakOut() {

            String text = textView3.getText().toString();

            int pos = 0;

            while (true) {

                String var = "";

                try {
                    var = text.substring(pos, 3999);
                    pos += 3999;
                } catch (Exception e) {
                    var = text.substring(pos, text.length());
                    break;
                }

                HashMap<String, String> map = new HashMap<String, String>();
                map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "utteranceId");
                t1.speak(var, TextToSpeech.QUEUE_ADD, map);
            }
//            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }
}
