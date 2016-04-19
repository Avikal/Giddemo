package media.sigma.getit.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;



import java.util.ArrayList;

import media.sigma.getit.R;
import media.sigma.getit.model.ImageDownloaderTask;
import media.sigma.getit.model.ListItem;

/**
 * Created by SONU on 29/08/15.
 */
public class SlidingImage_Adapter extends PagerAdapter {


    private ArrayList<Integer> IMAGES;
    private ArrayList<String> IMAGES1;
    private LayoutInflater inflater;
    private Context context;

    private ArrayList<ListItem> Images_Url;
    boolean network;


    public SlidingImage_Adapter(Context context, ArrayList<Integer> IMAGES) {
        this.context = context;
        this.IMAGES = IMAGES;
        inflater = LayoutInflater.from(context);
    }

    public SlidingImage_Adapter(Context mContext, ArrayList<String> IMAGES1, boolean network)
    {
        this.context = mContext;
        this.IMAGES1 = IMAGES1;
        this.network = network;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        if(network)
        {
            return IMAGES1.size();
        }
        else
        {
            return IMAGES.size();
        }

    }

    @Override
    public Object instantiateItem(ViewGroup view, final int position) {
        View imageLayout = inflater.inflate(R.layout.slidingimages_layout, view, false);

        assert imageLayout != null;

        ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.image);
       /* if(network) {
//            ListItem newsItem = Images_Url.get(position);
            new ImageDownloaderTask(imageView).execute(IMAGES1.get(position));
        }*/
//        else {
            imageView.setImageResource(IMAGES.get(position));
//        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* if (position == 0) {
                    Intent intent = new Intent(context, BannerActivity1.class);
                    context.startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(context, BannerActivity2.class);
                    context.startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(context, BannerActivity3.class);
                    context.startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(context, BannerActivity4.class);
                    context.startActivity(intent);
                }*/
            }
        });

        view.addView(imageLayout, 0);


        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


}
