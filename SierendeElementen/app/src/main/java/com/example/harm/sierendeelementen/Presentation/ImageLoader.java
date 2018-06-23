package com.example.harm.sierendeelementen.Presentation;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by harm on 23-6-2018.
 */

public class ImageLoader extends AsyncTask<String, Void, Bitmap> {
    private ImageView imageView;

    public ImageLoader(ImageView imageView) {
        Log.e("Test", "ImageLoader aangeroepen");
        this.imageView = imageView;
    }

    protected Bitmap doInBackground(String... urls) {
        Log.e("Test", "doInBackground ImageLoader aangeroepen");
        String imageURL = urls[0];
        Bitmap bitmap = null;
        try {
            InputStream in = new java.net.URL(imageURL).openStream();
            bitmap = BitmapFactory.decodeStream(in);

        } catch (Exception e) {
            Log.e("Error Message", e.getMessage());
            e.printStackTrace();
        }
        return bitmap;
    }

    protected void onPostExecute(Bitmap result) {
        Log.e("Test", "onPostExecute ImageLoader aangeroepen");
        imageView.setImageBitmap(result);
    }
}
