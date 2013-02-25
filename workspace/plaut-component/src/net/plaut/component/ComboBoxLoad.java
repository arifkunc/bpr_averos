package net.plaut.component;

import java.util.List;

import javax.swing.JComboBox;

public abstract class ComboBoxLoad extends JComboBox {
	protected List listSource;
	protected String[] valueArray;
	protected String[] displayArray;
	
	public ComboBoxLoad(List listSource){
		super();
		this.listSource = listSource;
		reloadItems();
	}

	public List getListSource() {
		return listSource;
	}

	public void setListSource(List listSource) {
		this.listSource = listSource;
	}
	
	public void reloadItems(){
		fromListToArray();
		for(int i=0; i < valueArray.length; i++){
			addItem(displayArray[i]);
		}
	}
	
	public String getSelectedValue(){
		int i = getSelectedIndex();
		return valueArray[i];
	}
	
	public String getSelectedDisplay(){
		int i = getSelectedIndex();
		return displayArray[i];
	}
	
	public abstract void fromListToArray();
}
