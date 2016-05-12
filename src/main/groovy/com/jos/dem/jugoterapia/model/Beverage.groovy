/*
  Copyright 2014
  José Luis De la Cruz Morales <joseluis.delacruz@gmail.com>
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

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
