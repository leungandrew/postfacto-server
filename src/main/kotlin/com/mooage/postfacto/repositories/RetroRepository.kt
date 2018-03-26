package com.mooage.postfacto.repositories

import com.mooage.postfacto.types.Retro
import org.springframework.data.repository.CrudRepository

interface RetroRepository : CrudRepository<Retro, Long>
