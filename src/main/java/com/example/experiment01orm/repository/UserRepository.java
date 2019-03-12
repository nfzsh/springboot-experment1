package com.example.experiment01orm.repository;
import com.example.experiment01orm.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UserRepository {
    @PersistenceContext
    private  EntityManager em;

    public void addUserAddress(){
        User user = new User("zsh");
        try {
            em.persist(user);
            System.out.println("user写入成功");
        }
        catch(Exception e){
            System.out.println("user写入失败");
        }
        Address address1 = new Address("9*");
        address1.setUser(user);
        em.persist(address1);

        Address address2 = new Address("74*");
        address2.setUser(user);
        em.persist(address2);
    }
}
