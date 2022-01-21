package com.example.freelanceP.creator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
//@Component are same thing but for more readable
public class CreatorService {

    private final CreatorRepository creatorRepository;
//this ill replace a manual list
    @Autowired
    public CreatorService(CreatorRepository creatorRepository) {
        this.creatorRepository = creatorRepository;
    }

    public List<Creator> getCreator(){
        //returns a list
       return creatorRepository.findAll();
    }
        //from creator controller
    public void addNewCreator(Creator creator) {
        Optional<Creator> creatorOptional = creatorRepository
                .findCreatorByEmail(creator.getEmail());
        if(creatorOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        creatorRepository.save(creator);
    }

    public void deleteCreator(Long creatorID) {
        boolean exists = creatorRepository.existsById(creatorID);
        if(!exists){
            throw new IllegalStateException(
                "creator with id "+creatorID+ "does not exists");
        }
        creatorRepository.deleteById(creatorID);
    }
    @Transactional
    public void updatecreator(Long creatorID, String name, String email) {
        Creator creator = creatorRepository.findById(creatorID)
                .orElseThrow(() ->new IllegalStateException(
                        "creator with id "+creatorID+ "does not exist"
                ));
        if(name != null && !Objects.equals(creator.getName(),name)){
            creator.setName(name);
        }
        if (email != null && email.length()> 0 && !Objects.equals(creator.getEmail(),email)){
            Optional<Creator> creatorOptional=creatorRepository.findCreatorByEmail(email);

            if(creatorOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            //update functionality
            creator.setEmail(email);
        }
    }
}
