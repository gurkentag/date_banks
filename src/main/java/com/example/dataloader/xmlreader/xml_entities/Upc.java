package com.example.dataloader.xmlreader.xml_entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Upc {
  @JacksonXmlText
  public String value;

  @JacksonXmlProperty(isAttribute = true)
  public String val;
}
