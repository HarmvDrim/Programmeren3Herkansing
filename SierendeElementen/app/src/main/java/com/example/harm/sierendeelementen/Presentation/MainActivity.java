package com.example.harm.sierendeelementen.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.harm.sierendeelementen.Domain.Element;
import com.example.harm.sierendeelementen.R;
import com.example.harm.sierendeelementen.Service.ElementAPIConnector;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Element> elementList;
    private ArrayAdapter<Element> lvAdapter;
    private ListView listView;

    public static String ELEMENT = "Element";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("Test", "onCreate MainActivity aangeroepen");
        elementList = new ArrayList<>();

        ElementAPIConnector connector = new ElementAPIConnector(this);
        String[] params = {"https://services7.arcgis.com/21GdwfcLrnTpiju8/arcgis/rest/services/Sierende_elementen/FeatureServer/0/query?where=1%3D1&outFields=*&outSR=4326&f=json"};
        connector.execute(params);

        listView = findViewById(R.id.listView_id);

        lvAdapter = new ListViewAdapter(this,elementList);

        listView.setAdapter(lvAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                //geeft het item van het getal mee aan de detailactivity onder de naam ELEMENT
                intent.putExtra(ELEMENT,elementList.get(i));
                startActivity(intent);
            }
        });
    }

    public void addElement(Element element){
        Log.e("Test", "addElement aangeroepen");
        elementList.add(element);
        lvAdapter.notifyDataSetChanged();
    }
}
