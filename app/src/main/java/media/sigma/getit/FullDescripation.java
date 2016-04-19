package media.sigma.getit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import media.sigma.getit.model.Constant;
import media.sigma.getit.model.SharedPrefs;

/**
 * Created by avikal on 4/15/2016.
 */
public class FullDescripation extends AppCompatActivity {
    ImageView full_view, view_1, view_2, view_3, view_4;
    Bundle bundle;
    int value,valuePack;
    private Toolbar toolbar;
    Button book_now;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_des);
        SharedPrefs.setDefaultBooleanSharedPrefes(FullDescripation.this, Constant.KEY_FORM, false);
        SharedPrefs.setDefaultSharedPrefs(FullDescripation.this, Constant.KEY_FORM_STR, "Form Date");
        if(SharedPrefs.getBooleanValue(FullDescripation.this,Constant.KEY_FORM) == false)
        {
            SharedPrefs.setDefaultBooleanSharedPrefes(FullDescripation.this,Constant.KEY_FORM,false);
            SharedPrefs.setDefaultSharedPrefs(FullDescripation.this, Constant.KEY_FORM_STR, "Form Date");
        }
        else
        {
            SharedPrefs.getDefaultBooleanSharedPrefes(FullDescripation.this,Constant.KEY_FORM);
            SharedPrefs.getDefaultSharedPrefes(FullDescripation.this,Constant.KEY_FORM_STR);
        }
        SharedPrefs.setDefaultBooleanSharedPrefes(FullDescripation.this, Constant.KEY_TO, false);
        SharedPrefs.setDefaultSharedPrefs(FullDescripation.this,Constant.KEY_TO_STR,"To Date");
        if(SharedPrefs.getBooleanValue(FullDescripation.this,Constant.KEY_TO)==false)
        {
            SharedPrefs.setDefaultBooleanSharedPrefes(FullDescripation.this,Constant.KEY_TO,false);
            SharedPrefs.setDefaultSharedPrefs(FullDescripation.this, Constant.KEY_TO_STR, "To Date");
        }
        else
        {
            SharedPrefs.getDefaultBooleanSharedPrefes(FullDescripation.this,Constant.KEY_TO);
            SharedPrefs.getDefaultSharedPrefes(FullDescripation.this, Constant.KEY_TO_STR);
        }
        bundle = getIntent().getExtras();
        value = bundle.getInt("value");
        valuePack = bundle.getInt("valueclick");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setSupportActionBar(toolbar);

        toolbar.setTitle("Get It Dress");


        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        //toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

                Intent offers = new Intent(FullDescripation.this,MenuActivity.class);
                offers.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                offers.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                offers.putExtra("valueclick",valuePack);
                startActivity(offers);

            }
        });

        full_view = (ImageView) findViewById(R.id.full_image);
        view_1 = (ImageView) findViewById(R.id.v1);
        view_2 = (ImageView) findViewById(R.id.v2);
        view_3 = (ImageView) findViewById(R.id.v3);
        view_4 = (ImageView) findViewById(R.id.v4);
        if (value == 0) {
            full_view.setImageResource(R.drawable.d1);
            view_1.setImageResource(R.drawable.d1);
            view_2.setImageResource(R.drawable.d2);
            view_3.setImageResource(R.drawable.d3);
            view_4.setImageResource(R.drawable.d4);
        }

        if (value == 1) {
            full_view.setImageResource(R.drawable.d5);
            view_1.setImageResource(R.drawable.d5);
            view_2.setImageResource(R.drawable.d6);
            view_3.setImageResource(R.drawable.d7);
            view_4.setImageResource(R.drawable.d8);
        }
        if (value == 2) {
            full_view.setImageResource(R.drawable.d9);
            view_1.setImageResource(R.drawable.d9);
            view_2.setImageResource(R.drawable.d10);
            view_3.setImageResource(R.drawable.d11);
            view_4.setImageResource(R.drawable.d12);
        }
        view_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value == 0) {
                    full_view.setImageResource(R.drawable.d1);
                }
                else if (value == 1) {
                    full_view.setImageResource(R.drawable.d5);
                }
                else if (value == 2) {
                    full_view.setImageResource(R.drawable.d9);
                }
                else if (value == 3) {
                    full_view.setImageResource(R.drawable.d1);
                }
            }
        });
        view_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value == 0) {
                    full_view.setImageResource(R.drawable.d2);
                }
                else if (value == 1) {
                    full_view.setImageResource(R.drawable.d6);
                }
                else if (value == 2) {
                    full_view.setImageResource(R.drawable.d10);
                }
                else if (value == 3) {
                    full_view.setImageResource(R.drawable.d2);
                }
            }
        });
        view_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value == 0) {
                    full_view.setImageResource(R.drawable.d3);
                }
                else if (value == 1) {
                    full_view.setImageResource(R.drawable.d7);
                }
                else if (value == 2) {
                    full_view.setImageResource(R.drawable.d11);
                }
                else if (value == 3) {
                    full_view.setImageResource(R.drawable.d3);
                }
            }
        });
        view_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value == 0) {
                    full_view.setImageResource(R.drawable.d4);
                }
                else if (value == 1) {
                    full_view.setImageResource(R.drawable.d8);
                }
                else if (value == 2) {
                    full_view.setImageResource(R.drawable.d12);
                }
                else if (value == 3) {
                    full_view.setImageResource(R.drawable.d4);
                }
            }
        });

        book_now = (Button) findViewById(R.id.book_now);
        book_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FullDescripation.this,BookClass.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("value",value);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();

        Intent offers = new Intent(FullDescripation.this, MenuActivity.class);
        offers.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        offers.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        offers.putExtra("valueclick", valuePack);
        startActivity(offers);
    }
}
