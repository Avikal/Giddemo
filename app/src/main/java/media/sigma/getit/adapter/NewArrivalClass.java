package media.sigma.getit.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import media.sigma.getit.FullDescripation;
import media.sigma.getit.R;

/**
 * Created by avikal on 4/19/2016.
 */
public class NewArrivalClass extends Fragment
{
    Context context;
    int valuePack;
    GridView gridview;
    Integer[] ima_src = {R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,R.drawable.d11,R.drawable.d12};
    GridApapter adapter;
    public NewArrivalClass(Context context,int valuePack)
    {
        this.context = context;
        this.valuePack = valuePack;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.rent_layout,container,false);
        gridview = (GridView) rootView.findViewById(R.id.rent_grid);
        adapter = new GridApapter(context,R.layout.gridimage,ima_src);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent intent = new Intent(context, FullDescripation.class);
                    intent.putExtra("value",0);
                    intent.putExtra("valueclick",valuePack);
                    context.startActivity(intent);
                }
                else if(position==1)
                {
                    Intent intent = new Intent(context,FullDescripation.class);
                    intent.putExtra("value",1);
                    intent.putExtra("valueclick",valuePack);
                    context.startActivity(intent);
                }
                else if (position==2)
                {
                    Intent intent = new Intent(context,FullDescripation.class);
                    intent.putExtra("value",2);
                    intent.putExtra("valueclick",valuePack);
                    context.startActivity(intent);
                }
            }
        });
        return rootView;
    }

    public class GridApapter extends BaseAdapter
    {

        Context context;
        Integer[] image_id;
        private LayoutInflater inflater;

        public GridApapter(Context context, int gridImage, Integer[] image_id)
        {
            this.context = context;
            this.image_id = image_id;
            inflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return image_id.length;
        }


        @Override
        public Object getItem(int position) {
            return image_id[position];
        }


        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            ImageView picture;

            v = inflater.inflate(R.layout.gridimage,parent,false);

            picture = (ImageView)v.findViewById(R.id.grid_image_view);
            picture.setImageResource(image_id[position]);
            return v;
        }
    }

}
