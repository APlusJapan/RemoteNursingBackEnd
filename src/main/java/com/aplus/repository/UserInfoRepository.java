package com.aplus.repository;

import com.aplus.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
    List<UserInfo> findByUserType(String userType);
    List<UserInfo> findByPhone(String phone);
    // 必要に応じて追加
}
