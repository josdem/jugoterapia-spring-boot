package com.jos.dem.jugoterapia.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Column
import javax.persistence.ManyToOne
import javax.persistence.JoinColumn
import javax.persistence.FetchType
import javax.persistence.CascadeType
import com.fasterxml.jackson.annotation.JsonIgnore

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

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="category_id")
  @JsonIgnore
  Category category

}
