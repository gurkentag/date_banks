package com.example.dataloader.xmlreader.xml_entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Similars {
  @JacksonXmlProperty(localName = "sim_product")
  @JacksonXmlElementWrapper(useWrapping = false)
  public List<SimProduct> simProducts;

  @JacksonXmlProperty(localName = "item")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<String> similarItems;
}
