package model;

import repository.PortfolioRepository;

import java.io.*;
import java.util.HashMap;

public class Portfolio implements Serializable, PortfolioRepository {

    private Long portfolioId;
    private String portfolioName;
    private Long date = System.currentTimeMillis();
    private HashMap<Long, Double> investment = new HashMap<>();

    public Portfolio(Long portfolioId, String portfolioName, Long date) {
        this.portfolioId = portfolioId;
        this.portfolioName = portfolioName;
        this.date = date;
        this.investment = investment;
    }
    public Portfolio(){}

    public Long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public HashMap<Long, Double> getInvestment() {
        return this.investment;
    }

    public void setInvestment(Long activId, Double sum) {
        this.investment.put(activId, sum);
    }

    @Override
    public void create(Portfolio portfolio) throws IOException {

    }

    @Override
    public Portfolio get(Long id) throws IOException, ClassNotFoundException {
        return null;
    }


    @Override
    public void update(Portfolio portfolio) throws IOException {

    }

    @Override
    public void delete(Portfolio portfolio) throws IOException {

    }

   /* @Override
    public void CreateBag(Bags bag) throws IOException {

    }

    @Override
    public Bags getBag() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(pathPrefix + pathTo);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Bags bags = (Bags) objectInputStream.readObject();
        objectInputStream.close();
        return bags;
    }

    @Override
    public void updateBagsList(Bags bag) throws IOException {
        File f = new File(pathPrefix+pathTo);
        if(f.exists() && !f.isDirectory()) {                  //Проверка на наличие файла
            File file = new File(pathPrefix+pathTo);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(pathPrefix + pathTo, true);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(bag);
        objectOutputStream.close();
    }

    @Override
    public void deleteBag(long id, String name) {

    }*/

}

// Попытка сделать сериализацию и десериализацию через список ArrayList
//    @Override
//    public static void CreateBagsList(ArrayList<Object> List) throws IOException {
//        File f = new File(pathPrefix+pathTo);
//        if(f.exists() && !f.isDirectory()) {                  //Проверка на наличие файла
//            File file = new File(pathPrefix+pathTo);
//        }
//        updateBagsList(List);
//    }
//
//    @Override
//    public Bags getBag() throws IOException, ClassNotFoundException {
//        FileInputStream fileInputStream = new FileInputStream(pathPrefix + pathTo);
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        Bags bags = (Bags) objectInputStream.readObject();
//        objectInputStream.close();
//        return bags;
//    }
//
//    @Override
//    public void updateBagsList(ArrayList<Object> List) throws IOException {
//        FileOutputStream fileOutputStream = new FileOutputStream(pathPrefix + pathTo);
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(List);
//        objectOutputStream.close();
//    }
//
//    @Override
//    public void deleteBag(long id, String name) {
//
//    }



