package it.prova.spring.boot;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserTable, Integer> {

}
