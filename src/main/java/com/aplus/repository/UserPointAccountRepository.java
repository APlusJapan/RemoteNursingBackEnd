
package com.aplus.repository;

import com.aplus.entity.UserPointAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserPointAccountRepository extends JpaRepository<UserPointAccount, String> {
    // userIdで検索
    UserPointAccount findByUserId(String userId);
    // 削除されていない全件取得
    List<UserPointAccount> findByIsDeletedFalse();
}
