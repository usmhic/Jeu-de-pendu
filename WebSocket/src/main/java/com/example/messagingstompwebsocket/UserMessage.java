package com.example.messagingstompwebsocket;

public class UserMessage {

  private String name;

  public UserMessage() {
  }

  public UserMessage(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

