package net.plaut.dbutil.dao;

import java.util.HashMap;

import net.plaut.dbutil.object.DbFieldAttribute;
import net.plaut.dbutil.object.DbFieldData;

public class QueryRecord{
	private HashMap<String, DbFieldData> valueMap;
	private DbFieldAttribute[] dbFieldAttributeArray;
	
	protected QueryRecord(DbFieldAttribute[] dbFieldAttributeArray){
		this.dbFieldAttributeArray = dbFieldAttributeArray;
		this.valueMap = createValueMap(dbFieldAttributeArray);
	}
	
	protected HashMap<String, DbFieldData> getValueMap() {
		return valueMap;
	}

	protected DbFieldAttribute[] getDbFieldAttributeArray() {
		return dbFieldAttributeArray;
	}

	private HashMap<String, DbFieldData> createValueMap(DbFieldAttribute[] dbFieldAttributeArray){
		HashMap<String, DbFieldData> valueMap = new HashMap<String, DbFieldData>();
		for(DbFieldAttribute fieldAttribute: dbFieldAttributeArray){
			DbFieldData fieldData = new DbFieldData(null, false, false, fieldAttribute);
			valueMap.put(fieldAttribute.getName(), fieldData);
		}
		return valueMap;
	}
	
	protected void setValue(String columnName, Object value){
		DbFieldData fieldData = valueMap.get(columnName);
		if(fieldData == null){
			return;
		}
		fieldData.setValue(value);
	}
	
	protected Object getValue(String columnName){
		DbFieldData fieldData = valueMap.get(columnName);
		if(fieldData == null){
			return null;
		}
		return fieldData.getValue();
	}
}
