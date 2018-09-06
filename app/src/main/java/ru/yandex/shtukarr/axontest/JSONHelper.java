package ru.yandex.shtukarr.axontest;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;

import ru.yandex.shtukarr.axontest.model.EmployeesListModel;

public class JSONHelper {

    private String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("Employee.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public EmployeesListModel parseJSON(Context context) {
        Gson gson = new GsonBuilder().create();
        EmployeesListModel responseObject = gson.fromJson(loadJSONFromAsset(context), EmployeesListModel.class);
        return responseObject;
    }
}