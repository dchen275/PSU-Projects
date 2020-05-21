package edu.psu.ab.ist.sworks.model;

import android.provider.BaseColumns;

public class ServiceNowContract {

    private ServiceNowContract() {}

    /* Inner class that defines the table contents */
    public static class SensorEntry implements BaseColumns {
        public static final String TABLE_NAME = "mission_data";
        public static final String COLUMN_MISSION_ID = "misison_id";
        public static final String COLUMN_TEAM_ID = "team_id";
        public static final String COLUMN_NAME_ACC_X = "acc_x";
        public static final String COLUMN_NAME_ACC_Y = "acc_y";
        public static final String COLUMN_TARGET_FOUND = "target_found";
        public static final String COLUMN_NAME_PRESSURE = "pressure";
        public static final String COLUMN_NAME_RELATIVE_HUMIDITY = "humidity";
        public static final String COLUMN_NAME_TEMPERATURE = "temperature";
        public static final String COLUMN_DATETIME = "datetime";
    }

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + SensorEntry.TABLE_NAME + " (" +
                    SensorEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    SensorEntry.COLUMN_MISSION_ID + " REAL," +
                    SensorEntry.COLUMN_TEAM_ID + " REAL," +
                    SensorEntry.COLUMN_NAME_PRESSURE + " REAL,"+
                    SensorEntry.COLUMN_NAME_RELATIVE_HUMIDITY + " REAL," +
                    SensorEntry.COLUMN_NAME_TEMPERATURE + " REAL," +
                    SensorEntry.COLUMN_TARGET_FOUND + " REAL," +
                    SensorEntry.COLUMN_DATETIME + " REAL," +
                    SensorEntry.COLUMN_NAME_ACC_X + " REAL," +
                    SensorEntry.COLUMN_NAME_ACC_Y + " REAL )"
            ;


    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + SensorEntry.TABLE_NAME;

}


