package com.example.dataloader.xmlreader.xml_entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Price {
  @JacksonXmlProperty(isAttribute = true)
  public String mult;

  @JacksonXmlProperty(isAttribute = true)
  public String state;

  @JacksonXmlProperty(isAttribute = true)
  public String currency;

  @JacksonXmlText
  public Integer value;
}
