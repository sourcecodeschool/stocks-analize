package repository;
import model.Bags;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EntityManager implements Serializable {

    private static EntityManager entityManager;
    public static EntityManager getInstance() {
        if (entityManager == null) {
            entityManager = new EntityManager();
        }
        return entityManager;
    }

    private EntityManager() {
    }

    static final String pathPrefix = System.getProperty("user.home") + "/db" ;
    static final String pathTo = "bag.dat";

    //список портфелей
    static List<Bags> bags = new ArrayList<>();
    static PortfolioRepository portfolioRepository = PortfolioRepositoryImpl.getInstance();
    //...
    public void GetBagsList() {

// Попытка работать с файлом данных как с текстовым файлом
//    Bags.Bags bagList[] = new Bags.Bags[3];{
//        try {
//            InputStream is = new FileInputStream(Bags.Bags.pathPrefix + Bags.Bags.pathTo);
//            BufferedInputStream bis = new BufferedInputStream(is, 100_000);
//            ObjectInputStream ois = new ObjectInputStream(bis);
//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 4; j++) {
//                    String line = Files.readAllLines(Paths.get(Bags.Bags.pathPrefix + Bags.Bags.pathTo)).get(j);
//                    Files.readAllLines(Paths.get(Bags.Bags.pathPrefix + Bags.Bags.pathTo)).get(j);
//                }
//                bagList[i] = (Bags.Bags) ois.readObject();
//                System.out.println(bagList[i].getPortfolioName().toString());
//            };}
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }}}
//список активов
//нужен для сохранения в репозиторий
    }

    public void updateBag(Bags bags) throws IOException {
        portfolioRepository.update(bags);
    }

}