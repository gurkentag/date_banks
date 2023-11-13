package com.example.dataloader.xmlreader.xml_entities;

import com.example.dataloader.xmlreader.xml_entities.Item;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JacksonXmlRootElement(localName = "shop")
public class Shop {
  @JacksonXmlProperty(isAttribute = true)
  public String name;

  @JacksonXmlProperty(isAttribute = true)
  public String street;

  @JacksonXmlProperty(isAttribute = true)
  public String zip;

  @JacksonXmlProperty(localName = "item")
  @JacksonXmlElementWrapper(useWrapping = false)
  public List<Item> item;
}
