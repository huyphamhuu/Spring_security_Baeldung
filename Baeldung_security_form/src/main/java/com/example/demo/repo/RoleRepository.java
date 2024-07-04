package com.example.demo.repo;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Role;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleRepository extends CrudRepository<Role,String>{
}
