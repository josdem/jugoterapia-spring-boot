package com.jos.dem.jugoterapia.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Column
import javax.persistence.ManyToOne

@Entity
class Beverage {

  @Id
  Long id

  @Column(nullable = false)
  String name
  @Column(nullable = false)
  String ingredients
  @Column(nullable = false)
  String recipe

  @ManyToOne
  Category category

}
