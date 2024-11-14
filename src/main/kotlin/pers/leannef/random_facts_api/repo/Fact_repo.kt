package pers.leannef.random_facts_api.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import pers.leannef.random_facts_api.model.Fact
import java.util.*

@org.springframework.stereotype.Repository
interface Fact_repo : JpaRepository<Fact, Int> {
    @Query("SELECT f FROM Fact f ORDER BY RAND() LIMIT 1")
    fun getRandomFact() : Optional<Fact>

    fun getFactById(factId: Int) : Optional<Fact>

    @Query("SELECT f FROM Fact f WHERE f.category = ?1 ORDER BY RAND() LIMIT 1")
    fun getRandomFactByCategory(category: String): Optional<Fact>
}