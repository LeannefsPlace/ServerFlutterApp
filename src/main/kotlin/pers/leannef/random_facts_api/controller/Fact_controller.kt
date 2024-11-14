package pers.leannef.random_facts_api.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pers.leannef.random_facts_api.model.Fact
import pers.leannef.random_facts_api.service.Fact_service

@RestController
@CrossOrigin
class Fact_controller (
    @Autowired val factService: Fact_service
) {
    @GetMapping("/rand")
    public fun getRandom() : ResponseEntity<Fact>
    {
        val fact = factService.getRandFact();
        if (fact != null){
            val response = ResponseEntity.ok(fact);
            return response;
        }else{
            return ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/rand/{category}")
    public fun getRandomCategory(
        @PathVariable("category") category: String
    ) : ResponseEntity<Fact>
    {
        val fact = factService.getRandFactByCategory(category);
        if (fact != null){
            val response = ResponseEntity.ok(fact)
            return response;
        }else{
            return ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/{id}/{info}")
    public fun likeDislike(
        @PathVariable("id") id: Int,
        @PathVariable("info") info: String
    ) : ResponseEntity<Fact>
    {
        val fact = factService.getFactById(id);
        if (fact != null){
            val response = ResponseEntity.ok(fact.also { if(info == "like") it.grade ++ else if (info == "dislike") it.grade --; factService.saveFact(it) })
            return response;
        }else{
            return ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/")
    public fun addFact(
        @RequestBody fact: Fact
    ) : ResponseEntity<Fact>
    {
        val savedFact = factService.saveFact(fact);
        if (savedFact != null){
            val response = ResponseEntity.ok(savedFact);
            return response;
        }else{
            return ResponseEntity.notFound().build()
        }
    }
}