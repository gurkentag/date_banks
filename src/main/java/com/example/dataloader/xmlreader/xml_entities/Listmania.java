package com.example.dataloader.xmlreader.xml_entities;

import com.example.dataloader.xmlreader.xml_entities.ListItem;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Listmania {
  @JacksonXmlProperty(localName = "list")
  @JacksonXmlElementWrapper(useWrapping = false)
  public List<ListItem> lists;
}
