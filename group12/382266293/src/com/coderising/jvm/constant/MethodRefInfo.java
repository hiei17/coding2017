package com.coderising.jvm.constant;

import com.coderising.jvm.print.PrintVisitor;

public class MethodRefInfo extends ConstantInfo {

	private int type = ConstantInfo.METHOD_INFO;

	private int classInfoIndex;
	private int nameAndTypeIndex;

	public MethodRefInfo(ConstantPool pool) {
		super(pool);
	}


	public String getClassName() {
		ConstantPool pool = this.getConstantPool();
		ClassInfo clzInfo = (ClassInfo) pool.getConstantInfo(this.getClassInfoIndex());
		return clzInfo.getClassName();
	}

	public String getMethodName() {
		ConstantPool pool = this.getConstantPool();
		NameAndTypeInfo typeInfo = (NameAndTypeInfo) pool.getConstantInfo(this.getNameAndTypeIndex());
		return typeInfo.getName();
	}


	public int getClassInfoIndex() {
		return classInfoIndex;
	}

	public int getNameAndTypeIndex() {
		return nameAndTypeIndex;
	}

	public String getParamAndReturnType() {
		ConstantPool pool = this.getConstantPool();
		NameAndTypeInfo typeInfo = (NameAndTypeInfo) pool.getConstantInfo(this.getNameAndTypeIndex());
		return typeInfo.getTypeInfo();
	}

	@Override
	public int getType() {
		return type;
	}

	public void setClassInfoIndex(int classInfoIndex) {
		this.classInfoIndex = classInfoIndex;
	}

	public void setNameAndTypeIndex(int nameAndTypeIndex) {
		this.nameAndTypeIndex = nameAndTypeIndex;
	}

	@Override
	public String toString() {

		return getClassName() + " : " + this.getMethodName() + " : " + this.getParamAndReturnType();
	}
	
	@Override
	public void accept(PrintVisitor visitor) {
		visitor.visit(this);		
	}

}
