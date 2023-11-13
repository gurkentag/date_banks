package com.example.dataloader.xmlreader.xml_entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Labels {
  @JacksonXmlProperty(localName = "label")
  @JacksonXmlElementWrapper(useWrapping = false)
  public Label label;
}
