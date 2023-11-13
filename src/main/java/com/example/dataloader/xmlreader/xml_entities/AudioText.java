package com.example.dataloader.xmlreader.xml_entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AudioText {
  @JacksonXmlProperty(localName = "language")
  @JacksonXmlElementWrapper(useWrapping = false)
  public List<Language> languages;

  @JacksonXmlProperty(localName = "audioformat")
  @JacksonXmlElementWrapper(useWrapping = false)
  public List<String> audioFormats;
}
