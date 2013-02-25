package net.plaut.bprtab.komp.common;

import java.util.List;

import net.plaut.bprtab.dao.BpaUserGroupTableRecord;
import net.plaut.component.ComboBoxLoad;

public class ComboBoxGroupUserLoad extends ComboBoxLoad {

	public ComboBoxGroupUserLoad(List listSource) {
		super(listSource);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fromListToArray() {
		int number = listSource.size();
		valueArray = new String[number];
		displayArray = new String[number];
		int i=0;
		for(Object el:listSource){
			BpaUserGroupTableRecord record = (BpaUserGroupTableRecord)el;
			valueArray[i] = record.getId();
			displayArray[i] = record.getGroupName();
			i++;
		}
	}

}
