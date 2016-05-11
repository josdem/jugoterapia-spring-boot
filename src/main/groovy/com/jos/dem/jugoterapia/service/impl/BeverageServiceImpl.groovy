package com.jos.dem.jugoterapia.impl.service

import org.springframework.stereotype.Service
import com.jos.dem.jugoterapia.service.BeverageService

import com.jos.dem.jugoterapia.model.Category

@Service
class BeverageServiceImpl implements BeverageService {

  List<Category> categories(){
    Category.findAll()
  }

}
