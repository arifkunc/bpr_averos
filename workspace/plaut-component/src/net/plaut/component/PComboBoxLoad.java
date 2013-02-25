package net.plaut.component;

import java.util.List;

import javax.swing.JComboBox;

public class PComboBoxLoad extends JComboBox {
	protected List pairedItems;
	
	public PComboBoxLoad(List pairedItems){
		super();
		this.pairedItems = pairedItems;
		reloadItems();
	}
	
	public void reloadItems(){
		removeAllItems();
		for(int i=0; i < pairedItems.size(); i++){
			PairedItem paireditem = (PairedItem)pairedItems.get(i);
			addItem(paireditem.getItemDisplay());
		}
	}
	
	public Object getSelectedValue(){
		int i = getSelectedIndex();
		PairedItem paireditem = (PairedItem)pairedItems.get(i);
		return paireditem.getItemValue();
	}
	
	public Object getSelectedDisplay(){
		int i = getSelectedIndex();
		PairedItem paireditem = (PairedItem)pairedItems.get(i);
		return paireditem.getItemDisplay();
	}
	
	// inner class for storing item data
	public static class PairedItem{
		private Object itemValue;
		private Object itemDisplay;
		public Object getItemValue() {
			return itemValue;
		}
		public void setItemValue(Object itemValue) {
			this.itemValue = itemValue;
		}
		public Object getItemDisplay() {
			return itemDisplay;
		}
		public void setItemDisplay(Object itemDisplay) {
			this.itemDisplay = itemDisplay;
		}
	}
	
}
