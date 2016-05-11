package com.jos.dem.jugoterapia.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Column
import javax.persistence.OneToMany
import javax.persistence.FetchType
import javax.persistence.CascadeType

@Entity
class Category {

  @Id
  Long id

  @Column(nullable = false)
  String name

  @OneToMany(mappedBy="category", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
  List<Beverage> beverages

}
