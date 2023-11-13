package com.example.dataloader.xmlreader.xml_entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DvdSpec {
  @JacksonXmlProperty(localName = "aspectratio")
  public String aspectRatio;

  @JacksonXmlProperty(localName = "format")
  public String format;

  @JacksonXmlProperty(localName = "regioncode")
  public String regionCode;

  @JacksonXmlProperty(localName = "releasedate")
  public String releaseDate;

  @JacksonXmlProperty(localName = "runningtime")
  public String runningTime;

  @JacksonXmlProperty(localName = "theatr_release")
  public String theatricalRelease;

  @JacksonXmlProperty(localName = "upc")
  public Upc upc;
}
