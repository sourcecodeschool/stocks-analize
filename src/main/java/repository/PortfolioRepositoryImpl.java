package repository;

import model.Portfolio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PortfolioRepositoryImpl implements PortfolioRepository {

    private static PortfolioRepository repository;
    static final String pathPrefix = System.getProperty("user.home") + "/db" ;
    static final String pathTo = "Portfolio.dat";
    public static List<Portfolio> portfolioList = new ArrayList<>();

    public static PortfolioRepository getInstance() {
        if (repository == null) {
            repository = new PortfolioRepositoryImpl();
        }
        return repository;
    }

    private PortfolioRepositoryImpl() {
        //deserialize
    }

    @Override
    public void create(Portfolio portfolio) throws IOException {
        //modify portfolioList
        serializeList(portfolioList);
    }

    @Override
    public Portfolio get(Long portfolioId) throws IOException, ClassNotFoundException {
        //compare List with file
        return null;//portfolioList.stream().filter()
    }

    @Override
    public void update(Portfolio portfolio) throws IOException {
        //modify portfolioList
        serializeList(portfolioList);
    }

    @Override
    public void delete(Portfolio portfolio) throws IOException {
        //modify portfolioList
        serializeList(portfolioList);
    }

    private void serializeList(List<Portfolio> portfolioList) throws IOException {
        File f = new File(pathPrefix+pathTo);
        if(f.exists() && !f.isDirectory()) {                  //Проверка на наличие файла
            File file = new File(pathPrefix+pathTo);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(pathPrefix + pathTo);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(portfolioList);
        objectOutputStream.close();
    }

    public List<Portfolio> deSerializeList() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(pathPrefix + pathTo);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object object = objectInputStream.readObject();
        objectInputStream.close();
        List<Portfolio> portfolioList = null;
        if (object instanceof List) {
            try {
                portfolioList = (List<Portfolio>) object;
            } catch (ClassCastException e) {
                return null;
            }
        }
        return portfolioList;
    }
}
