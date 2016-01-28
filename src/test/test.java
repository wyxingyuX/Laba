package test;

import java.io.IOException;
import java.util.Set;

import utils.IO;

public class test {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    	String base="F:\\ExpData\\DataIntegate\\source\\nne\\publicInfo\\5fold\\0\\";
          Set<String> trainIds=IO.readUids(base+"train.txt");
          Set<String> validationIds=IO.readUids(base+"validation.txt");
          int count=0;
          for(String id:validationIds){
        	  if(trainIds.contains(id)){
        		  System.out.println("train set contain validation id "+id);
        		  ++count;
        	  }
          }
          System.out.println(count);
	}

}
