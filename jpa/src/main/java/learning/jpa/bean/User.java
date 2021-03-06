package learning.jpa.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import learning.jpa.bean.basis.BaseBusEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Classname User
 * @Description 用户表
 * @Date 2020/8/12 2:38 下午
 * @Author z7-x
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LEARN_USER")
@ApiModel(description = "用户信息")
public class User extends BaseBusEntity {
    @Id
    @Column(name = "USER_ID")
    @GenericGenerator(name = "idGenerator",strategy = "uuid")
    @GeneratedValue(generator="idGenerator")
    @ApiModelProperty(value = "用户编号")
    private String userId;

    @NotNull(message = "用户名不能为空")
    @Column(name = "USER_NAME", nullable = false, length = 10)
    @ApiModelProperty(value = "用户名称")
    private String userName;

    @NotNull(message = "密码不能为空")
    @ApiModelProperty(value = "用户密码")
    @Column(name = "PASS_WORD", nullable = false, length = 32)
    private String passWord;

    @ManyToMany(targetEntity = Role.class, fetch = FetchType.LAZY)
    @JoinTable(name = "LEARN_USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID"))
    private List<Role> roles;
}
