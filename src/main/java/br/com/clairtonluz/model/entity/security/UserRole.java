package br.com.clairtonluz.model.entity.security;

import br.com.clairtonluz.model.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author clairton
 */
@Entity
@Table(name = "user_role")
public class UserRole extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_role_id_seq")
    @SequenceGenerator(name = "user_role_id_seq", sequenceName = "user_role_id_seq")
    private Integer id;
    @NotNull(message = "role é obrigatório")
    private String role;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
