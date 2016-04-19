package media.sigma.getit.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import media.sigma.getit.R;

/**
 * Created by avikal on 4/19/2016.
 */
public class PopulerClass extends Fragment
{
    Context context;
    int valuePack;

    public PopulerClass(Context context,int valuePack)
    {
        this.context = context;
        this.valuePack = valuePack;
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.buy_layout,container,false);
        return  rootView;
    }
}
