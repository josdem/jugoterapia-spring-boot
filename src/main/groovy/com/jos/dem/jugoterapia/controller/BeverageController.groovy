package com.jos.dem.jugoterapia.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@RestController
class BeverageController {

  @RequestMapping("/")
  String index(){
    'Hello from Jugoterapia'
  }

}
