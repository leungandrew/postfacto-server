package com.mooage.postfacto.types

import javax.persistence.*

@Entity
@Table(name = "items")
data class Item(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        @Column
        var category: Category,
        @Column
        var description: String,
        @ManyToOne(optional = false)
        @JoinColumn(name = "retro_id")
        val retro: Retro? = null
)