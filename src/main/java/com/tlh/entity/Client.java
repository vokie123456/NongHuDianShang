package com.tlh.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

@XStreamAlias("client")
public class Client
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String url;
  private int version;
  private String description;

  public String getUrl()
  {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public int getVersion() {
    return this.version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}