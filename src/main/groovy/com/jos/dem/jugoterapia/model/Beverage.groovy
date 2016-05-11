package com.jos.dem.jugoterapia.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Column
import javax.persistence.ManyToOne
import javax.persistence.JoinColumn
import javax.persistence.FetchType
import javax.persistence.CascadeType

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

  @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
  @JoinColumn(name="category_id")
  Category category

}
