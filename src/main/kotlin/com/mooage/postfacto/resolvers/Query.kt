package com.mooage.postfacto.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.mooage.postfacto.repositories.RetroRepository
import com.mooage.postfacto.types.Retro
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class Query(@Autowired val retroRepository: RetroRepository) : GraphQLQueryResolver {

    fun retro(id: Long): Optional<Retro> {
        return retroRepository.findById(id)
    }

}