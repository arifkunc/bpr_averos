package net.plaut.component;

import javax.swing.JComboBox;

public class PComboBoxLoad extends JComboBox {
	protected Object[] itemsValue;
	protected Object[] itemsDisplay;
	
	public PComboBoxLoad(Object[] itemsValue, Object[] itemsdisplay){
		super();
		setItems(itemsValue, itemsdisplay);
		reloadItems();
	}
	
	public void reloadItems(){
		if(itemsValue.length != itemsDisplay.length){
			return;
		}
		removeAllItems();
		for(int i=0; i < itemsDisplay.length; i++){
			addItem(itemsDisplay[i]);
		}
	}
	
	public Object getSelectedValue(){
		int i = getSelectedIndex();
		return itemsValue[i];
	}
	
	public Object getSelectedDisplay(){
		int i = getSelectedIndex();
		return itemsDisplay[i];
	}
	
	public void setItems(Object[] itemsValue, Object[] itemsDisplay){
		if(itemsValue.length != itemsDisplay.length){
			return;
		}
		this.itemsValue = itemsValue;
		this.itemsDisplay = itemsDisplay;
	}
	
}
