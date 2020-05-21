package edu.psu.ab.ist.sworks.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import edu.psu.ab.ist.sworks.R;
import edu.psu.ab.ist.sworks.model.DTOServiceNow;

public class DataAdapter extends ArrayAdapter<DTOServiceNow> {

    private static final String TAG = "DataAdapter";

    private Context mContext;
    int mResource;

    public DataAdapter(Context context, int resource, ArrayList<DTOServiceNow> objects){
        super(context,resource,objects);
        try {
            this.mContext = context;
            this.mResource = resource;
        } catch (Exception e) {

        }
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the data
        /*String targetFound = String.valueOf(getItem(position).getU_object_found());
        String x_cord = String.valueOf(getItem(position).getU_x_coordinate());
        String y_cord = String.valueOf(getItem(position).getU_y_coordinate());
        String timestamp = String.valueOf(getItem(position).getU_timestamp());
        String temp = String.valueOf(getItem(position).getU_temperature());
        String pressure = String.valueOf(getItem(position).getU_pressure());
        String humidity = String.valueOf(getItem(position).getU_humidity());*/

        float targetFound = getItem(position).getU_object_found();
        float x_cord = getItem(position).getU_x_coordinate();
        float y_cord = getItem(position).getU_y_coordinate();
        float timestamp = getItem(position).getU_timestamp();
        float temp = getItem(position).getU_temperature();
        float pressure = getItem(position).getU_pressure();
        float humidity = getItem(position).getU_humidity();
        float teamId = getItem(position).getU_team_id();
        float missionId = getItem(position).getU_mission_id();

        //DTOServiceNow data = new DTOServiceNow(y_cord,x_cord,teamId,humidity,temp,targetFound,timestamp,pressure,missionId);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tvTargetFound = (TextView) convertView.findViewById(R.id.targetFound);
        TextView tvX_Cord = (TextView) convertView.findViewById(R.id.x_cordinate);
        TextView tvY_Cord = (TextView) convertView.findViewById(R.id.y_cordinate);
        TextView tvTimestamp = (TextView) convertView.findViewById(R.id.timestamp);
        TextView tvTemp = (TextView) convertView.findViewById(R.id.temp);
        TextView tvPressure = (TextView) convertView.findViewById(R.id.pressure);
        TextView tvHumidity = (TextView) convertView.findViewById(R.id.humidity);

        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date resultDate = new Date((long)timestamp);
        /*LocalDateTime now = LocalDateTime.now();*/

        tvTargetFound.setText((String.valueOf(targetFound).equals("0.0")) ? "Not Found" : "Found");
        tvX_Cord.setText(String.valueOf(x_cord) + " x");
        tvY_Cord.setText(String.valueOf(y_cord) + " y");
        tvTimestamp.setText(dtf.format(resultDate));
        tvTemp.setText(String.valueOf(temp) + " C");
        tvPressure.setText(String.valueOf(pressure) + " hPa");
        tvHumidity.setText(String.valueOf(humidity) + "%");

        return convertView;
    }

}
