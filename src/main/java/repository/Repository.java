package repository;

import model.Portfolio;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    static final String pathPrefix = System.getenv("user.dir") + "/db" ;
    static final String pathTo = "bag.dat";

    //CRUD create update delete get list

    //Проверить есть ли файл вообще Path

    public List<String> getPortfolio() {
        return new ArrayList<>();
    }

    public void updatePortfolio(List<Portfolio> portfolios) {

    }

    //Использовать файловую сериализацию
    //ПортфельРепозиторий
    //АктивнаяЕдиницаРекпозиторий
    //Файл и путь к нему

}
