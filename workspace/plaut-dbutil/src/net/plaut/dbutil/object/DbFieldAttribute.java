package net.plaut.dbutil.object;

public class DbFieldAttribute {
	private int position;
	private String name;
	private int type;
	private boolean isPrimaryKey;
	
	public DbFieldAttribute(int position, String name, boolean isPrimaryKey, int type) {
		this.position = position;
		this.name = name;
		this.isPrimaryKey = isPrimaryKey;
		this.type = type;
	}
	
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public boolean isPrimaryKey() {
		return isPrimaryKey;
	}
	public void setPrimaryKey(boolean isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}

}
