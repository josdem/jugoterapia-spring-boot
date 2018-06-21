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

class CategoryServiceSpec extends Specification {

  CategoryService service = new CategoryServiceImpl()

  void "should find categories"(){
    given:"A categories"
      Category categoryOne = new Category(id:1,name:'Curativos')
      Category categoryTwo = new Category(id:2,name:"Energetizantes")
      List<Category> categories = [categoryOne, categoryTwo]
    when:"We look for categories"
      categoryRepository.findAll() >> categories
      List<Category> result =  service.findAll()
    then:"We expect categories"
      result.size() == 2
      result.contains(categoryOne)
      result.contains(categoryTwo)
  }

}
