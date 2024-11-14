package pers.leannef.random_facts_api.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pers.leannef.random_facts_api.model.Fact
import pers.leannef.random_facts_api.repo.Fact_repo
import kotlin.jvm.optionals.getOrNull

@Service
class Fact_service(
    @Autowired val factRepo: Fact_repo
) {
    fun getRandFact():Fact?{
        return factRepo.getRandomFact().getOrNull()
    }

    fun getRandFactByCategory(category: String) : Fact?{
        return factRepo.getRandomFactByCategory(category).getOrNull()
    }

    fun saveFact(Fact:Fact):Fact?{
        return factRepo.save(Fact)
    }

    fun getFactById(factId:Int):Fact?{
        return factRepo.getFactById(factId).getOrNull()
    }
}