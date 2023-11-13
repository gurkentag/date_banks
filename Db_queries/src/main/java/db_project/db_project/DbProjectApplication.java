package db_project.db_project;

import db_project.db_project.entities.Product;
import db_project.db_project.services.DataBaseMethods;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class DbProjectApplication implements CommandLineRunner {

    private final DataBaseMethods dataBaseMethods;

    public static void main(String[] args) {

        SpringApplication.run(DbProjectApplication.class, args);
    }
    @Override
    public void run(String... args) {

        //Erstelle Verbindung zu DB
        dataBaseMethods.init();
        //Erstelle Instanz, um mit dem Nutzer zu kommunizieren
        NutzerInterface nutzerInterface = new NutzerInterface();
        //User Menu
        int t = 1;
        while (t > 0) {
            var userAnswer = nutzerInterface.getUserChoice();
            if (!userAnswer.equals("0")) {
                switch (userAnswer) {
                    //Product mit Product Id
                    case "1":
                        String id = nutzerInterface.getInputId();
                        Product product = dataBaseMethods.getProduct(id);
                        nutzerInterface.outputOfProductsInfo(product);
                        break;
                    //Products List mit Muster
                    case "2":
                        String pattern = nutzerInterface.getPattern();
                        List<Product> products = dataBaseMethods.getProducts(pattern);
                        nutzerInterface.outPutOfProdList(products);
                        break;

                    //Gebe top k products basierend auf dem Rating
                    case "3":
                        String k = nutzerInterface.getTopProdOnRating();
                        List<Product> prodRating = dataBaseMethods.getTopProducts(Integer.parseInt(k));
                        nutzerInterface.outPutOfTopProduct(prodRating, k);
                        break;

                    //Alles um die billigereProdukte anzuzeigen
                    // NEHME ALS BEISPIEL B000AND9ZK oder B000ANDA0O
                    case "4":
                        String prodId = nutzerInterface.getIdFürAehnlicheProds();
                        List<Product> cheapProds = dataBaseMethods.getSimilarCheaperProduct(prodId);
                        nutzerInterface.outputOfAehnlicheProds(cheapProds, prodId);
                        break;

                    //Alles um die Nutzer mit einem Rating anzuzeigen
                    case "5":
                        String rating = nutzerInterface.getSpezifiertenRating();
                        var nutzerList = dataBaseMethods.getTrolls(Integer.parseInt(rating));
                        nutzerInterface.outputOfNutzer(nutzerList, Integer.parseInt(rating));
                        break;

                    //	alles für Offers
                    case "6":
                        String prodId1 = nutzerInterface.getIdfuerOffers();
                        var offersList = dataBaseMethods.getOffers(prodId1);
                        nutzerInterface.outputOfOffers(offersList);
                        break;

                    //eine Bewertung ansehen
                    case "7":
                        String prodIdRev = nutzerInterface.getIdfuerEineExistReview();
                        var reviewList = dataBaseMethods.reviews(prodIdRev);
                        nutzerInterface.outputOfReviews(reviewList);
                        break;

                    //neue Bewertung hinzufuegen
                    case "8":
                        String idForRev = nutzerInterface.getProdNummerforReview();
                        int rat = nutzerInterface.getRatingforReview();
                        int hilfe = nutzerInterface.getHelfulforReview();
                        String userName = nutzerInterface.getUserNameforReview();
                        String summary = nutzerInterface.getSummaryForReview();
                        String inhalt = nutzerInterface.getInhaltforReview();
                        var createdBew = dataBaseMethods.createBewetrung(idForRev, rat, hilfe, userName, summary, inhalt);
                        System.out.println(dataBaseMethods.addNewReview(createdBew));
                        break;
                    case "0": break;
                    default:System.out.println("Keine Antwort gewählt, versuchen Sie es neu");
                    break;
                }
            }
            t = Integer.parseInt(userAnswer);
        }
        dataBaseMethods.finish();

    }
}

