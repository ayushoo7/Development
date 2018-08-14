package com.ayush.unique;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MainDevelopment {
	public static void main(String args[]) {
		TaskType t1= new TaskType(123,"t1");
		TaskType t2= new TaskType(456,"t2");
		TaskType t9= new TaskType(779,"t2");
		List<TaskType> lstTaskType= new ArrayList();
		lstTaskType.add(t1);
		lstTaskType.add(t2);
		lstTaskType.add(t9);
		TaskType t3= new TaskType(456,"t2");
		
		TaskType t4= new TaskType(777,"t2");
		TaskType t5= new TaskType(778,"t2");
		
		List<TaskType> lstTaskTypeNew= new ArrayList();
		lstTaskTypeNew.add(t3);
		lstTaskTypeNew.add(t4);
		lstTaskTypeNew.add(t5);
		
		List<TaskType> newList = lstTaskType.stream()
			    .filter((TaskType h) -> {
			        return !lstTaskTypeNew.stream()
			            .anyMatch(s -> s.getUid() == h.getUid());
			    })
			    .collect(Collectors.toList());
			newList.addAll(lstTaskTypeNew);
			
			newList.stream().forEach(System.out::println);
		
		
		
	}

}
