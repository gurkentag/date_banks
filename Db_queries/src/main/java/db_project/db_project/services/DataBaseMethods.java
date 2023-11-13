package db_project.db_project.services;

import db_project.db_project.entities.Bewertung;
import db_project.db_project.modul.Methods;
import db_project.db_project.entities.Product;
import db_project.db_project.entities.Verfügbarkeit;
import db_project.db_project.repositories.BewertungsRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

//
@Component
@RequiredArgsConstructor
public class DataBaseMethods implements Methods {
    private SessionFactory sessionFactory;
    private final BewertungsRepository bewertungsRepository;

    @Override
    public void init() {
        try {
            // Erstelle eine neue Konfigurationsinstanz
            Configuration configuration = new Configuration();
            // Lade die Konfiguration aus der hibernate.cfg.xml
            configuration.configure("hibernate.cfg.xml");
            // Erstelle die SessionFactory aus der Konfiguration
            this.sessionFactory = configuration.buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void finish() {
        if (this.sessionFactory != null && !this.sessionFactory.isClosed()) {
            this.sessionFactory.close();
        }
    }

    @Override
    public Product getProduct(String productId) {
        Session session = sessionFactory.openSession();
        Product product = session.get(Product.class, productId);
        session.close();
        return product;

    }

    @Override
    public List<Product> getProducts(String pattern) {
        Session session = sessionFactory.openSession();
        List<Product> products = new ArrayList<>();
        try {
            String queryStr;
            if (pattern == null) {
                queryStr = "FROM Product";
            } else {
                queryStr = "FROM Product WHERE LOWER(titel) LIKE LOWER(:pattern)";
                pattern = "%" + pattern + "%";
            }
            Query query = session.createQuery(queryStr);
            if (pattern != null) {
                query.setParameter("pattern", pattern);
            }
            products = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    @Override
    public List<Product> getTopProducts(int k) {
        Session session = sessionFactory.openSession();
        List<Product> products = new ArrayList<>();
        try {
            String hql = "FROM Product P WHERE P.verkaufsrating IS NOT NULL ORDER BY P.verkaufsrating DESC";
            Query query = session.createQuery(hql);
            query.setMaxResults(k);
            products = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return products;
    }

    @Override
    public List<Product> getSimilarCheaperProduct(String productId) {

        Session session = sessionFactory.openSession();
        // Zuerst das spezifizierte Produkt abrufen, um den Preis zu bestimmen
        Product gegebenesProduct = session.get(Product.class, productId);
        if (gegebenesProduct == null) {
            session.close();
            return Collections.emptyList(); // oder werfen Sie eine Ausnahme
        }
        // Den Preis des spezifizierten Produkts abrufen
        Query priceQuery = session.createQuery("SELECT preis FROM Verfügbarkeit WHERE productnummer = :productId");
        priceQuery.setParameter("productId", productId);
        Double productPreis = (Double) priceQuery.uniqueResult();
        if (productPreis == null) {
            session.close();
            return Collections.emptyList();
        }
        // Dann eine Abfrage ausführen, um ähnliche, billigere Produkte zu finden
        String queryStr = "SELECT p FROM Product p, ÄhnlicheProdukte ap, Verfügbarkeit v " +
                "WHERE ap.product1id = :productId AND ap.product2id = p.productnummer " +
                "AND v.productnummer = p.productnummer AND v.preis < :price";

        Query query = session.createQuery(queryStr);
        query.setParameter("productId", productId);
        query.setParameter("price", productPreis);
        List<Product> aehnlicheProdukte = query.list();
        session.close();
        return aehnlicheProdukte;
    }

    @Override
    public List<String> getTrolls(int rating) {
        Session session = sessionFactory.openSession();
        List<String> users = new ArrayList<>();
       try {
           String hql = "SELECT b.username " +
                   "FROM Bewertung b " +
                   "GROUP BY b.username " +
                   "HAVING AVG(b.rating) < :rating";
           Query<String> query = session.createQuery(hql, String.class);
           query.setParameter("rating", rating);
            users = query.list();
       }catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }

    @Override
    public List<Verfügbarkeit> getOffers(String id) {
        Session session = sessionFactory.openSession();
        List<Verfügbarkeit> angebote = new ArrayList<>();
        try {
            String hql = "FROM Verfügbarkeit v WHERE v.productnummer = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            angebote = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return angebote;
    }

    @Override
    public String addNewReview(Bewertung bewertung) {
        try {
            bewertungsRepository.save(bewertung);
            return "\nBewertung wurde erfolgreich hinzugefügt";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fehler beim Hinzufügen der Bewertung: " + e.getMessage();
        }
    }


//    public Double getPrice(String productNummer) {
//        Session session = sessionFactory.openSession();
//        Query query = session.createQuery("SELECT v.preis FROM Verfügbarkeit v WHERE v.productnummer = :productNummer");
//        Double price = (Double) query.uniqueResult();
//        session.close();
//        return price;
//    }


    public List<Bewertung> reviews(String prodId) {
        Session session = sessionFactory.openSession();
        List<Bewertung> reviews = new ArrayList<>();
        try {
            Query query = session.createQuery("FROM Bewertung b WHERE b.productnummer = :prodId");
            query.setParameter("prodId", prodId);
            reviews = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return reviews;
    }


    public Bewertung createBewetrung(String prodId, int rating, int helpful, String username, String summary, String content) {
        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());// Enddatum (heutiges Datum)
        var bewertung = Bewertung.builder()
                .productnummer(prodId)
                .rating(rating)
                .helpful(helpful)
                .username(username)
                .summary(summary)
                .content(content)
                .reviewDate(date)
                .build();
        return bewertung;
    }
}



