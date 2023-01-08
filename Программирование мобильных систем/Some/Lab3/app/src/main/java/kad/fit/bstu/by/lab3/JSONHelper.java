package kad.fit.bstu.by.lab3;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class JSONHelper {

    private static final String FILE_NAME = "car.json";
    static File  file = new File(FILE_NAME);
    static boolean exportToJSON(Context context, List<Car> dataList) {

        Gson gson = new Gson();
        DataItems dataItems = new DataItems();
        dataItems.setCars(dataList);
        String jsonString = gson.toJson(dataItems);

        try(FileOutputStream fileOutputStream =
                    context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE)) {
            fileOutputStream.write(jsonString.getBytes());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    static List<Car> importFromJSON(Context context) {

        try(FileInputStream fileInputStream = context.openFileInput(FILE_NAME);
            InputStreamReader streamReader = new InputStreamReader(fileInputStream)){

            Gson gson = new Gson();
            DataItems dataItems = gson.fromJson(streamReader, DataItems.class);
            return  dataItems.getCars();
        }
        catch (IOException ex){
            Log.d("2222","2222");
            ex.printStackTrace();
        }

        return null;
    }

    private static class DataItems {
        private List<Car> cars;

        List<Car> getCars() {
            return cars;
        }
        void setCars(List<Car> cars) {
            this.cars = cars;
        }
    }
}
