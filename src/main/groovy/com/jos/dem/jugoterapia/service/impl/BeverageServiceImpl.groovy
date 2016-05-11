package com.jos.dem.jugoterapia.impl.service

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

import com.jos.dem.jugoterapia.service.BeverageService
import com.jos.dem.jugoterapia.repository.CategoryRepository
import com.jos.dem.jugoterapia.model.Category

@Service
class BeverageServiceImpl implements BeverageService {

  @Autowired
  CategoryRepository repository

  List<Category> categories(){
    repository.findAll()
  }

}
