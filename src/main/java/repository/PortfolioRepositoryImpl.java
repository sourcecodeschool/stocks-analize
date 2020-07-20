package repository;

import model.Portfolio;

import java.io.*;
import java.util.List;

public class PortfolioRepositoryImpl implements PortfolioRepository {

    private static PortfolioRepository repository;
    static final String pathPrefix = System.getProperty("user.home") + "/db" ;
    static final String pathTo = "Portfolio.dat";

    public static PortfolioRepository getInstance() {
        if (repository == null) {
            repository = new PortfolioRepositoryImpl();
        }
        return repository;
    }

    private PortfolioRepositoryImpl() {
    }

    @Override
    public void create(Portfolio portfolio) throws IOException {
        EntityManager.portfolioList.add(portfolio);
        //serialize this EntityManager.bags
    }

    @Override
    public Portfolio get(Long portfolioId) throws IOException, ClassNotFoundException {

return EntityManager.portfolioList.get(Math.toIntExact(portfolioId));
    }

    @Override
    public void update(Portfolio portfolio) throws IOException {
        EntityManager.portfolioList.remove(portfolio);
        EntityManager.portfolioList.add(portfolio);
        //serialize this EntityManager.portfolioList
        serializeList(EntityManager.portfolioList);
    }

    @Override
    public void delete(Portfolio portfolio) throws IOException {

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
        List<Portfolio> portfolioList = (List<Portfolio>) objectInputStream.readObject();
        objectInputStream.close();
        return portfolioList;
    }
}
