package com.ravionics.user.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ravionics.user.entity.EnumConstantType.Status;

public class EnumTest {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<EnumConstantType.Status> al=new ArrayList<>();
		al.addAll(Arrays.asList(EnumConstantType.Status.values()));
		System.out.println(al);

	}
	public List<Status> getConstant(String stu){
		
     return Arrays.asList(EnumConstantType.Status.values());    
     
	}
	public <T extends Enum<T>> void enumValues(Class<T> enumType) {
        for (T c : enumType.getEnumConstants()) {
             System.out.println(c.name());
        }
}

}
