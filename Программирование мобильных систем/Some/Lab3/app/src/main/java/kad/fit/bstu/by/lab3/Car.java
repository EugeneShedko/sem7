package kad.fit.bstu.by.lab3;

import java.io.Serializable;

public class Car implements Serializable {
    String carBrand;
    String carModel;
    String typeBody;
    String placeOfAssembly;
    String dateOfAssembly;
    String carMileage; //Пробег
    String engineType; //Тип двигателя
    String engineVolume;//Объем двигателя

    private String phone;
    private String email;
    private String link;

    public Car()
    {

    }

    public Car(String carBrand,String carModel,String typeBody,String placeOfAssembly,String dateOfAssembly,String carMileage,
    String engineType,String engineVolume, String phone, String email, String link)
    {
        this.carBrand=carBrand;
        this.carModel=carModel;
        this.typeBody=typeBody;
        this.placeOfAssembly=placeOfAssembly;
        this.dateOfAssembly=dateOfAssembly;
        this.carMileage=carMileage;
        this.engineType=engineType;
        this.engineVolume=engineVolume;
        this.phone = phone;
        this.email = email;
        this.link = link;
    }


    public Car(String carBrand,String carModel,String typeBody,String placeOfAssembly,String dateOfAssembly,String carMileage,
               String engineType,String engineVolume)
    {
        this.carBrand=carBrand;
        this.carModel=carModel;
        this.typeBody=typeBody;
        this.placeOfAssembly=placeOfAssembly;
        this.dateOfAssembly=dateOfAssembly;
        this.carMileage=carMileage;
        this.engineType=engineType;
        this.engineVolume=engineVolume;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String socMedia) {
        this.link = socMedia;
    }




    public String getCarBrand(){return carBrand;}

    public String getCarModel(){return carModel;}

    public String getTypeBody(){return typeBody;}

    public String getPlaceOfAssembly(){return placeOfAssembly;}

    public String getDateOfAssembly(){return dateOfAssembly;}

    public String getCarMileage(){return carMileage;}

    public String getEngineType(){return engineType;}

    public String getEngineVolume(){return engineVolume;}


    public  String toString(){
        return "Марка: " + carBrand + " Модель: " + carModel + " Кузов: " +typeBody
                + " Место сборки: "+placeOfAssembly + " Дата: " +
                dateOfAssembly+ " Пробег: "+carMileage+ " Тип двигателя: "
                +engineType+ " Объем: "+ engineVolume;
    }

}
