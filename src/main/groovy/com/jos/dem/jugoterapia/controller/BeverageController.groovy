package com.jos.dem.jugoterapia.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.beans.factory.annotation.Autowired

import com.jos.dem.jugoterapia.service.BeverageService
import com.jos.dem.jugoterapia.model.Category
import com.jos.dem.jugoterapia.model.Beverage

@Controller
class BeverageController {

  @Autowired
  BeverageService beverageService

  @RequestMapping("categories")
  @ResponseBody
  List<Category> categories(){
    beverageService.categories()
  }

  @RequestMapping("beverages")
  @ResponseBody
  List<Beverage> beverage(@RequestParam("categoryId") Long categoryId){
    beverageService.findByCategory(categoryId)
  }


}
