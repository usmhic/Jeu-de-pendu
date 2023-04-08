package com.example.messagingstompwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {


  @MessageMapping("/hello")
  @SendTo("/topic/greetings")
  
  public Greeting greeting(HelloMessage message) throws Exception {
    Jeu jeu = new Jeu();
    String word = jeu.getWord();
    HtmlUtils.htmlEscape(message.getName());

    return new Greeting("Your word is " + word);
  }

}