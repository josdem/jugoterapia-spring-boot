package com.jos.dem.jugoterapia.service

import com.jos.dem.jugoterapia.model.Category
import com.jos.dem.jugoterapia.model.Beverage

interface BeverageService {
  List<Category> categories()
  List<Beverage> findByCategory(Long categoryId)
  Beverage findById(Long beverageId)
}
