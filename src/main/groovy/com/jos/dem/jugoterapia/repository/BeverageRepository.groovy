package com.jos.dem.jugoterapia.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

import com.jos.dem.jugoterapia.model.Beverage
import com.jos.dem.jugoterapia.model.Category

interface BeverageRepository extends CrudRepository<Beverage,Long> {
  List<Beverage> findByCategory(@Param("category") Category category)
}
