package com.mooage.postfacto.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.mooage.postfacto.repositories.ItemRepository
import com.mooage.postfacto.repositories.RetroRepository
import com.mooage.postfacto.types.Category
import com.mooage.postfacto.types.Item
import com.mooage.postfacto.types.Retro
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class Mutation(@Autowired val retroRepository: RetroRepository,
               @Autowired val itemRepository: ItemRepository
               ) : GraphQLMutationResolver {

    fun newRetro(name: String): Retro {
        val retro = Retro(name = name, items = emptyList())
        return retroRepository.save(retro)
    }

    fun newItem(retroId: Long, category: Category, description: String): Item {
        val retro = retroRepository.findById(retroId)
        val item = Item(category = category, description = description, retro = retro.get())
        return itemRepository.save(item)
    }
}