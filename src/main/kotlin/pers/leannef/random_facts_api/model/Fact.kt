package pers.leannef.random_facts_api.model

import jakarta.persistence.*

@Entity
@Table(name = "Fact")
class Fact(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id:Int?,
    val title:String,
    val category:String,
    val body:String,
    var grade:Int = 0
    )