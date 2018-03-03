package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ItineraryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        Intent reception = getIntent();
        String reception1 = reception.getStringExtra("test1");
        String reception2 = reception.getStringExtra("test2");
        setTitle(reception1 + " >> " + reception2);
    }
}
