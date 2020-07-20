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

    public void createPortfolio(Portfolio portfolio) {
        try {
            portfolioRepository.create(portfolio);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    Portfolio get(Long id) throws IOException, ClassNotFoundException;
//    void update(Portfolio portfolio) throws IOException;
//    void delete(Portfolio portfolio) throws IOException;

}