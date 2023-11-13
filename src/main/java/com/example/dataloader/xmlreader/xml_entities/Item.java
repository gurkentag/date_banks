package com.example.dataloader.xmlreader.xml_entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Item {
  @JacksonXmlProperty(isAttribute = true)
  public String pgroup;

  @JacksonXmlProperty(isAttribute = true)
  public String asin;

  @JacksonXmlProperty(isAttribute = true)
  public Integer salesrank;

  @JacksonXmlProperty(isAttribute = true)
  public String ean;

  @JacksonXmlProperty(isAttribute = true)
  public String state;

  @JacksonXmlProperty(isAttribute = true)
  public String picture;

  @JacksonXmlProperty(isAttribute = true)
  public String detailpage;

  @JacksonXmlProperty(localName = "price")
  public Price price;

  @JacksonXmlProperty(localName = "details")
  public Details details;

  @JacksonXmlProperty(localName = "title")
  public String title;

  @JacksonXmlProperty(localName = "bookspec")
  public BookSpec bookSpec;

  @JacksonXmlProperty(localName = "dvdspec")
  public DvdSpec dvdSpec;

  @JacksonXmlProperty(localName = "musicspec")
  public MusicSpec musicSpec;

  @JacksonXmlProperty(localName = "labels")
  public Labels labels;

  @JacksonXmlProperty(localName = "publishers")
  public Publishers publishers;

  @JacksonXmlProperty(localName = "studios")
  public Studios studios;

  @JacksonXmlProperty(localName = "similars")
  public Similars similars;

  @JacksonXmlProperty(localName = "tracks")
  public Tracks tracks;

  @JacksonXmlProperty(localName = "audiotext")
  public AudioText audioText;

  @JacksonXmlProperty(localName = "listmania")
  public Listmania listmania;

  @JacksonXmlProperty(localName = "actors")
  public Actors actors;

  @JacksonXmlProperty(localName = "artists")
  public Artists artists;

  @JacksonXmlProperty(localName = "authors")
  public Authors authors;

  @JacksonXmlProperty(localName = "creators")
  public Creators creators;

  @JacksonXmlProperty(localName = "directors")
  public Directors directors;
}
