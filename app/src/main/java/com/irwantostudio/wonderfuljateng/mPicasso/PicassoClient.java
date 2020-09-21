package com.irwantostudio.wonderfuljateng.mPicasso;

import android.content.Context;
import android.widget.ImageView;

import com.irwantostudio.wonderfuljateng.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Oclemmy on 4/25/2016 for ProgrammingWizards Channel.
 */
public class PicassoClient {

    public static void downloadImage(Context c, String url, ImageView img)
    {
        if(url != null && url.length()>0)
        {
            Picasso.get().load(url).placeholder(R.drawable.placeholder).into(img);
        }else
        {
            Picasso.get().load(R.drawable.placeholder).into(img);
        }
    }

}
