package repository;

import model.Bags;

import java.io.*;
import java.util.ArrayList;

public interface Repository {

    static final String pathPrefix = System.getProperty("user.home") + "/db" ;
    static final String pathTo = "bag.dat";

    //CRUD create update delete get list
    //Проверить есть ли файл вообще Path
    //Использовать файловую сериализацию
    //ПортфельРепозиторий
    //АктивнаяЕдиницаРекпозиторий
    //Файл и путь к нему
    void CreateBag(Bags bag) throws IOException;
    public Object getBag() throws IOException, ClassNotFoundException;
    public void updateBagsList(Bags bag) throws IOException;
    public void deleteBag (long id, String name);



    // Попытка сделать сериализацию и десериализацию через список ArrayList
//    void CreateBagsList(ArrayList<Object> List) throws IOException;
//    public Object getBag() throws IOException, ClassNotFoundException;
//    public void updateBagsList(ArrayList<Object> List) throws IOException;
//    public void deleteBag (long id, String name);

}
