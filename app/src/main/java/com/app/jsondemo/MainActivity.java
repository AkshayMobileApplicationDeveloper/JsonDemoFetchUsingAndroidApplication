package com.app.jsondemo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        step 1: we create an assets folder and json file, you can copy and paste also
         */

        /*
        Step 2: load json file
         */

        /*
        step 3: Call loadJson
         */
        loadJsonFile();
    }

    private void loadJsonFile() {
        try {
            /*
            file name should be the same as in the assets folder with extension json
             */

            InputStream inputStream = getAssets().open("data.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            /*
            now we will fetch the json file
             */

            String json;
            int max;
            int age;
            String name;
            String country;

            json = new String(buffer, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(json);
            max = jsonArray.length();

            /*
            now fetch each json object
             */
            for (int i = 0; i < max; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                /*
                name, age, country
                 */
                name = jsonObject.getString("name");
                country = jsonObject.getString("country");
                age = jsonObject.getInt("age");

                /*
                we will log value
                 */
                Log.e("TAG", "loadJsonFile: Name: " + name + " Country: " + country + " Age: " + age);
            }
        } catch (Exception e) {
            Log.e("TAG", "loadJsonFile: error ", e);
        }
    }
}
