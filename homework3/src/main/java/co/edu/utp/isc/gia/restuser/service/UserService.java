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
    SortedMap<Long, UserDto> users = new TreeMap<>(); 
    
    public UserService(UserRepository userRepository, ModelMapper modelMapper)
    {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }    
    public UserDto save(UserDto user) {
        
        User  myUser = modelMapper.map(user, User.class);
        myUser = userRepository.save(myUser);
        UserDto resp = modelMapper.map(myUser, UserDto.class);
        
//        return resp;
        if (users.isEmpty()) user.setId(1L);
        else user.setId(users.lastKey() + 1L);
        user.setUsername(user.getUsername().toLowerCase());
        return users.put(user.getId(), user);
    }
    
    public List<UserDto> listAll() {
        if (users.isEmpty()) return null;
        
        ArrayList<UserDto> valueList = new ArrayList<>(users.values());
        return valueList;
    }
    
    public UserDto findOne(Long id) {
        return users.get(id);       
    }
    
    public UserDto update(long id, UserDto user) {
        user.setId(id);
        return users.replace(id, user);
    }
    
    public UserDto delete(Long id) {
        return users.remove(id);
    }
}
