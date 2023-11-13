package com.example.dataloader.xmlreader.xml_entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimProduct {
  @JacksonXmlProperty(localName = "asin")
  public String asin;

  @JacksonXmlProperty(localName = "title")
  public String title;

}
