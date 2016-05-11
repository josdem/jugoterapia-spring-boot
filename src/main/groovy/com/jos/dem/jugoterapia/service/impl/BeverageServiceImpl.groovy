package com.jos.dem.jugoterapia.impl.service

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

import com.jos.dem.jugoterapia.service.BeverageService
import com.jos.dem.jugoterapia.repository.CategoryRepository
import com.jos.dem.jugoterapia.repository.BeverageRepository
import com.jos.dem.jugoterapia.model.Category
import com.jos.dem.jugoterapia.model.Beverage

@Service
class BeverageServiceImpl implements BeverageService {

  @Autowired
  CategoryRepository categoryRepository
  @Autowired
  BeverageRepository beverageRepository

  List<Category> categories(){
    categoryRepository.findAll()
  }

  List<Beverage> findByCategory(Long categoryId){
    Category category = categoryRepository.findOne(categoryId)
    beverageRepository.findByCategory(category)
  }

}
