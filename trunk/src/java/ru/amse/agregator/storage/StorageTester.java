package ru.amse.agregator.storage;
import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;

import org.bson.types.ObjectId;



public class StorageTester {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
    	
   
        Database.connectToMainBase();  
        //Database.unificationNames();
        
        User user = new User();
        user.setKeyValue(User.FIELD_LOGIN, "aaaa");
        user.setKeyValue(User.FIELD_NAME, "Name");
        Database.addUser(user);
        ArrayList<User> users = Database.getAllUsers();
        User user1 = new User();
        user1.setKeyValue(User.FIELD_LOGIN, "affffff");
        user1.setKeyValue(User.FIELD_NAME, "Name");
        Database.addUser(user1);
       
        ArrayList<DBWrapper> collectionUsers = Database.getAllDBObjects();
        int k = 0;
//        ObjectId nullContinent = Database.getContinentIdByName("");
//        System.out.println(nullContinent);
//        ///*
//        ArrayList<DBWrapper> countries = Database.getAllCountriesByContinent(nullContinent);
//        for(DBWrapper country : countries){
//        	ArrayList<DBWrapper> cities = Database.getAllCitiesByCountry(country.getId());
//        	for(DBWrapper city : cities){
//        		Database.removeAllWithKeyValue(DBWrapper.TYPE_ATTRACTION, DBWrapper.FIELD_CITY_ID, city.getId());
//        	}
//    		Database.removeAllWithKeyValue(DBWrapper.TYPE_CITY, DBWrapper.FIELD_COUNTRY_ID, country.getId());
//
//        }
//		Database.removeAllWithKeyValue(DBWrapper.TYPE_COUNTRY, DBWrapper.FIELD_CONTINENT_ID, nullContinent);
//		Database.removeAllWithKeyValue(DBWrapper.TYPE_CONTINENT, DBWrapper.FIELD_ID, nullContinent);
        // */
        
        
    }
}

//4cf1e7253c65df4ca5b43186