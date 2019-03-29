package com.example.demo;

import java.util.Iterator;
import java.util.List;


public abstract class People <PersonType extends Person> implements Iterable<PersonType> {
    List<PersonType> personList;

    public People(List<PersonType> personList) {
        this.personList = personList;
    }

    public void add(PersonType person){
        personList.add(person);
    }
    public void remove(PersonType person){
        personList.remove(person);
    }
    public Integer size(){
        return personList.size();
    }
    public void clear(){
        personList.clear();
    }
    public void addAll(Iterable<PersonType> iterable){
        iterable.forEach(l -> personList.add(l));
    }

    public PersonType findById(Long id){
        return personList.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }

    public List<PersonType> findAll(){
        return this.personList;
    }

    @Override
    public Iterator<PersonType> iterator() {
        return personList.iterator();
    }
}
