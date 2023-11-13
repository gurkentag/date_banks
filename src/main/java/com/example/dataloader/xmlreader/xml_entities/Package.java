package com.example.dataloader.xmlreader.xml_entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Package {
  @JacksonXmlProperty(isAttribute = true)
  public String weight;

  @JacksonXmlProperty(isAttribute = true)
  public String height;

  @JacksonXmlProperty(isAttribute = true)
  public String length;
}
