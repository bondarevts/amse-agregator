package ru.amse.agregator.gui.yalets;

import java.util.ArrayList;

import net.sf.xfresh.core.InternalRequest;
import net.sf.xfresh.core.InternalResponse;
import net.sf.xfresh.core.Yalet;
import org.bson.types.ObjectId;

import ru.amse.agregator.gui.model.DescriptionModel;
import ru.amse.agregator.gui.model.MenuItem;
import ru.amse.agregator.storage.DBWrapper;
import ru.amse.agregator.storage.DataBase;

public class CountryPageYalet implements Yalet {

	public void process(InternalRequest req, InternalResponse res) {
		
		DataBase.connectToDirtyBase();
		String id = req.getParameter("id");
		ObjectId selectedCountry = new ObjectId(id);
		
		DBWrapper country = DataBase.getDBObjectByIdAndType(selectedCountry, DBWrapper.TYPE_COUNTRY);
		
		DescriptionModel response = new DescriptionModel();
		response.setName(country.getName());
		response.setDescription(country.getDescription());
		response.setImages(country.getPhotosArray());
		
		ArrayList<DBWrapper> cities = DataBase.getAllCitiesByCountry(country.getId());
		ArrayList<MenuItem> citiesInfo = new ArrayList<MenuItem>();
		
		for(DBWrapper city : cities){
			MenuItem newCity = new MenuItem(city.getName() , city.getId().toString());
			citiesInfo.add(newCity);
		}
		response.setCities(citiesInfo);
		res.add(response);
		
	}
}