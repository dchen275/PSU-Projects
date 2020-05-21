package edu.psu.ab.ist.sworks;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

import edu.psu.ab.ist.sworks.model.DTOServiceNow;

public class ServiceNow extends AsyncTask<String, Void, String> {
    //CloudIntegration
    //IST440spring2019
    private final String USER_AGENT = "Mozilla/5.0";
    private final String user = "dkc5318@psu.edu";
    private final String pwd = "123QWERT45";
    private final String urlString = "https://emplkasperpsu2.service-now.com/api/now/table/u_team1_raptors";
    private URL url = null;

    private final DTOServiceNow dtoServiceNow;

    public ServiceNow (DTOServiceNow dtoServiceNow) {
        this.dtoServiceNow = dtoServiceNow;
    }
    @Override
    protected String doInBackground(String... params) {
        try {
            url = new URL(urlString);

            //GET
            //getData();
            /*HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);


            Authenticator.setDefault(new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, pwd.toCharArray());
                }
            });


            int responseCode = con.getResponseCode();
            System.out.println("Sending get request : "+ url);
            System.out.println("Response code : "+ responseCode);

            // Reading response from input Stream
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String output;
            StringBuffer response = new StringBuffer();

            while ((output = in.readLine()) != null) {
                response.append(output);
            }
            in.close();
            con.disconnect();*/


            // FINISHED GET


            //printing result from response
            //   System.out.println(response.toString());


            // POST

            HttpURLConnection con2 = (HttpURLConnection) url.openConnection();

            con2.setRequestMethod("POST");
            con2.setRequestProperty("User-Agent", USER_AGENT);
            con2.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con2.setRequestProperty("Content-Type", "application/json");
            // This is hard coded
            //String postJsonData = "{\"u_name\":\"Chris Valko\",\"u_age\":\"27\",\"u_email\":\"cjv5110@psu.edu\"}";
            // Send post request
            String postJsonData = new Gson().toJson(dtoServiceNow);
            con2.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con2.getOutputStream());
            wr.writeBytes(postJsonData);
            wr.flush();
            wr.close();
            /*responseCode = con2.getResponseCode();
            System.out.println("nSending 'POST' request to URL : " + url);
            System.out.println("Post Data : " + *//*postJsonData*//*response.toString());
            System.out.println("Response Code : " + responseCode);

            in = new BufferedReader(new InputStreamReader(con2.getInputStream()));
            response = new StringBuffer();

            while ((output = in.readLine()) != null) {
                response.append(output);
            }
            in.close();
            con2.disconnect();
*/
            // FINISHED POST


            //printing result from response
            //System.out.println(response.toString());

            // POST
            // Parameters needs to be set beforehand
            //postData();


        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;
    }

    /*private void authenticator() {
        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pwd.toCharArray());
            }
        });

    }*/

    /*private StringBuffer getData() {
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            authenticator();

            // Can be used for Logging
            int responseCode = con.getResponseCode();
            *//*System.out.println("Sending get request : " + url);
            System.out.println("Response code : " + responseCode);*//*

            // Reading response from input Stream
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String output;
            StringBuffer response = new StringBuffer();

            while ((output = in.readLine()) != null) {
                response.append(output);
            }
            in.close();
            con.disconnect();

            return response;

        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
            return null;
        }
    }


    private boolean postData() {
        try {
            HttpURLConnection con2 = (HttpURLConnection) url.openConnection();

            con2.setRequestMethod("POST");
            con2.setRequestProperty("User-Agent", USER_AGENT);
            con2.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con2.setRequestProperty("Content-Type", "application/json");

            // Assign Data in a String format before posting!!!
            // This is hard coded
            //String postJsonData = "{\"u_name\":\"Chris Valko\",\"u_age\":\"27\",\"u_email\":\"cjv5110@psu.edu\"}";
            // Send post request
            String postJsonData = new Gson().toJson(dtoServiceNow);
            con2.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con2.getOutputStream());
            wr.writeBytes(postJsonData);
            wr.flush();
            wr.close();

            return true;

        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
            return false;
        }
    }*/

    @Override
    protected void onPostExecute(String result) {
        //update your ui here
    }

    @Override
    protected void onPreExecute() {
        //do any code before exec
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        //If you want to update a progress bar ..do it here
    }
}
