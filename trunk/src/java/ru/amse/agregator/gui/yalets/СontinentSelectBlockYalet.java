package ru.amse.agregator.gui.yalets;

import java.util.ArrayList;

import ru.amse.agregator.gui.model.Record;
import ru.amse.agregator.storage.DBWrapper;
import ru.amse.agregator.storage.Database;
import net.sf.xfresh.core.InternalRequest;
import net.sf.xfresh.core.InternalResponse;
import net.sf.xfresh.core.Yalet;

public class СontinentSelectBlockYalet implements Yalet {

	public void process(InternalRequest req, InternalResponse res) {
		
		Database.connectToMainBase();	
		ArrayList<DBWrapper> continents = Database.getAllContinents();
		ArrayList<Record> webRes = new ArrayList<Record>(); 
		
		for (DBWrapper continent : continents) {		
			Record countryRec = new Record();
			countryRec.addCell("name", continent.getName());
			countryRec.addCell("id", continent.getId().toString());
			webRes.add(countryRec);
		}
		res.add(webRes);

	}

}
