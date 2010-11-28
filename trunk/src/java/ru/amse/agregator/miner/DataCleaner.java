package ru.amse.agregator.miner;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

//This class cleans mined data
public class DataCleaner extends DefaultHandler {

	private ArrayList<String> goodTags;
	private StringBuffer result;
	
	public DataCleaner(){
		super();
		result = new StringBuffer();
		goodTags = new ArrayList<String>();
		goodTags.add("table");
		goodTags.add("div");
		goodTags.add("span");
		goodTags.add("b");
		goodTags.add("p");
		goodTags.add("i");
		goodTags.add("u");
		goodTags.add("br");
	}
	
    public void startElement(String uri, String localName, String qName,  Attributes attributes){
    		
    		if(goodTags.contains(qName.toLowerCase())){
    			result.append("<" + qName + " class='my" + qName + "'>");
    		}
    }
    
    public void endElement (String uri, String name, String qName){
    	
    	if(goodTags.contains(qName.toLowerCase()))
			result.append("</" + qName + ">");
    	
    }
    
    public void characters (char ch[], int start, int length) {
    		result.append(ch, start, length);
    }
	
    public String getData(){ return result.toString(); }
    public void clear(){ result.setLength(0); }
    
    
}
