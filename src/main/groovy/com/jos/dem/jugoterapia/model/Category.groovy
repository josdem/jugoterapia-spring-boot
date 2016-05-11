package com.jos.dem.jugoterapia.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Column

@Entity
class Category {

  @Id
  Long id

  @Column(nullable = false)
  String name

}
