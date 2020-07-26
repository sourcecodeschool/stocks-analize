package repository;

import model.Portfolio;

import java.io.*;
import java.nio.file.Files;
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
        File f = new File(pathPrefix+pathTo);
        if(f.isFile()) { //проверка есть ли файл
            if (f.length() == 0){ //проверка пустой ли файл
                return;
            }
            else {
                try {
                    portfolioList = deSerializeList();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void create(Portfolio portfolio) throws IOException, ClassNotFoundException {
        File f = new File(pathPrefix+pathTo);
        if(f.isFile()) { //проверка есть ли файл
            if (f.length() == 0){ //проверка пустой ли файл
                update(portfolio);
            }
            else {
                portfolioList = deSerializeList();
                update(portfolio);
            }
        }
        else {
            f.createNewFile();
            update(portfolio);
        }
    }

    @Override
    public Portfolio get(Long portfolioId) throws IOException, ClassNotFoundException {
        Portfolio portfolio = null;
        for (Portfolio temp : portfolioList) {
            if (portfolioId.equals(temp.getPortfolioId())){
                portfolio = temp;
            }
        }
        return portfolio;
    }

    @Override
    public void update(Portfolio portfolio) throws IOException {
        File f = new File(pathPrefix+pathTo);
        if (f.length() == 0){ //если файл пустой то добавляем портфель и сериализуем
            portfolioList.add(portfolio);
            serializeList(portfolioList);
        }
        else {
            for (Portfolio temp : portfolioList){            //Проверка на наличие портфеля с одинаковым ID, если портфель есть, возврат, если нет, то добавляем
                if (portfolio.getPortfolioId().equals(temp.getPortfolioId())){
                    System.out.println("Портфель с таким ID уже есть");
                    return;
                }
            }
            portfolioList.add(portfolio);
            serializeList(portfolioList);
        }
    }

    @Override
    public void delete(Portfolio portfolio) throws IOException {
        for (Portfolio temp : portfolioList){            //Проверка на наличие портфеля с одинаковым ID, если портфель есть, то удаляем, если нет, то возврат с сообщением
            if (portfolio.getPortfolioId().equals(temp.getPortfolioId())){
                portfolioList.remove(portfolio.getPortfolioId().intValue());
                serializeList(portfolioList);
                return;
            }
        }
        System.out.println("Портфель не найден");
        return;
    }

    @Override
    public List<Portfolio> getPortfolioList() throws IOException {
        for(Portfolio portfolio : portfolioList) {
            System.out.println(portfolio.getPortfolioName().toString());
        }
        return portfolioList;
    }

    private void serializeList(List<Portfolio> portfolioList) throws IOException {
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
