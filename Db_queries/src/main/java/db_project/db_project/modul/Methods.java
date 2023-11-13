package db_project.db_project.modul;
import db_project.db_project.entities.Bewertung;
import db_project.db_project.entities.Product;
import db_project.db_project.entities.Verfügbarkeit;

import java.util.List;
//Interface mit allen Methoden
public interface Methods {
    void init();

    void finish();

    Product getProduct(String productId) throws Exception;

    List<Product> getProducts(String pattern);

    List<Product> getTopProducts(int k);
    List<Product> getSimilarCheaperProduct(String productId);

    List<String> getTrolls(int rating);

    List<Verfügbarkeit> getOffers(String id);

    String addNewReview(Bewertung bewertung);

}
