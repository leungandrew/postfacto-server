package com.mooage.postfacto.resolvers

import com.mooage.postfacto.repositories.ItemRepository
import com.mooage.postfacto.repositories.RetroRepository
import com.mooage.postfacto.types.Category
import com.mooage.postfacto.types.Item
import com.mooage.postfacto.types.Retro
import com.nhaarman.mockito_kotlin.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
internal class MutationTest {

    @Mock
    lateinit var mockRetroRepository: RetroRepository

    @Mock
    lateinit var mockItemRepository: ItemRepository

    lateinit var subject: Mutation

    @Before
    fun setup() {
        subject = Mutation(mockRetroRepository, mockItemRepository)
    }

    @Test
    fun when_mutatingNewItem_createsItem() {
        val retro = Retro(1L, "retro", emptyList())
        whenever(mockRetroRepository.findById(1L)).thenReturn(Optional.of(retro))
        whenever(mockItemRepository.save(any<Item>())).thenReturn(mock())

        subject.newItem(1L, Category.HAPPY, "some description")
        argumentCaptor<Item>().apply {
            verify(mockItemRepository).save(capture())

            assertThat(allValues.size).isEqualTo(1)
            assertThat(firstValue.retro).isEqualTo(retro)
            assertThat(firstValue.category).isEqualTo(Category.HAPPY)
            assertThat(firstValue.description).isEqualTo("some description")
        }
    }

    @Test
    fun when_mutatingNewRetro_createsRetro() {
        whenever(mockRetroRepository.save(any<Retro>())).thenReturn(mock())
        subject.newRetro("retro")
        argumentCaptor<Retro>().apply {
            verify(mockRetroRepository).save(capture())

            assertThat(firstValue.items).isEmpty()
            assertThat(firstValue.name).isEqualTo("retro")
        }
    }
}