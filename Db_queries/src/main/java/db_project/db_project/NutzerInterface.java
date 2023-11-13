package db_project.db_project;

import db_project.db_project.entities.Bewertung;
import db_project.db_project.entities.Product;
import db_project.db_project.entities.Verfügbarkeit;
import java.util.List;
import java.util.Scanner;

public class NutzerInterface {

    private Scanner scanner;

    public NutzerInterface() {
        this.scanner = new Scanner(System.in);
    }


    public String getUserChoice(){
        System.out.println("\n-------------------------");
        System.out.println("Wählen Sie eine der Möglichkeiten:");
        System.out.println("-------------------------");
        System.out.println("1 - Information über ein Produkt ansehen");
        System.out.println("2 - Liste von Produkten mit einem Muster bekommen");
        System.out.println("3 - Top k Produkte anschauen");
        System.out.println("4 - Billigere Produkte finden");
        System.out.println("5 - Nutzer nach einem Rating rating ordnen");
        System.out.println("6 - Verfügbare Angebote für ein Produkt");
        System.out.println("7 - Möchten Sie eine Bewertung lesen?");
        System.out.println("8 - Oder eine neue hinzufügen?");
        System.out.println("0 - Um das Menü zu verlassen");
        return scanner.nextLine();
    }

    public String getInputId() {
        System.out.print("Geben Sie die Product ID ein: ");
        return scanner.nextLine();
    }

    public String getPattern() {
        System.out.print("Geben Sie einen Pattern ein: ");
        return scanner.nextLine();
    }

    public String getTopProdOnRating() {
        System.out.print("Geben Sie Anzahl der nach Rating sortierten Produkte: ");
        return scanner.nextLine();
    }


    public String getSpezifiertenRating(){
        System.out.println("Spezifizieren Sie ein Rating, um die Nutzer zu filtern: ");
        return scanner.nextLine();
    }

    public void outputOfNutzer(List <String> nutzer, int rating){
        System.out.println("\nNutzer, die ein Rating kleiner als " + rating +" haben: ");
        for(int i=0; i<nutzer.size();i++){
                System.out.println(nutzer.get(i));
            }
    }

    public String getIdfuerOffers(){
        System.out.println("Geben Sie eine Id, um alle vurfügbaren Angebote zu sehen: ");
        return scanner.nextLine();
    }

    public void outputOfOffers(List<Verfügbarkeit> offers) {
        if (offers.size() > 0) {
            System.out.println("\nFolgende Angebote sind für das Product erhältlich:");
            for (int i = 0; i < offers.size(); i++) {
                Verfügbarkeit offer = offers.get(i);
                System.out.println("\nIn der Filiale: " + offer.getFilialid() + "\nAnzahl: " + offer.getProductanzahl() + "\nmit dem Preis: " + offer.getPreis() + "\nIm Zustand: " + offer.getZustand());
            }
        } else {
            System.out.println("\nDas Produkt in keiner Filiale vorhanden!");
        }

    }
    public String getIdfuerEineExistReview(){
        System.out.println("Geben Sie ProduktId, um alle Reviews anzusehen: ");
        return scanner.nextLine();
    }

    public void outputOfReviews(List<Bewertung> revs){
        if(revs.size()>0){
            System.out.println("\nEs sind folgende Bewertungen gefunden: ");
            for(int i=0;i<revs.size();i++){
                var currentRev = revs.get(i);
                System.out.println("\nDer Nutzer: "+ currentRev.getUsername()+ " hat folgendes geschrieben:\n" + currentRev.getSummary() + "\nRating: " +currentRev.getRating()+ "\nHelpful: "+ currentRev.getHelpful());
            }
        } else{
            System.out.println("\nFür dieses Produkt keine Bewertungen gefunden.");
        }
    }

    public String getIdFürAehnlicheProds(){
        System.out.println("Geben sie eine Id um billigere Produkte zu finden: ");
        return scanner.nextLine();
    }

    public void outputOfAehnlicheProds(List<Product> products, String prodId){
        if(products.size()!=0) {
            System.out.println("\nProdukte, die ähnlich aber billiger als " + prodId + " sind :" );
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
//                Double price = dataBaseMethods.getPrice(product.getProductnummer());
                System.out.println(product.getProductnummer() + ", " + product.getTitel());
            }
        } else {System.out.println("Keine Produkte gefunden!");}

    }
  public String getProdNummerforReview(){
        System.out.println("\nBitte geben Sie folgende Information für neue Bewertung: ");
        System.out.println("\nProduktnummer: ");
        return scanner.nextLine();
}

   public int getRatingforReview(){
        System.out.println("\nWie bewerten Sie dieses Produkt? Eine Zahl von 1 bis 5 eingeben : ");
        return Integer.parseInt(scanner.nextLine());
}
    public int getHelfulforReview(){
        System.out.println("\nWar es hilfreich? Bitte eine Zahl eingeben: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String getUserNameforReview(){
        System.out.println("\nBitte geben Sie einen Namen ein: ");
        return scanner.nextLine();
    }

    public String getSummaryForReview(){
        System.out.println("\nBeschreiben Sie eine kurze Zusammenfassung: ");
        return scanner.nextLine();
    }

    public String getInhaltforReview(){
        System.out.println("\nTeilen Sie jetzt genauer Ihre Meinung: ");
        return scanner.nextLine();
    }


    public void outPutOfTopProduct(List<Product> products, String k){
        System.out.println("\nTop " + k + " Produkte");
        for(int i=0; i<products.size();i++){
            Product product = products.get(i);
            System.out.println(product.getProductnummer() + ", "+ product.getTitel() + ", " + product.getVerkaufsrating());
        }
        System.out.println("");

    }

    public void outputOfProductsInfo(Product product) {
        if (product != null) {
            System.out.println("\nProduct: " + product.getProductnummer() + ", " + product.getProducttype());
            System.out.println("Titel: " + product.getTitel());
            System.out.println("Ean: " + product.getEan());
            System.out.println("Kategorie: " + product.getKategorieid());
            System.out.println("Rating: " + product.getVerkaufsrating());
            System.out.println("Rang: " + product.getVerkaufsrang());
        } else {
            System.out.println("\nKein Product mit eingegebener ID gefunden,\nbitte überprüfen Sie die Eingabe");
        }
    }

    public void outPutOfProdList(List<Product> products) {
        if (products.size() != 0) {
            System.out.println("\nListe von Produkten mit dem entsprechenden Muster: ");
            for (int i = 0; i < products.size(); i++) {
                System.out.println("Titel: " + products.get(i).getTitel());
            }
            System.out.println("");
        } else {
            System.out.println("Kein Treffer mit dem eingegebenen Muster");
        }
    }
}

