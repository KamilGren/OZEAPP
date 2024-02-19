//package pl.gren.oze_app.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import pl.gren.oze_app.model.Client;
//import pl.gren.oze_app.model.Role;
//import pl.gren.oze_app.model.user.User;
//import pl.gren.oze_app.repository.ClientRepository;
//import pl.gren.oze_app.repository.RoleRepository;
//import pl.gren.oze_app.repository.UserRepository;
//
//import javax.management.relation.RoleNotFoundException;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ClientService {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    ClientRepository clientRepository;
//
//
//    public ClientService(UserRepository userRepository, ClientRepository clientRepository) {
//
//        this.userRepository = userRepository;
//        this.clientRepository = clientRepository;
//    }
//
//    public List<User> listAll() { return userRepository.findAll(); }
//
////    public Optional<Client> findById(Integer id) {
////        return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client" + id + " not found!"));
////    }
//
//    public Optional<Client> findByName(String clientName) { return clientRepository.findByName(clientName); }
//
//    public Client saveClient(Client client) {
//        return clientRepository.save(client);
//    }
//
//    public User getUser(String userName) {
//        return userRepository.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException("User" + userName + " not found!"));
//    }
//
//}
