package fr.wcs.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ItinerarySearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        final Calendar myCalendar = Calendar.getInstance();
        final EditText editDate= (EditText) findViewById(R.id.edit_date);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            private void updateLabel() {
                String myFormat = "dd/MM/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

                editDate.setText(sdf.format(myCalendar.getTime()));
            }

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        editDate.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick (View v){

                new DatePickerDialog(ItinerarySearchActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        final Button buttonSearch = findViewById(R.id.button_search);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editDeparture = findViewById(R.id.edit_departure);
                EditText editDestination = findViewById(R.id.edit_destination);
                EditText editDate = findViewById(R.id.edit_date);

                String departure = editDeparture.getText().toString();
                String destination = editDestination.getText().toString();
                String date = editDate.getText().toString();

                if ((departure.length() == 0) || (destination.length() == 0)) {
                    Toast.makeText(ItinerarySearchActivity.this, "Please fill your Departure and your Destination", Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent search = new Intent(ItinerarySearchActivity.this, ItineraryListActivity.class);
                    SearchModel parcelable = new SearchModel(departure, destination, date);
                    search.putExtra("Parcelable", parcelable);
                    ItinerarySearchActivity.this.startActivity(search);
                }

            }
        });
    }
}
