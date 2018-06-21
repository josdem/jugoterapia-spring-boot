/*
  Copyright 2018 José Luis De la Cruz Morales <joseluis.delacruz@gmail.com>
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

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

  BeverageRepository beverageRepository = Mock(BeverageRepository)

  def setup(){
    service.beverageRepository = beverageRepository
  }

  void "should get beverages by category"(){
    given:"Two beverages"
      Beverage beverageOne = new Beverage()
      Beverage beverageTwo = new Beverage()
    and:"A category"
      Long categoryId = 1L
      Category category = new Category(id:categoryId)
    when:"We get beverages by category"
      beverageRepository.findByCategory(category) >> [beverageOne, beverageTwo]
      List<Beverage> result = service.findByCategory(category)
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
      beverageRepository.findById(beverageId) >> beverage
      Beverage result = service.findById(beverageId)
    then:"We expect beverage"
     result instanceof Beverage
     result.id == beverageId
  }

}

