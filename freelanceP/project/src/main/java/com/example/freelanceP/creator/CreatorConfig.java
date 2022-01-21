package com.example.freelanceP.creator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration //this is a configuration file
public class CreatorConfig {
    //so that this runs
    @Bean
    CommandLineRunner commandLineRunner(CreatorRepository repository){
        return args ->{
            //the following are two creators
            Creator oliver = new Creator(
                    1L,
                    "oliver",
                    "0882748301",
                    "oli",
                    "olivernyirongo@gmail.com",
                    LocalDate.of(2000, Month.JUNE, 5),
                    /*removed age*/
                    "1234567"
            );
            Creator john = new Creator(

                    "john",
                    "082346688",
                    "jo",
                    "john@gmail.com",
                    LocalDate.of(2004, Month.JUNE, 5),
                    /*removed age*/
                    "1234567"
            );
            //thus his will be saved in the database as follows
            //save all to save in database take a list
            repository.toString();
        };
    }

}
