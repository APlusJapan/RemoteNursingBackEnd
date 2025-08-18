
package com.aplus.repository;

import com.aplus.entity.PointRuleTaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PointRuleTaskTypeRepository extends JpaRepository<PointRuleTaskType, String> {
    // taskTypeで検索
    PointRuleTaskType findByTaskType(String taskType);
    // 削除されていない全件取得
    List<PointRuleTaskType> findByIsDeletedFalse();
}
