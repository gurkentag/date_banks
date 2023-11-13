package com.example.dataloader.services;

import org.springframework.stereotype.Service;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.*;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@Service
public class StandortReader {

    public void readStandortXML(String fileName) throws SAXException, IOException, ParserConfigurationException {

        FileInputStream xmlFile = new FileInputStream(fileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        Node rootNode = doc.getDocumentElement();
        System.out.println("Root element: " + rootNode.getNodeName() + "\nStraße: " + rootNode.getAttributes().getNamedItem("street").getNodeValue());

        //Element elem = (Element) rootNode;
        //System.out.println("Name: " + elem.getAttribute("name") + "\nStraße: " + elem.getAttribute("street") + "\nPLZ: " + elem.getAttribute("zip"));
    }
}
