package com.jos.dem.jugoterapia

import spock.lang.Specification

import com.jos.dem.jugoterapia.model.Category
import com.jos.dem.jugoterapia.model.Beverage
import com.jos.dem.jugoterapia.service.BeverageService
import com.jos.dem.jugoterapia.controller.BeverageController

class BeverageControllerSpec extends Specification {

  BeverageController controller = new BeverageController()

  BeverageService beverageService = Mock(BeverageService)

  def setup(){
    controller.beverageService = beverageService
  }

  void "should get categories"(){
    given:"A categories"
      Category categoryOne = new Category(id:1,name:'Curativos')
      Category categoryTwo = new Category(id:2,name:"Energetizantes")
      List<Category> categories = [categoryOne, categoryTwo]
    when:"We get catetories"
      beverageService.categories() >> categories
      List<Category> result = controller.categories()
    then:"We expect categories"
      result.size() == 2
      result.contains(categoryOne)
      result.contains(categoryTwo)
  }

  void "should get beverages by category"(){
    given:"Two beverages"
      Beverage beverageOne = new Beverage()
      Beverage beverageTwo = new Beverage()
    and:"A categoryId"
      Long categoryId = 1L
    when:"We get beverages by category"
      beverageService.findByCategory(categoryId) >> [beverageOne, beverageTwo]
      List<Beverage> result = controller.beverages(categoryId)
    then:
      result.size() == 2
      result.contains(beverageOne)
      result.contains(beverageTwo)
  }

  void "should get beverage by id"(){
    given:"A beverageId"
      Long beverageId = 1L
    and:"A beverage"
      Beverage beverage = new Beverage(id:beverageId)
    when:"We get an beverage by id"
      beverageService.findById(beverageId) >> beverage
      Beverage result = controller.beverage(beverageId)
    then:"We expect beverage"
     result instanceof Beverage
     result.id == beverageId
  }

}
