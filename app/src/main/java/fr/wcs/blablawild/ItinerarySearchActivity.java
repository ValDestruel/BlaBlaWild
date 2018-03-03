package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ItinerarySearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        final Button buttonSearch = findViewById(R.id.button_search);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editDeparture = findViewById(R.id.edit_departure);
                EditText editDestination = findViewById(R.id.edit_destination);

                String departure = editDeparture.getText().toString();
                String destination = editDestination.getText().toString();

                if ((departure.length() == 0) || (destination.length() == 0)) {
                    Toast.makeText(ItinerarySearchActivity.this, "Please fill your Departure and your Destination", Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent search = new Intent(ItinerarySearchActivity.this, ItineraryListActivity.class);
                    search.putExtra("test1", departure);
                    search.putExtra("test2", destination);
                    ItinerarySearchActivity.this.startActivity(search);
                }

            }
        });



    }
}
