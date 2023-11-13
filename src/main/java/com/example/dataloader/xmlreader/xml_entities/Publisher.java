package com.example.dataloader.xmlreader.xml_entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Publisher {
  @JacksonXmlProperty(isAttribute = true)
  public String name;

  @JacksonXmlText
  public String value;
}
