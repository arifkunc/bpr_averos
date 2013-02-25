package net.plaut.bprtab.util;

import java.util.ArrayList;
import java.util.List;

import net.plaut.bprtab.dao.BpaUserGroupTableRecord;
import net.plaut.component.PComboBoxLoad;

public class PairedItemFactory {
	public static List fromUserGroupTableRecord(ArrayList<BpaUserGroupTableRecord> listGroupUser){
		if(listGroupUser == null){
			return null;
		}
		ArrayList<PComboBoxLoad.PairedItem> result = new ArrayList<PComboBoxLoad.PairedItem>();
		for(int i=0; i< listGroupUser.size(); i++){
			BpaUserGroupTableRecord userGroup = listGroupUser.get(i);
			PComboBoxLoad.PairedItem item = new PComboBoxLoad.PairedItem();
			item.setItemValue(userGroup.getId());
			item.setItemDisplay(userGroup.getGroupName());
			result.add(item);
		}
		return result;
	}
}
