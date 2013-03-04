package net.plaut.dbutil.object;

public class DbFieldAttribute {
	private int position;
	private String name;
	private boolean isPrimaryKey;
	private Class<?> classType;
	
	
	public DbFieldAttribute(int position, String name, boolean isPrimaryKey,
			Class<?> classType) {
		super();
		this.position = position;
		this.name = name;
		this.isPrimaryKey = isPrimaryKey;
		this.classType = classType;
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
	public boolean isPrimaryKey() {
		return isPrimaryKey;
	}
	public void setPrimaryKey(boolean isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}
	public Class<?> getClassType() {
		return classType;
	}
	public void setClassType(Class<?> classType) {
		this.classType = classType;
	}
	
	
}
