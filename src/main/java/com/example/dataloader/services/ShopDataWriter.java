package com.example.dataloader.services;

import com.example.dataloader.entities.*;
import com.example.dataloader.repositories.*;
import com.example.dataloader.xmlreader.categories_entities.Categories;
import com.example.dataloader.xmlreader.categories_entities.Category;
import com.example.dataloader.xmlreader.xml_entities.Item;
import com.example.dataloader.xmlreader.xml_entities.Shop;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@RequiredArgsConstructor
public class ShopDataWriter {

    private final FilialeRepository filialeRepository;

    private final VerfügbarkeitsRepository verfügbarkeitsRepository;
    private final ÄhnlicheProducteRepository aehnlicheProducteRepository;
    private final ProductRepository productRepository;
    private final BookPropertiesRep bookPropertiesRep;
    private final MusicPropertiesRep musicPropertiesRep;
    private final DVDPropertiesRep dvdPropertiesRep;
    private final AuthorsRep authorsRep;
    private final Books_authorsRep booksAuthorsRep;
    private final CreatorsRep creatorsRep;
    private final Cd_CreateRep cdCreateRep;
    private final Dvd_creatorRep dvdCreatorRep;
    private final PublicherRep publicherRep;
    private final TracksRep tracksRep;
    private final Cds_tracksRep cdsTracksRep;
    private final ActorsRep actorsRep;
    private final Dvd_actorsRep dvdActorsRep;
    private final Dvd_directorRep dvdDirectorRep;
    private final DirectorsRep directorsRep;
    private final AudiotextRep audiotextRep;
    private final Books_publicherRep booksPublicherRep;
    private final KategorieRepository kategorieRepository;
    private final Dvd_audiotextRep dvdAudiotextRep;


    //the main function in this class that runs all insertions
    public void saveShopData(Shop shop, Categories categories) {
//        var filiale = Filiale.builder()
//                .anschrift(shop.getStreet() + ", " + shop.getZip())
//                .filialname(shop.getName())
//                .build();
//        filialeRepository.save(filiale);
//
//
       var filialIds = filialeRepository.findAll();
       saveVervuegbarkeit(shop, filialIds);
//
//       saveProductProperties(shop.getItem(), categories);
//
//       saveBooksProperties(shop.getItem());
//       saveMusicProperties(shop.getItem());
 //      saveDvdProperties(shop.getItem());
//       saveAehnlicheProducte(shop.getItem());


    }


    public void saveProductProperties(List<Item> items, Categories categories) {
        items.stream()
                .map(item -> {
                    var builder = Product.builder();

                    if (item.getPgroup() != null) {
                        builder.producttype(item.getPgroup());
                    }

                    if (item.getSalesrank() != null) {
                        builder.verkaufsrang(item.getSalesrank());
                    }
                    if (item.getTitle() != null) {
                        builder.titel(item.getTitle());
                    }
                    if (item.getPicture() != null) {
                        builder.bild(item.getPicture());
                    }

                    if (item.getEan() != null) {
                        builder.ean(item.getEan());
                    }
                    if (item.getAsin() != null) {
                        builder.productnummer(item.getAsin());
                    }

                    var category = findCategory(categories.getCategories(), item.getAsin());
                    if(category != null){

                        var savedCategories = kategorieRepository.findByKategoriename(category.getName());

                        if(savedCategories != null && savedCategories.size() > 0){
                            builder.kategorieid(savedCategories.get(0).getId());
                        }
                    }else{
                        System.out.println("PRODUCT WITHOUT CATEGORY");
                    }

                    return builder.build();
                })
                .map(productPropertie -> {
                    try {
                        productRepository.save(productPropertie);
                    } catch (Exception e) {
                        System.out.println("Can not insert into productProperties. " + e.getMessage());
                    }
                    return true;
                })
                .toList();
    }

    public Category findCategory(List<Category> categories, String itemName){
        for(var category : categories) {
            if (category.getItems() != null) {
                    if (category.getItems().contains(itemName)) {
                        return category;
                    }
                }
            if (category.getSubCategories() != null && category.getSubCategories().size() > 0) {
                var cat =  findCategory(category.getSubCategories(), itemName);

                if(cat != null){
                    return cat;
                }
            }
        }
        return null;
    }

    public void saveCdCreators(Item item, String cdId) {
        if (item.getCreators() != null && item.getCreators().getCreators() != null) {
            var creators = item
                    .getCreators()
                    .getCreators()
                    .stream()
                    .map(creator ->
                            creator.getName() != null ?
                                    creator.getName() :
                                    creator.getValue()
                    )
                    .flatMap(creator -> Arrays.stream(creator.split("/")))
                    .toList();
            creators.stream()
                    .map(creatorName -> Creators.builder().cname(creatorName).build())
                    .forEach(creator -> {
                        try {
                            var preCreator = creatorsRep.findByCname(creator.getCname());
                            if (preCreator.size() == 0) {
                                var savedCreator = creatorsRep.save(creator);

                                var cdCreator = Cd_creator.builder()
                                        .creatorId(savedCreator.getId())
                                        .productNummer(cdId)
                                        .build();

                                cdCreateRep.save(cdCreator);
                            } else {

                                var cdCreator = Cd_creator.builder()
                                        .creatorId(preCreator.get(0).getId())
                                        .productNummer(cdId)
                                        .build();
                                cdCreateRep.save(cdCreator);

                            }

                        } catch (Exception e) {
                            System.out.println("Can not insert into productProperties. " + e.getMessage());
                        }

                    });
        }

    }

    public void saveDvdCreator(Item item, String dvdId){

        if (item.getCreators() != null && item.getCreators().getCreators() != null) {
            var creators = item
                    .getCreators()
                    .getCreators()
                    .stream()
                    .map(creator -> creator.getName() != null ?
                            creator.getName() :
                            creator.getValue()
                    )
                    .flatMap(creator -> Arrays.stream(creator.split("/")))
                    .toList();

            creators.stream()
                    .map(creatorName -> Creators.builder().cname(creatorName).build())
                    .forEach(creator -> {
                        try {
                            var preCreator = creatorsRep.findByCname(creator.getCname());
                            if (preCreator.size() == 0) {
                                var savedCreator = creatorsRep.save(creator);
                                var dvdCreator = Dvd_creator.builder()
                                        .creatorId(savedCreator.getId())
                                        .productNummer(dvdId)
                                        .build();
                                dvdCreatorRep.save(dvdCreator);

                            } else {
                                var dvdCreator = Dvd_creator.builder()
                                        .creatorId(preCreator.get(0).getId())
                                        .productNummer(dvdId)
                                        .build();
                                dvdCreatorRep.save(dvdCreator);
                            }

                        } catch (Exception e) {
                            System.out.println("Can not insert into productProperties. " + e.getMessage());
                        }

                    });
        }

    }
    public void saveTracks(Item item, String cdId){
        var tracks = new ArrayList<String>();

        if (item.getTracks() != null && item.getTracks().getTitles() != null) {
            tracks = (ArrayList<String>) item.getTracks().getTitles().stream().collect(Collectors.toList());
        }
        tracks.stream()
                .map(trackName -> Tracks.builder().titel(trackName).build())
                .forEach(track -> {
                    try {
                        var preTrack =tracksRep.findByTitel(track.getTitel());
                        if (preTrack.size() == 0) {
                            var savedTitel= tracksRep.save(track);
                            var cdTracks= Cds_tracks.builder()
                                    .productNummer(cdId)
                                    .id(savedTitel.getId())
                                    .build();
                            cdsTracksRep.save(cdTracks);
                        }
                        else {
                            var cdTracks= Cds_tracks.builder()
                                    .productNummer(cdId)
                                    .id(preTrack.get(0).getId())
                                    .build();
                            cdsTracksRep.save(cdTracks);
                        }

                    } catch (Exception e) {
                        System.out.println("Can not insert into productProperties. " + e.getMessage());
                    }

                });



    }

    public void savePublichers(Item item, String bookId) {
        String publicher = "";

        if (item.getPublishers() != null && item.getPublishers().getPublisher() != null) {
            publicher = item.getPublishers().getPublisher().value != null ? item.getPublishers().getPublisher().value : item.getPublishers().getPublisher().name;
        }else {
            // TODO check why there are no publishers
            System.out.println("NO PUBLISHER");
            return;
        }

        var publicherBilder = Publichers.builder().pname(publicher).build();
        var prePublicher = publicherRep.findByPname(publicher);
        if (prePublicher.size() == 0) {
            var savedPub = publicherRep.save(publicherBilder);
            var bookPublicher = Books_publicher.builder()
                    .publicherId(savedPub.getPublicherid())
                    .productNummer(bookId)
                    .build();
            booksPublicherRep.save(bookPublicher);
        } else {
            var bookPublicher = Books_publicher.builder()
                    .publicherId(prePublicher.get(0).getPublicherid())
                    .productNummer(bookId)
                    .build();
            booksPublicherRep.save(bookPublicher);
        }
    }


    public void saveAuthors(Item item, String bookId) {
        var authors = new ArrayList<String>();

        if (item.getAuthors() != null && item.getAuthors().getAuthors() != null) {
            authors = (ArrayList<String>) item.getAuthors().getAuthors().stream().map(author -> author.getName() != null ? author.getName() : author.getValue()).collect(Collectors.toList());
        }
        authors.stream()
                .map(authorName -> Authors.builder().aname(authorName).build())
                .forEach(author -> {
                    try {
                        var preAuthor =authorsRep.findByAname(author.getAname());
                        if (preAuthor.size() == 0) {
                            var savedAuthor= authorsRep.save(author);
                            var bookAut= Books_authors.builder()
                                    .authorId(savedAuthor.getId())
                                    .productNummer(bookId)
                                    .build();
                            booksAuthorsRep.save(bookAut);
                        }
                        else {
                            var bookAut= Books_authors.builder()
                                    .authorId(preAuthor.get(0).getId())
                                    .productNummer(bookId)
                                    .build();
                            booksAuthorsRep.save(bookAut);
                        }

                    } catch (Exception e) {
                        System.out.println("Can not insert into productProperties. " + e.getMessage());
                    }

                });


    }


    public void saveBooksProperties(List<Item> items) {
        items.stream()
                .map(item -> {
                    var builder = BookProperties.builder();
                    if(item.getPgroup().equals("Book")) {
                        if (item.getBookSpec() != null && item.getBookSpec().getIsbn() != null) {
                            builder.isbnnummer(item.getBookSpec().getIsbn().getVal());
                        }
                        if (item.getBookSpec() != null) {
                            builder.seitenzahl(item.getBookSpec().getPages());
                        }
                        if (item.getBookSpec() != null) {
                            builder.binding(item.getBookSpec().getBinding());
                        }
                        if (item.getBookSpec() != null && item.getBookSpec().getEdition() != null) {
                            builder.edition(item.getBookSpec().getEdition().getVal());
                        }
                        if (item.getBookSpec() != null && item.getBookSpec().getPackageType() != null) {
                            builder.packages(item.getBookSpec().getPackageType().getWeight() != null ? item.getBookSpec().getPackageType().getWeight() : item.getBookSpec().getPackageType().getLength() != null ? item.getBookSpec().getPackageType().getLength() : item.getBookSpec().getPackageType().getHeight());
                        }
                        if (item.getAsin() != null) {
                            builder.productnummer(item.getAsin());
                        }
                        if (item.getBookSpec() != null && item.getBookSpec().getPublication() != null) {
                            builder.publication(item.getBookSpec().getPublication().getDate());
                        }
                        var bookProperties = builder.build();
                        try {
                            var savedBook = bookPropertiesRep.save(bookProperties);
                            saveAuthors(item, savedBook.getProductnummer());
                            savePublichers(item, savedBook.getProductnummer());
                        } catch (Exception e) {
                            System.out.println("Can not insert into productProperties. " + e.getMessage());
                        }
                    }
                    return true;

                })
                .toList();
    }

    public void saveMusicProperties(List<Item> items) {
        items.stream()
                .map(item -> {
                    var builder = MusicProperties.builder();
                    if(item.getPgroup().equals("Music")) {
                        if (item.getLabels() != null && item.getLabels().getLabel() != null) {
                            builder.productlabel(item.getLabels().getLabel().getValue() != null ? item.getLabels().getLabel().getValue() : item.getLabels().getLabel().getName());
                        }
                        if (item.getMusicSpec() != null) {
                            builder.binding(item.getMusicSpec().getBinding());
                        }
                        if (item.getAsin() != null) {
                            builder.productnummer(item.getAsin());
                        }
                        if (item.getMusicSpec() != null && item.getMusicSpec().getFormat() != null) {
                            builder.format(item.getMusicSpec().getFormat().getValue() != null ? item.getMusicSpec().getFormat().getValue() : item.getMusicSpec().getFormat().getValue2());
                        }
                        if (item.getMusicSpec() != null) {
                            builder.numDiscs(item.getMusicSpec().getNumDiscs());
                        }
                        if (item.getMusicSpec() != null) {
                            builder.releaseDate(item.getMusicSpec().getReleaseDate());
                        }
                        if (item.getMusicSpec() != null && item.getMusicSpec().getUpc() != null) {
                            builder.ups(item.getMusicSpec().getUpc().getValue() != null ? item.getMusicSpec().getUpc().getValue() : item.getMusicSpec().getUpc().getVal());
                        }

                        var musicProperties = builder.build();
                        try {
                            var savedCd = musicPropertiesRep.save(musicProperties);
                            saveTracks(item, savedCd.getProductnummer());
                            saveCdCreators(item, savedCd.getProductnummer());
                        } catch (Exception e) {
                            System.out.println("Can not insert into productProperties. " + e.getMessage());
                        }

                    }
                        return true;

                })

               .toList();



    }

    public void saveActors(Item item, String dvdId) {
        var actors = new ArrayList<String>();

        if (item.getActors() != null && item.getActors().getActors() != null) {
            actors = (ArrayList<String>) item.getActors().getActors().stream().map(actor -> actor.getName() != null ? actor.getName() : actor.getValue()).collect(Collectors.toList());
        }
        actors.stream()
                .map(actorName -> Actors.builder().aname(actorName).build())
                .forEach(actor -> {
                    try {
                        var preActor =actorsRep.findByAname(actor.getAname());
                        if (preActor.size() == 0) {
                            var savedactor= actorsRep.save(actor);
                            var dvdActor= Dvd_actors.builder()
                                    .actorId(savedactor.getId())
                                    .productNummer(dvdId)
                                    .build();
                            dvdActorsRep.save(dvdActor);
                        }
                        else {
                            var dvdActor= Dvd_actors.builder()
                                    .actorId(preActor.get(0).getId())
                                    .productNummer(dvdId)
                                    .build();
                            dvdActorsRep.save(dvdActor);
                        }

                    } catch (Exception e) {
                        System.out.println("Can not insert into productProperties. " + e.getMessage());
                    }

                });


    }

    public void saveDirectors(Item item, String dvdId) {
        var directors = new ArrayList<String>();

        if (item.getDirectors() != null && item.getDirectors().getDirectors() != null) {
                       directors = (ArrayList<String>) item.getDirectors().getDirectors().stream().map(director -> director.getName() != null ? director.getName() : director.getValue()).collect(Collectors.toList());
                    }
        directors.stream()
                .map(directorName -> Directors.builder().dname(directorName).build())
                .forEach(director -> {
                    try {
                        var preDirector = directorsRep.findByDname(director.getDname());
                        if (preDirector.size() == 0) {
                            var savedDirector= directorsRep.save(director);
                            var dvdDirector= Dvd_director.builder()
                                    .directorId(savedDirector.getId())
                                    .productNummer(dvdId)
                                    .build();
                            dvdDirectorRep.save(dvdDirector);
                        }
                        else {
                            var dvdDirector= Dvd_director.builder()
                                    .directorId(preDirector.get(0).getId())
                                    .productNummer(dvdId)
                                    .build();
                            dvdDirectorRep.save(dvdDirector);
                        }

                    } catch (Exception e) {
                        System.out.println("Can not insert into productProperties. " + e.getMessage());
                    }

                });


    }

    public void saveAudioText(Item item, String dvdId){
        var audiotextBuilder = Audiotext.builder();

        if (item.getAudioText() != null && item.getAudioText().getAudioFormats() != null) {
            audiotextBuilder.audioformat(item.getAudioText().getAudioFormats().stream().collect(Collectors.joining(",")));
        }
        if(item.getAudioText() !=null && item.getAudioText().getLanguages() !=null ){
            audiotextBuilder.languages(
                    item
                            .getAudioText()
                            .getLanguages()
                            .stream()
                            .flatMap(i-> Arrays.stream(i.getValue().split(",")))
                            .map(i->i.trim())
                            .distinct()
                            .collect(Collectors.joining(", "))
            );
        }

        var audiotext = audiotextBuilder.build();

        try {
            audiotext = audiotextRep.save(audiotext);

            var dvdAudioText = Dvd_audiotext.builder()
                    .audiotextId(audiotext.getId())
                    .productNummer(dvdId)
                    .build();

            dvdAudiotextRep.save(dvdAudioText);
        } catch (Exception e) {
            System.out.println("Can not insert into productProperties. " + e.getMessage());
        }

    }

    public void saveDvdProperties(List<Item> items) {
        items.stream()
                .map(item -> {
                    var builder = DVDProperties.builder();
                    if(item.getPgroup().equals("DVD")) {
                        if (item.getAsin() != null) {
                            builder.productnummer(item.getAsin());
                        }
                        if (item.getDvdSpec() != null) {
                            builder.laufzeit(item.getDvdSpec().getRunningTime());
                        }

                        if (item.getDvdSpec() != null && item.getDvdSpec().getUpc() != null) {
                            builder.ups(item.getDvdSpec().getUpc().value != null ? item.getDvdSpec().getUpc().value : item.getDvdSpec().getUpc().val);
                        }

                        if (item.getStudios() != null && item.getStudios().getStudio() != null) {
                            builder.studio(item.getStudios().getStudio().getValue() != null ? item.getStudios().getStudio().getValue() : item.getStudios().getStudio().getName());
                        }
                        if (item.getDvdSpec() != null) {
                            builder.aspectRatio(item.getDvdSpec().getAspectRatio());
                        }

                        if (item.getDvdSpec() != null) {
                            builder.format(item.getDvdSpec().getFormat());
                        }

                        if (item.getDvdSpec() != null) {
                            builder.releaseDate(item.getDvdSpec().getReleaseDate());
                        }
                        if (item.getDvdSpec() != null) {
                            builder.laufzeit(item.getDvdSpec().getRunningTime());
                        }
                        if (item.getDvdSpec() != null) {
                            builder.theatricalRelease(item.getDvdSpec().getTheatricalRelease());
                        }
                        if (item.getDvdSpec() != null && item.getDvdSpec().getUpc() != null) {
                            builder.ups(item.getDvdSpec().getUpc().getVal() != null ? item.getDvdSpec().getUpc().getVal() : item.getDvdSpec().getUpc().getValue());
                        }
                        var dvdProperties = builder.build();
                        try {
                            var savedDvd = dvdPropertiesRep.save(dvdProperties);
                            saveActors(item, savedDvd.getProductnummer());
                            saveDirectors(item, savedDvd.getProductnummer());
                            saveDvdCreator(item, savedDvd.getProductnummer());
                            saveAudioText(item, savedDvd.getProductnummer());
                        } catch (Exception e) {
                            System.out.println("Can not insert into productProperties. " + e.getMessage());
                        }
                    }
                    return true;
                })
                .toList();


    }


    public void saveVervuegbarkeit(Shop shop, List<Filiale> filialIds) {
        shop.getItem().stream()
                .filter(item -> item.getPrice() != null && item.getPrice().getValue() != null && item.getPrice().getValue() > 0)
                .map(item -> {
                    var builder = Verfügbarkeit.builder();
                    builder.preis(item.getPrice().getValue());

                    builder.filialid(filialIds.stream().filter(filiale -> filiale.getFilialname().equals(shop.getName())).findFirst().get().getId());
                    builder.productnummer(item.getAsin());

                    return builder.build();

                })

                .map(verfügbarkeit1 -> {
                    try {
                        verfügbarkeitsRepository.save(verfügbarkeit1);
                    } catch (Exception e) {
                        System.out.println("Can not insert into Verfuegberkeit. " + e.getMessage());
                    }
                    return true;

                })
                .toList();


    }

    public void saveAehnlicheProducte(List<Item> items) {
        items.stream()
                .filter(item -> item.getSimilars() != null && item.getSimilars().getSimProducts() != null)
                .flatMap(item ->
                        item.getSimilars().getSimProducts().stream()
                                .map(simProduct -> {
                                    var builder = ÄhnlicheProdukte.builder();

                                    builder.product1id(item.getAsin());

                                    builder.product2id(simProduct.asin);

                                    return builder.build();

                                }).map(simProd -> {
                                    try {
                                        aehnlicheProducteRepository.save(simProd);
                                    } catch (Exception e) {
                                        System.out.println("Can not insert into aehnlicheProducte. " + e.getMessage());
                                    }
                                    return true;
                                })

                ).toList();

    }
    }

