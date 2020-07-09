package repository;

import model.ListBags;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    static final String pathPrefix = System.getenv("user.dir") + "/db" ;
    static final String pathTo = "bag.dat";

    //CRUD create update delete get list

    //Проверить есть ли файл вообще Path

    public List<String> getBagsList() {
        return new ArrayList<>();
    }

    public void updateBagsList(List<ListBags> listBags) {

    }

    //Использовать файловую сериализацию
    //ПортфельРепозиторий
    //АктивнаяЕдиницаРекпозиторий
    //Файл и путь к нему

}
