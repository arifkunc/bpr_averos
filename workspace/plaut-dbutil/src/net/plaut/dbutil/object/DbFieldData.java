package net.plaut.dbutil.object;

public class DbFieldData {
	private Object value;
	private boolean assigned;
	private boolean modified;
	private DbFieldAttribute dbFieldAttribute;
	
	public DbFieldData(Object value, boolean assigned, boolean modified, DbFieldAttribute dbFieldAttribute) {
		this.value = value;
		this.assigned = assigned;
		this.modified = modified;
		this.dbFieldAttribute = dbFieldAttribute;
	}
	
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
		if(value == null){
			setAssigned(false);
		} else {
			setAssigned(true);
		}
		setModified(true);
	}
	
	public boolean isAssigned() {
		return assigned;
	}
	
	public void setAssigned(boolean assigned) {
		this.assigned = assigned;
	}
	
	public boolean isModified() {
		return modified;
	}
	
	public void setModified(boolean modified) {
		this.modified = modified;
	}
	
	public DbFieldAttribute getDbFieldAttribute() {
		return dbFieldAttribute;
	}
	
	public void setDbFieldAttribute(DbFieldAttribute dbFieldAttribute) {
		this.dbFieldAttribute = dbFieldAttribute;
	}
	
}
