package fr.wcs.blablawild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class VehicleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_activity);

        Spinner spinner = findViewById(R.id.auto_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                final Button buttonSend = findViewById(R.id.button_Send);
                final EditText editBrand = findViewById(R.id.editText_Brand);
                final EditText editModel = findViewById(R.id.editText_Model);
                final EditText editKilometers = findViewById(R.id.editText_Kilometers);
                final EditText editHours = findViewById(R.id.editText_Hours);
                final EditText editSpeed = findViewById(R.id.editText_Speed);

                switch (pos) {
                    case 0:
                        editBrand.setVisibility(View.VISIBLE);
                        editModel.setVisibility(View.VISIBLE);
                        editKilometers.setVisibility(View.GONE);
                        editHours.setVisibility(View.GONE);
                        editSpeed.setVisibility(View.GONE);
                        buttonSend.setEnabled(false);
                        break;

                    case 1:
                        editBrand.setVisibility(View.VISIBLE);
                        editModel.setVisibility(View.VISIBLE);
                        editKilometers.setVisibility(View.VISIBLE);
                        editHours.setVisibility(View.GONE);
                        editSpeed.setVisibility(View.GONE);
                        buttonSend.setEnabled(true);

                        buttonSend.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {

                                String brandString = editBrand.getText().toString();
                                String modelString = editModel.getText().toString();
                                String kilometers = editKilometers.getText().toString();
                                int kilometersValue = Integer.valueOf(kilometers);

                                VehicleCar carResult = new VehicleCar(brandString, modelString, kilometersValue);

                                Toast.makeText(VehicleActivity.this, carResult.getDescription(), Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;

                    case 2:
                        editBrand.setVisibility(View.VISIBLE);
                        editModel.setVisibility(View.VISIBLE);
                        editKilometers.setVisibility(View.GONE);
                        editHours.setVisibility(View.VISIBLE);
                        editSpeed.setVisibility(View.GONE);
                        buttonSend.setEnabled(true);

                        buttonSend.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {

                                String brandString = editBrand.getText().toString();
                                String modelString = editModel.getText().toString();
                                String hours = editHours.getText().toString();
                                int hoursValue = Integer.valueOf(hours);

                                VehicleBoat boatResult = new VehicleBoat(brandString, modelString, hoursValue);

                                Toast.makeText(VehicleActivity.this, boatResult.getDescription(), Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;

                    case 3:
                        editBrand.setVisibility(View.VISIBLE);
                        editModel.setVisibility(View.VISIBLE);
                        editKilometers.setVisibility(View.GONE);
                        editHours.setVisibility(View.GONE);
                        editSpeed.setVisibility(View.VISIBLE);
                        buttonSend.setEnabled(true);

                        buttonSend.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {

                                String brandString = editBrand.getText().toString();
                                String modelString = editModel.getText().toString();
                                String speed = editSpeed.getText().toString();
                                int speedValue = Integer.valueOf(speed);

                                VehiclePlane boatResult = new VehiclePlane(brandString, modelString, speedValue);

                                Toast.makeText(VehicleActivity.this, boatResult.getDescription(), Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
