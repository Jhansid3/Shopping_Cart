package com.springboot.framework.Repository;

import com.springboot.framework.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order,Integer> {

    public void deleteByUserId(int user_id);
}
