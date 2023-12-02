package com.lito.taller.repository;

import com.lito.taller.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends  JpaRepository<Client, Long>{

}
