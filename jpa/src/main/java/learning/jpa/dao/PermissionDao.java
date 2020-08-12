package learning.jpa.dao;

import learning.jpa.bean.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname PermissionDao
 * @Description TODO
 * @Date 2020/8/12 5:34 下午
 * @Author z7-x
 */
@Repository
public interface PermissionDao extends JpaRepository<Permission,Long> {
}
