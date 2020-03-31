/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.service;

import co.edu.utp.isc.gia.restuser.web.UserDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author CJ
 */
@Service
public class UserService {
        private List<UserDto> users = new ArrayList<>();

        
    public UserDto save( UserDto user) {
        user.setId(users.size() + 1L);
        user.setUsername(user.getUsername().toLowerCase());
        users.add(user);
        return user;
    }
    
    public List<UserDto> listAll() {
        return users;
    }
    
    public UserDto findOne(
             Long id
    ) {
        return users.get(id.intValue() - 1);
    }
}
