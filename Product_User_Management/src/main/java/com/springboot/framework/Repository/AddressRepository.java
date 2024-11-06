package com.springboot.framework.Repository;

import com.springboot.framework.Entity.Address;
import com.springboot.framework.Entity.AddressPk;
import com.springboot.framework.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AddressRepository extends JpaRepository<Address, AddressPk> {

    @Modifying
    public void deleteByAddressPk_UserId(int user_id);
}
