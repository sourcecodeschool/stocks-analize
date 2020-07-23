package repository;

import model.Portfolio;

import java.io.*;

public class EntityManager implements Serializable {
    private static EntityManager entityManager;
    public static EntityManager getInstance() {
        if (entityManager == null) {
            entityManager = new EntityManager();
        }
        return entityManager;
    }

    private EntityManager() {
        portfolioRepository = PortfolioRepositoryImpl.getInstance();
    }

    //список портфелей
    static PortfolioRepository portfolioRepository;

    void createPortfolio(Portfolio portfolio) {
        try {
            portfolioRepository.create(portfolio);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Portfolio get (Long portfolioId){
        Portfolio portfolio = null;
        try {
            portfolio = portfolioRepository.get(portfolioId);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return portfolio;
    }
//    void update(Portfolio portfolio) throws IOException;
//    void delete(Portfolio portfolio) throws IOException;

}