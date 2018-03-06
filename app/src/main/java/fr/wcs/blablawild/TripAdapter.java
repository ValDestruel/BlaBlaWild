package fr.wcs.blablawild;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


/**
 * Created by wilder on 05/03/18.
 */

public class TripAdapter extends ArrayAdapter<TripModel> {

    public TripAdapter(Context context, ArrayList<TripModel> trips) { super(context, 0, trips); }

        @Override
        public View getView ( int position, View convertView, ViewGroup parent){
            TripModel trip = getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_trip, parent, false);
            }

                TextView textFirstname = convertView.findViewById(R.id.first_name);
                textFirstname.setText(trip.getFirstname());

                TextView textLastname = convertView.findViewById(R.id.last_name);
                textLastname.setText(trip.getLastname());

                TextView textDate = convertView.findViewById(R.id.date_heure);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");
                String dateFormat = sdf.format(trip.getDate());
                String date = dateFormat + "PM";
                textDate.setText(date);

                TextView textPrice = convertView.findViewById(R.id.price);
                String stringPrice = String.valueOf(trip.getPrice());
                textPrice.setText("$" + stringPrice);

                return convertView;

        }
    }