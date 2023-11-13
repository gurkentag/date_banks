package com.example.dataloader.services;

import com.example.dataloader.entities.Bewertung;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class ReviewReader {

    public List<Bewertung> readCSVFile(String fileName) throws IOException {
        List<Bewertung> reviews = new ArrayList<>();
        InputStream inputStream = getResourceFileAsInputStream(fileName);
//        // create an instance of BufferedReader

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            // read the first line from the text file
            String line = reader.readLine();
//
//            // loop until all lines are read
            String[] attributes;
            var isFirstLine = true;
            while (line != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    line = reader.readLine();
                    continue;
                }

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                attributes = line.replaceAll("\"", "").split(",");

                //create instance of Bewertung
                Bewertung bewertung = creatBewertung(attributes);

                // adding entity into ArrayList
                reviews.add(bewertung);

                // read next line before looping
                // if end of file reached, line would be null
                line = reader.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return reviews;
    }

    //function to creat new instance of Bewertung
    private static Bewertung creatBewertung(String[] attributes) throws ParseException {
        String product = attributes[0];
        int rating = Integer.parseInt(attributes[1]);
        int helpful = Integer.parseInt(attributes[2]);
        Date reviewDate;
        try {
            reviewDate = DateUtils.parseDate(attributes[3], new String[]{"yyyy-MM-dd" });
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String user = attributes[4];
        String summary = attributes[5];
        String content = attributes[6];

        // create and return bewertung of this metadata
        return new Bewertung(null, product, rating, helpful, reviewDate, user, summary, content);
    }

    //read file from resources folder as stream
    public static InputStream getResourceFileAsInputStream(String fileName) {

        ClassLoader classLoader = ReviewReader.class.getClassLoader();
        return classLoader.getResourceAsStream(fileName);
    }
}






