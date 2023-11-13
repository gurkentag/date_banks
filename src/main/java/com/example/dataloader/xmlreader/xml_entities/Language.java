package com.example.dataloader.xmlreader.xml_entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Language {
  @JacksonXmlProperty(isAttribute = true)
  public String type;

  @JacksonXmlText
  public String value;
}
