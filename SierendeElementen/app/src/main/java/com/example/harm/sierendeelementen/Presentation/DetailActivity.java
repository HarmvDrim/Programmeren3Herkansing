package com.example.harm.sierendeelementen.Presentation;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.harm.sierendeelementen.Domain.Element;
import com.example.harm.sierendeelementen.R;

public class DetailActivity extends AppCompatActivity {
    private Element element;
    private TextView titleObject;
    private TextView geoLigging;
    private TextView naamKunstenaar;
    private TextView beschrijvingObject;
    private TextView beschrijvingMateriaal;
    private TextView beschrijvingOndergrond;
    private ImageView imageObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Log.e("Test", "onCreate DetailActivity aangeroepen");

        Intent i = getIntent();
        element = (Element) i.getSerializableExtra("Element");

        titleObject = findViewById(R.id.detailTitel_id);
        titleObject.setText(element.getNaamObject());
        titleObject.setTextSize(15);
        titleObject.setTypeface(null, Typeface.BOLD);

        geoLigging = findViewById(R.id.detailGeoLigging_id);
        geoLigging.setText(element.getGeoLigging());

        naamKunstenaar = findViewById(R.id.detailKText_id);
        naamKunstenaar.setText(element.getKunstenaar());

        beschrijvingObject = findViewById(R.id.detailBText_id);
        beschrijvingObject.setText(element.getBeschrijving());

        beschrijvingMateriaal = findViewById(R.id.detailMText_id);
        beschrijvingMateriaal.setText(element.getMateriaal());

        beschrijvingOndergrond = findViewById(R.id.detailOText_id);
        beschrijvingOndergrond.setText(element.getOndergrond());

        imageObject = findViewById(R.id.detailImage_id);
        new ImageLoader(imageObject).execute(element.getImageElement());

    }
}
