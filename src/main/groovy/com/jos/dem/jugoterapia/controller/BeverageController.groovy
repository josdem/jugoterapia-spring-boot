/*
  Copyright 2017 José Luis De la Cruz Morales <joseluis.delacruz@gmail.com>

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
  List<Beverage> beverages(@RequestParam("categoryId") Long categoryId){
    beverageService.findByCategory(categoryId)
  }

  @RequestMapping("beverage")
  @ResponseBody
  Beverage beverage(@RequestParam("beverageId") Long beverageId){
    beverageService.findById(beverageId)
  }

}
