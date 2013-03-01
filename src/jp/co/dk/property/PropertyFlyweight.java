package jp.co.dk.property;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import jp.co.dk.property.exception.PropertyException;

class PropertyFlyweight {
	
	private static Map<String, PropertiesFile> propertyMap ;
	
	static {
		propertyMap = new HashMap<String, PropertiesFile>();
	}
	
	static synchronized PropertiesFile getInstance(File file) throws PropertyException {
		String filePath = file.toString();
		PropertiesFile propertyFile = propertyMap.get(filePath);
		if (propertyFile == null) {
			propertyFile = new PropertiesFile(filePath);
			propertyMap.put(filePath, propertyFile);
		}
		return propertyFile;
	}
}
