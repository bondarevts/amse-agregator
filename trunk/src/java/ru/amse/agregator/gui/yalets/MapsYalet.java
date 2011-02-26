package ru.amse.agregator.gui.yalets;

import java.awt.geom.Point2D;
import java.util.ArrayList;


import net.sf.xfresh.core.InternalRequest;
import net.sf.xfresh.core.InternalResponse;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import ru.amse.agregator.gui.model.Attraction;
import ru.amse.agregator.gui.model.Record;
import ru.amse.agregator.storage.DBWrapper;
import ru.amse.agregator.storage.Database;

public class MapsYalet extends AbstractAgregatorYalet {
    Logger log = Logger.getLogger(ShowAttractionsYalet.class);

    @Override
    public void process(InternalRequest req, InternalResponse res) {

//		String tmp = req.getParameter("tab");
//    	System.out.println(req.getParameter("id")+"     tmp = "+ tmp);
    	Attraction attraction = new Attraction();
    	attraction.setId(req.getParameter("id"));
    	//res.add((new ArrayList<Attraction>()).add(attraction));
    	Database.connectToMainBase();	
    	ArrayList<Record> webRes = new ArrayList<Record>(); 
    	ObjectId selectedItem = new ObjectId(req.getParameter("id"));
    	String type = req.getParameter("type");
    	if ( type.equals(DBWrapper.TYPE_COUNTRY)){
    		ArrayList<DBWrapper> allCities = Database.getAllCitiesByCountry(selectedItem);
    		if (allCities != null){
    			ArrayList<DBWrapper> allAttr = new ArrayList<DBWrapper>();
    			for (DBWrapper obj : allCities){
    				ArrayList<DBWrapper> allAttrByCity = Database.getAllAttrByCity(obj.getId());
    				for ( DBWrapper obj1 : allAttrByCity){
    					allAttr.add(obj1);
    				}
    			}
    			if (allAttr != null){
    				for ( DBWrapper obj : allAttr){
    					if (obj.getCoordsArray() != null){
    						ArrayList<Point2D.Double> coords = obj.getCoordsArray();
    						for ( Point2D.Double coord : coords){
    							Record newRecord = new Record();
    							newRecord.addCell("lng", coord.x);
            					newRecord.addCell("lat",coord.y);
            					newRecord.addCell("name",obj.getName());
        					    webRes.add(newRecord);
    						}
    					}
    					
    				}
    				res.add(webRes);
    			}
    		}
    	}
    	else if ( type.equals(DBWrapper.TYPE_CITY)){
        		ArrayList<DBWrapper> allAttrByCity = Database.getAllAttrByCity(selectedItem);
        		ArrayList<DBWrapper> allAttr = new ArrayList<DBWrapper>();
        		for ( DBWrapper obj1 : allAttrByCity){
        			allAttr.add(obj1);
        		}
        		if (allAttr != null){
        			for ( DBWrapper obj : allAttr){	
        				if (obj.getCoordsArray() != null){
        					ArrayList<Point2D.Double> coords = obj.getCoordsArray();
        					for ( Point2D.Double coord : coords){
        						Record newRecord = new Record();
        						System.out.println("x = "+ coord.x);
        						System.out.println("y = "+ coord.y);
                				newRecord.addCell("lng", coord.x);
                				newRecord.addCell("lat",coord.y);
                				newRecord.addCell("name",obj.getName());
            				    webRes.add(newRecord);
        					}
        				}
        				
        			}
        			res.add(webRes);
        		}
    	}
    	else if (!type.equals(DBWrapper.TYPE_CONTINENT)){
    		DBWrapper obj = Database.getDBObjectByIdAndType(selectedItem, type);
    		
    		if (obj.getCoordsArray() != null){
				ArrayList<Point2D.Double> coords = obj.getCoordsArray();
				for ( Point2D.Double coord : coords){
					Record newRecord = new Record();
					System.out.println("x = "+ coord.x);
					System.out.println("y = "+ coord.y);
    				newRecord.addCell("lng", coord.x);
    				newRecord.addCell("lat",coord.y);
    				newRecord.addCell("name",obj.getName());
				    webRes.add(newRecord);
				}
			}
    		res.add(webRes);
    	}
        		
    	

//    		ArrayList<Record> webRes = new ArrayList<Record>(); 
//    		for ( int i = 1 ; i < 10; ++i){
//	    		Record newRecord = new Record();
//	    		newRecord.addCell("id",selectedItem.toString());    		
//	    		newRecord.addCell("lng", (68.234+i)+"");
//	    		newRecord.addCell("lat",(25.435-i)+"");
//	    		webRes.add(newRecord);
//    		}
//    		res.add(webRes);	
//    	}
    		
    //	}
      //  DBWrapper dbwr = Database.getDBObjectByIdAndTypeAndIncRating(selectedItem, type);
    	
//        if (tmp != null && !"".equals(tmp)) {
//        	System.out.println(req.getParameter("id"));
//            res.add(manager.getSomeAttractionById(req.getParameter("id"), req.getParameter("type"), req.getParameter("tab")));
//        } else {
//            if (req.getParameter("type").equals("Continent")) {
//                res.add(manager.getSomeAttractionById(req.getParameter("id"), req.getParameter("type"), "list"));
//            } else {
//                res.add(manager.getSomeAttractionById(req.getParameter("id"), req.getParameter("type"), "all"));
//            }
//        }
    }
}