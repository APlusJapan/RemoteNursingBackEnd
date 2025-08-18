package com.aplus.repository;

import com.aplus.entity.UserPointRedeem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserPointRedeemRepository extends JpaRepository<UserPointRedeem, Long> {
    List<UserPointRedeem> findByUserIdOrderByCreateTimeDesc(String userId);
}
