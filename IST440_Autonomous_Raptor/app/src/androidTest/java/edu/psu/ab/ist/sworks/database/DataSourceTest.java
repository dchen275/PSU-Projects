package edu.psu.ab.ist.sworks.database;

import android.content.Context;
import android.util.Log;

import androidx.test.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import javax.inject.Singleton;

import edu.psu.ab.ist.sworks.mission.MissionStatus;

import static org.junit.Assert.*;

public class DataSourceTest {

    @Before
    public void resetSingleton() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field instance = DataSource.class.getDeclaredField("getInstance");
        instance.setAccessible(true);
        instance.set(null, null);
    }
    @Test
    public void theNumberOfStateChangesIsTracked(){
        /*Context appContext = InstrumentationRegistry.getTargetContext();
        DataSource singleton = DataSource.getInstance(appContext);
        singleton.open();*/
        /*singleton.insertToSQL();*/
        /*singleton.close();*/
        // This will fail because the previous test invoked a state change
        /*assertThat(singleton.getNumberOfTimesStateChanged(), is(3));*/
    }
    @Test
    public void getInstance() {
        /*Context appContext = InstrumentationRegistry.getTargetContext();
        try {
            assertSame();
            assertTrue(DataSource.getInstance(appContext));
        } catch (Exception e) {
            Log.e("Battery Level Unit Test", e.getMessage());
        }*/
    }

    @Test
    public void open() {
    }

    @Test
    public void close() {
    }

    @Test
    public void insertToSQL() {
    }

    @Test
    public void queryAllFromATable() {
    }
}