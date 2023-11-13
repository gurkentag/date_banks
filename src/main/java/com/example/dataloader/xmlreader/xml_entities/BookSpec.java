package com.example.dataloader.xmlreader.xml_entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookSpec {
  @JacksonXmlProperty(localName = "binding")
  public String binding;

  @JacksonXmlProperty(localName = "edition")
  public Edition edition;

  @JacksonXmlProperty(localName = "isbn")
  public Isbn isbn;

  @JacksonXmlProperty(localName = "package")
  public Package packageType;

  @JacksonXmlProperty(localName = "pages")
  public int pages;

  @JacksonXmlProperty(localName = "publication")
  public Publication publication;
}
