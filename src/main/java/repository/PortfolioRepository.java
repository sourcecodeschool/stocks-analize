package repository;

import model.Bags;
import java.io.*;

public interface PortfolioRepository {
    void create(Bags bag) throws IOException;
    Bags get(Long id) throws IOException, ClassNotFoundException;
    void update(Bags bag) throws IOException;
    void delete(Bags bags) throws IOException;
}
