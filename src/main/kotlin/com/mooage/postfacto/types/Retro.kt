package com.mooage.postfacto.types

import javax.persistence.*

@Entity
@Table(name = "retros")
data class Retro(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        @Column
        var name: String,
        @OneToMany(fetch = FetchType.EAGER, cascade = [(CascadeType.ALL)], mappedBy = "retro")
        var items: List<Item>
)