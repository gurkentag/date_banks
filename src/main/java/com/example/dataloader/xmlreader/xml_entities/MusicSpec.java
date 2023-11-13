package com.example.dataloader.xmlreader.xml_entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MusicSpec {
  @JacksonXmlProperty(localName = "binding")
  public String binding;

  @JacksonXmlProperty(localName = "format")
  public Format format;

  @JacksonXmlProperty(localName = "num_discs")
  public String numDiscs;

  @JacksonXmlProperty(localName = "releasedate")
  public String releaseDate;

  @JacksonXmlProperty(localName = "upc")
  public Upc upc;
}
