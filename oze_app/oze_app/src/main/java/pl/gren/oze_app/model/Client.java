//package pl.gren.oze_app.model;
//
//import jakarta.persistence.*;
//
//@Entity
//public class Client {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    public Client(Integer id, User user) {
//        this.id = id;
//        this.user = user;
//    }
//
//    public Client() {
//
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//}
