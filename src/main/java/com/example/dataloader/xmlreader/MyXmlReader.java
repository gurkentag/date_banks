package com.example.dataloader.xmlreader;
import com.example.dataloader.xmlreader.categories_entities.Categories;
import com.example.dataloader.xmlreader.xml_entities.Shop;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;

@Service
public class MyXmlReader {
  public Shop parse(String xmlString) throws Exception {
    XmlMapper xmlMapper = new XmlMapper();
    //parse string into an object of type shop
    Shop shop = xmlMapper.readValue(xmlString, Shop.class);
    System.out.println(shop.getItem().size());
    return shop;
  }

  public Categories parseCategories(String xmlString) throws Exception {
    XmlMapper xmlMapper = new XmlMapper();
    //parse string into an object of type categories
    Categories categories = xmlMapper.readValue(xmlString, Categories.class);
    System.out.println(categories.getCategories().size());
    return categories;
  }
}
