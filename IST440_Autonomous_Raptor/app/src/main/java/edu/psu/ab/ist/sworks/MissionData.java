package edu.psu.ab.ist.sworks;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
/*import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;*/

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import edu.psu.ab.ist.sworks.database.DBHelper;
import edu.psu.ab.ist.sworks.database.DataAdapter;
import edu.psu.ab.ist.sworks.database.DatabaseSetup;
import edu.psu.ab.ist.sworks.model.DTOServiceNow;

public class MissionData extends AppCompatActivity {
    private ListView mListView;
    private static final String TAG = "ListDataActivity";
    DBHelper mDatabaseHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_data);

        mListView = (ListView) findViewById(R.id.listview);

        mDatabaseHelper = (DBHelper) getIntent().getSerializableExtra("DATABASE");
        populateListView();
    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        //get the data and append to a list
        List<DTOServiceNow> data = mDatabaseHelper.getData();
        ArrayList<DTOServiceNow> listData = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            listData.add(data.get(i));
        }

        DataAdapter adapter = new DataAdapter(this, R.layout.adapter_view_layout, listData);
        mListView.setAdapter(adapter);

    }

    public void openBlockChain(View view) {
        Intent intent = new Intent(this, BlockChain.class);
        startActivity(intent);
    }

}