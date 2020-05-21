package edu.psu.ab.ist.sworks.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.psu.ab.ist.sworks.model.ServiceNowContract;
import edu.psu.ab.ist.sworks.model.DTOServiceNow;

public class DBHelper extends SQLiteOpenHelper implements Serializable {
    private static final String DB_NAME = "Rover.db";
    private static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ServiceNowContract.SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ServiceNowContract.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public boolean insert(DTOServiceNow data) {

        ContentValues contentvalues = new ContentValues();
        contentvalues.put(ServiceNowContract.SensorEntry.COLUMN_MISSION_ID, data.getU_mission_id());
        contentvalues.put(ServiceNowContract.SensorEntry.COLUMN_TEAM_ID, data.getU_team_id());
        contentvalues.put(ServiceNowContract.SensorEntry.COLUMN_NAME_PRESSURE, data.getU_pressure());
        contentvalues.put(ServiceNowContract.SensorEntry.COLUMN_NAME_TEMPERATURE, data.getU_temperature());
        contentvalues.put(ServiceNowContract.SensorEntry.COLUMN_NAME_RELATIVE_HUMIDITY, data.getU_humidity());
        contentvalues.put(ServiceNowContract.SensorEntry.COLUMN_NAME_ACC_X, data.getU_x_coordinate());
        contentvalues.put(ServiceNowContract.SensorEntry.COLUMN_NAME_ACC_Y, data.getU_y_coordinate());
        contentvalues.put(ServiceNowContract.SensorEntry.COLUMN_TARGET_FOUND, data.getU_object_found());
        contentvalues.put(ServiceNowContract.SensorEntry.COLUMN_DATETIME, data.getU_timestamp());

        SQLiteDatabase db = getWritableDatabase();
        long result = db.insert(ServiceNowContract.SensorEntry.TABLE_NAME, null, contentvalues);

        //if date as inserted incorrectly it will return -1
        return result != -1;
    }

    /**
     * Returns all the data from database
     * @return
     */
    /*public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLENAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }*/

    public List<DTOServiceNow> getData(){
        List<DTOServiceNow> result = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        try{
            Cursor cursor = db.query(ServiceNowContract.SensorEntry.TABLE_NAME, null,null,null, null, null, null);
            while (cursor.moveToNext()) {
                DTOServiceNow dto = new DTOServiceNow(/*0,0,0,0,0,0,0,0,0*/);
                dto.setU_x_coordinate(cursor.getFloat(cursor.getColumnIndex(ServiceNowContract.SensorEntry.COLUMN_NAME_ACC_X)));
                dto.setU_y_coordinate(cursor.getFloat(cursor.getColumnIndex(ServiceNowContract.SensorEntry.COLUMN_NAME_ACC_Y)));
                dto.setU_humidity(cursor.getFloat(cursor.getColumnIndex(ServiceNowContract.SensorEntry.COLUMN_NAME_RELATIVE_HUMIDITY)));
                dto.setU_mission_id(cursor.getFloat(cursor.getColumnIndex(ServiceNowContract.SensorEntry.COLUMN_MISSION_ID)));
                dto.setU_object_found(cursor.getFloat(cursor.getColumnIndex(ServiceNowContract.SensorEntry.COLUMN_TARGET_FOUND)));
                dto.setU_pressure(cursor.getFloat(cursor.getColumnIndex(ServiceNowContract.SensorEntry.COLUMN_NAME_PRESSURE)));
                dto.setU_team_id(cursor.getFloat(cursor.getColumnIndex(ServiceNowContract.SensorEntry.COLUMN_TEAM_ID)));
                dto.setU_temperature(cursor.getFloat(cursor.getColumnIndex(ServiceNowContract.SensorEntry.COLUMN_NAME_TEMPERATURE)));
                dto.setU_timestamp(cursor.getFloat(cursor.getColumnIndex(ServiceNowContract.SensorEntry.COLUMN_DATETIME)));
                result.add(dto);
            }
            cursor.close();
        } finally {
            db.close();
        }
        return result;
    }
}