package com.jos.dem.jugoterapia.repository

import org.springframework.data.repository.CrudRepository
import com.jos.dem.jugoterapia.model.Category

interface CategoryRepository extends CrudRepository<Category,Long> {
}
