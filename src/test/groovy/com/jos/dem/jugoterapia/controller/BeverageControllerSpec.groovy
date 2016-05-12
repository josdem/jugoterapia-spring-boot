package com.jos.dem.jugoterapia.controller

import spock.lang.Specification

import com.jos.dem.jugoterapia.model.Category
import com.jos.dem.jugoterapia.service.BeverageService

class BeverageControllerSpec extends Specification {

  BeverageController controller = new BeverageController()

  BeverageService beverageService = Mock(BeverageService)

  def setup(){
    controller.beverageService = beverageService
  }

  void "should get categories"(){
    given:"An categories"
      List<Category> categories = [new Category(id:1,name:'Curativos'), new Category(id:2,name:"Energetizantes")]
    when:"We get catetories"
      beverageService.categories() >> categories
      List<Category> result = controller.categories()
      println result
    then:"We expect categories"
      result.size() == 2
  }

}
