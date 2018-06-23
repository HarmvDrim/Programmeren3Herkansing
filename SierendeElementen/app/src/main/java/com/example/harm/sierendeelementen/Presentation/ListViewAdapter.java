package com.example.harm.sierendeelementen.Presentation;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.harm.sierendeelementen.Domain.Element;
import com.example.harm.sierendeelementen.R;

import java.util.ArrayList;

/**
 * Created by harm on 23-6-2018.
 */

public class ListViewAdapter extends ArrayAdapter<Element> {

    public ListViewAdapter(@NonNull Context context, ArrayList<Element> elements) {
        super(context, 0,elements);
        Log.e("Test", "ListViewAdapter aangeroepen");
    }
    public View getView(int position, View convertView, ViewGroup parent){
        Log.e("Test", "getView aangeroepen");
        Element element = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.lv_row,parent,false);
        }

        TextView elementName = convertView.findViewById(R.id.titelElementTextView_id);
        elementName.setText(element.getNaamObject());
        elementName.setTextSize(15);
        elementName.setTypeface(null,Typeface.BOLD);

        TextView geoLigging = convertView.findViewById(R.id.geoLiggingTextView_id);
        geoLigging.setText(element.getGeoLigging());

        TextView idNummer = convertView.findViewById(R.id.idNummerTextView_id);
        idNummer.setText(element.getIdNummer());

        ImageView elementImage = convertView.findViewById(R.id.imageImageView_id);
        new ImageLoader(elementImage).execute(element.getImageElement());
        return convertView;
    }
}
