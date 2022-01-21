package com.example.freelanceP.creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/creator")
public class CreatorController {
    //will have all resources for our api

    //create a reference
    private final CreatorService creatorService;
    //add its constructor

    @Autowired //this creator service will be autowired and instanciated and injected into this contructor
    public CreatorController(CreatorService creatorService) {
        this.creatorService = creatorService;
    }

    @GetMapping
    public List<Creator> getCreator(){
            return creatorService.getCreator();
    }
    @PostMapping
    //we take a request body and map it to the creator
    public void registerNewCreators(@RequestBody Creator creator){
        creatorService.addNewCreator(creator);
    }
    @DeleteMapping(path="{creatorID}")
    public void deleteCreator(@PathVariable("creatorID") Long creatorID){
        creatorService.deleteCreator(creatorID);
    }

    @PutMapping(path = {"creatorID"})
    public void updatecreator(
            @PathVariable("creatorID") Long creatorID,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ){
        creatorService.updatecreator(creatorID,name,email);
    }
}
