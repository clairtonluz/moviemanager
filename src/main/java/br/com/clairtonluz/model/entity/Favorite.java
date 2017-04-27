package br.com.clairtonluz.model.entity;


import javax.persistence.*;

@Entity
@Table(name = "favorite")
public class Favorite extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "favorite_id_seq")
    @SequenceGenerator(name = "favorite_id_seq", sequenceName = "favorite_id_seq")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;

    @OneToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
