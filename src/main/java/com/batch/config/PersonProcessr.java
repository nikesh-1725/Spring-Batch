package com.batch.config;

import com.batch.entity.Person;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.adapter.ItemProcessorAdapter;

public class PersonProcessr implements ItemProcessor<Person,Person> {
    @Override
    public Person process(Person item) throws Exception {
        item.setFirstName(item.getFirstName().toUpperCase());
        item.setLastName(item.getLastName().toUpperCase());

        return item;
    }
}
