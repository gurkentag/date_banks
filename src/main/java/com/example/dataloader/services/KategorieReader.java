package com.example.dataloader.services;

import org.springframework.stereotype.Service;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

@Service
public class KategorieReader {

    public void readCategoriesXML(String fileName) throws SAXException, IOException, ParserConfigurationException {
        File xmlFile = new File(fileName);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        Node rootNode = doc.getDocumentElement();
        System.out.println("Root element: " + rootNode.getNodeName());

        NodeList nList = doc.getElementsByTagName("category");

        for (int i = 0; i < nList.getLength(); i++ ) {
        //for (int i = 0; i < 5; i++ ) {
            Node nNode = nList.item(i);

            String kategorieName = nNode.getTextContent().split("\\r?\\n|\\r")[0];
            String parentName = "";
            Node parentNode = nNode.getParentNode();
            if (!(rootNode == parentNode)){
                parentName = parentNode.getTextContent().split("\\r?\\n|\\r")[0];
            }

            System.out.println("Kategorie Name: " + kategorieName + "\nParent Name: " + parentName);
            //Ersetzen durch SQL Anfragen

        }
    }

}
