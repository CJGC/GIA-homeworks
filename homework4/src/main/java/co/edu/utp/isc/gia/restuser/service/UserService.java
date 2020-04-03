/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.service;

import co.edu.utp.isc.gia.restuser.data.entity.User;
import co.edu.utp.isc.gia.restuser.data.repository.UserRepository;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author CJ
 */
@Service
public class UserService {
    
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    
    public UserService(UserRepository userRepository, ModelMapper modelMapper)
    {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    
    public UserDto save(UserDto user) {
                
        try {
            User auxUser;
            auxUser = userRepository.save(modelMapper.map(user, User.class));
            return modelMapper.map(auxUser, UserDto.class);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<UserDto> listAll() {
        ArrayList<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        
        List<UserDto> resp = new ArrayList<>();
        users.forEach( user -> {
            resp.add(modelMapper.map(user, UserDto.class));
        });
        return resp;
    }
    
    public UserDto findOne(Long id) {
        try {
            return modelMapper.map(userRepository.findById(id).get(), 
                UserDto.class);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public UserDto update(long id, UserDto user) {
        user.setId(id);
        try {
            userRepository.save(modelMapper.map(user, User.class));
            return user;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public UserDto delete(Long id) {
        
        try {
            UserDto user = modelMapper.map(userRepository.findById(id).get(), 
                    UserDto.class);
            userRepository.deleteById(id);
            return user;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
