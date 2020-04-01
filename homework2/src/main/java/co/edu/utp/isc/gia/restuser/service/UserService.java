/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.service;

import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author CJ
 */
@Service
public class UserService {
    
    SortedMap<Long, UserDto> users = new TreeMap<>(); 
        
    public UserDto save(UserDto user) {
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
        return users.replace(id, user);
    }
    
    public UserDto delete(Long id) {
        return users.remove(id);
    }
}
