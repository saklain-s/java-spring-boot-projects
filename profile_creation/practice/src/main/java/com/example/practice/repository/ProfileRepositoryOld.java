//package com.example.practice.repository;
//
//
//import com.example.practice.model.Profile;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class ProfileRepository {
//
//    private final Map<String, Profile> store = new HashMap<>();
//
//    public void save(Profile profile){store.put(profile.getId(),profile);
//    }
//
//    public Profile findById(String id){
//        return store.get(id);
//    }
//
//    public List<Profile> findAll(){
//        return new ArrayList<>(store.values());
//    }
//
//    public void delete(String id){
//        store.remove(id);
//    }
//}
