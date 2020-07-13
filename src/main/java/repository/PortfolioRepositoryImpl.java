package repository;

import model.Bags;

import java.io.IOException;
import java.util.List;

public class PortfolioRepositoryImpl implements PortfolioRepository {

    private static PortfolioRepository repository;

    public static PortfolioRepository getInstance() {
        if (repository == null) {
            repository = new PortfolioRepositoryImpl();
        }
        return repository;
    }

    private PortfolioRepositoryImpl() {
    }

    @Override
    public void create(Bags bag) throws IOException {
        EntityManager.bags.add(bag);
        //serialize this EntityManager.bags
    }

    @Override
    public Bags get(Long id) throws IOException, ClassNotFoundException {
        return null;//EntityManager.bags.stream().filter()....;
    }

    @Override
    public void update(Bags bag) throws IOException {
        EntityManager.bags.remove(bag);
        EntityManager.bags.add(bag);
        //serialize this EntityManager.bags
        serializeList(EntityManager.bags);
    }

    @Override
    public void delete(Bags bags) throws IOException {

    }

    private void serializeList(List<Bags> bagsList) {
    }

}
