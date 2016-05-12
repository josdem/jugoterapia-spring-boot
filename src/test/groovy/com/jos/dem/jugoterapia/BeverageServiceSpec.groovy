package com.jos.dem.jugoterapia

import spock.lang.Specification

import com.jos.dem.jugoterapia.model.Category
import com.jos.dem.jugoterapia.model.Beverage
import com.jos.dem.jugoterapia.service.BeverageService
import com.jos.dem.jugoterapia.service.impl.BeverageServiceImpl
import com.jos.dem.jugoterapia.repository.CategoryRepository
import com.jos.dem.jugoterapia.repository.BeverageRepository

class BeverageServiceSpec extends Specification {

  BeverageService service = new BeverageServiceImpl()

  CategoryRepository categoryRepository = Mock(CategoryRepository)
  BeverageRepository beverageRepository = Mock(BeverageRepository)

  def setup(){
    service.categoryRepository = categoryRepository
    service.beverageRepository = beverageRepository
  }

  void "should find categories"(){
    given:"A categories"
      Category categoryOne = new Category(id:1,name:'Curativos')
      Category categoryTwo = new Category(id:2,name:"Energetizantes")
      List<Category> categories = [categoryOne, categoryTwo]
    when:"We look for categories"
      categoryRepository.findAll() >> categories
      List<Category> result =  service.categories()
    then:"We expect categories"
      result.size() == 2
      result.contains(categoryOne)
      result.contains(categoryTwo)
  }

  void "should get beverages by category"(){
    given:"Two beverages"
      Beverage beverageOne = new Beverage()
      Beverage beverageTwo = new Beverage()
    and:"A category"
      Long categoryId = 1L
      Category category = new Category(id:categoryId)
    when:"We get beverages by category"
      categoryRepository.findOne(categoryId) >> category
      beverageRepository.findByCategory(category) >> [beverageOne, beverageTwo]
      List<Beverage> result = service.findByCategory(categoryId)
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
      beverageRepository.findOne(beverageId) >> beverage
      Beverage result = service.findById(beverageId)
    then:"We expect beverage"
     result instanceof Beverage
     result.id == beverageId
  }

}

