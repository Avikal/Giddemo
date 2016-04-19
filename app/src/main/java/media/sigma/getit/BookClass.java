package media.sigma.getit;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import media.sigma.getit.model.Constant;
import media.sigma.getit.model.SharedPrefs;

/**
 * Created by avikal on 4/16/2016.
 */
public class BookClass extends AppCompatActivity
{
    CardView from_date,to_date;
    String form_date_str,to_date_str;
    Bundle bundle;
    boolean form_boo,to_boo;
    TextView txt_form,txt_to;
    private Toolbar toolbar;
    int value;
    protected void onCreate(Bundle savedInstancState)
    {
        super.onCreate(savedInstancState);
        setContentView(R.layout.book_xml);
        bundle = getIntent().getExtras();
        txt_form = (TextView) findViewById(R.id.form_text);
        txt_to = (TextView) findViewById(R.id.to_text);
        form_boo = SharedPrefs.getDefaultBooleanSharedPrefes(getApplicationContext(), Constant.KEY_FORM);
        to_boo = SharedPrefs.getDefaultBooleanSharedPrefes(getApplicationContext(), Constant.KEY_TO);
        form_date_str = SharedPrefs.getDefaultSharedPrefes(getApplicationContext(), Constant.KEY_FORM_STR);
        to_date_str = SharedPrefs.getDefaultSharedPrefes(getApplicationContext(), Constant.KEY_TO_STR);
        txt_to.setText(to_date_str);
        txt_form.setText(form_date_str);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setSupportActionBar(toolbar);
        value = bundle.getInt("value");
        toolbar.setTitle("Get It Dress");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        //toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

                Intent offers = new Intent(BookClass.this, FullDescripation.class);
                offers.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                offers.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                offers.putExtra("value", value);
                startActivity(offers);

            }
        });
        from_date = (CardView) findViewById(R.id.form_date);
        to_date = (CardView) findViewById(R.id.to_date);
        from_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BookClass.this, MyCalendarActivity.class);
                SharedPrefs.setDefaultBooleanSharedPrefes(BookClass.this, Constant.KEY_FORM, true);
                intent.putExtra("form", true);
                intent.putExtra("to", false);
                startActivity(intent);
                finish();
            }
        });
        to_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BookClass.this,MyCalendarActivity.class);
                SharedPrefs.setDefaultBooleanSharedPrefes(BookClass.this, Constant.KEY_TO, true);
                intent.putExtra("to", true);
                intent.putExtra("form",false);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent offers = new Intent(BookClass.this, FullDescripation.class);
        offers.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        offers.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        offers.putExtra("value", value);
        startActivity(offers);
    }
}
