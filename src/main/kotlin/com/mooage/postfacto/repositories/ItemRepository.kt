package com.mooage.postfacto.repositories

import com.mooage.postfacto.types.Item
import org.springframework.data.repository.CrudRepository

interface ItemRepository: CrudRepository<Item, Long>
