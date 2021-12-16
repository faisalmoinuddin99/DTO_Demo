package net.javaguide.springboot.services;

import net.javaguide.springboot.dto.UserLocationDTO;
import net.javaguide.springboot.model.User;
import net.javaguide.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository ;

    public List<UserLocationDTO> getAllUsersLocation(){

        return userRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }

     private  UserLocationDTO convertEntityToDto(User user){
        UserLocationDTO userLocationDTO = new UserLocationDTO() ;
        userLocationDTO.setUserId(user.getUserId());
        userLocationDTO.setEmail(user.getEmail());
        userLocationDTO.setPlace(user.getLocation().getPlace());
        userLocationDTO.setLatitude(user.getLocation().getLatitude());
        userLocationDTO.setLongitude(user.getLocation().getLongitude());

        return userLocationDTO ;
     }
}
