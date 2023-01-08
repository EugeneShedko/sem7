package fit.bstu.by.myapplication;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Serializer {

    private static String curDir = "/data/data/fit.bstu.by.myapplication/files/";

    public static boolean jsonSerialize(ArrayList<Recipe> booksList, String fileName) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            FileOutputStream stream = new FileOutputStream(curDir + fileName);
            mapper.writeValue(stream, booksList);
            return true;
        } catch (IOException e) {
            Log.d("ERROR! SER LIST", e.getMessage());
            return false;
        }
    }

    public static ArrayList<Recipe> jsonDeserializer(String fileName)
    {
        ArrayList<Recipe> list = null;
        try {
            FileInputStream stream = new FileInputStream(curDir + fileName);
            ObjectMapper mapper    = new ObjectMapper();
            list                   = mapper.readValue(stream, new TypeReference<ArrayList<Recipe>>() {});
        }catch (IOException ex){
            Log.d("ERROR DES BUNDLE", ex.getMessage());
        }
        return list;

    }

    public static void jsonSerialize(Bundle activityState, String fileName) {
        try {
            FileOutputStream stream = new FileOutputStream(curDir + fileName);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(stream, activityState);
        } catch (IOException e) {
            Log.d("ERROR! SER BUNDLE", e.getMessage());
        }
    }

    //Возможно как-то сделать общую десириализацию -> пока что не нужно, не будем делать!
    //Возможно нужно будет проверять на существование файла, иначе может выбивать ошибку -> будет стоять в try catch
    public static Bundle jsonDeserialize(String fileName){
        Bundle bundle = null;
        try {
            FileInputStream stream = new FileInputStream(curDir + fileName);
            ObjectMapper mapper    = new ObjectMapper();
            bundle                 = mapper.readValue(stream, Bundle.class);
        }catch (IOException ex){
            Log.d("ERROR DES BUNDLE", ex.getMessage());
        }
        return bundle;
    }
}