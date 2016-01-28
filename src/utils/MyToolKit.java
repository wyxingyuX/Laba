package utils;

import java.io.BufferedReader;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyToolKit {
	public static int getTypeNum(String filePath,String seperater) throws IOException{
		BufferedReader reader=FileTool.getBufferedReaderFromFile(filePath);
		int typeNum=0;
		String line="";
		while((line=reader.readLine())!=null){
			String[] elms=line.split(seperater);
			if(elms.length==2){
				++typeNum;
			}
		}
		System.out.println("this file have "+typeNum+" type");
		return typeNum;
	}
	public static void testResult(String filePath,String seperater) throws IOException{
		BufferedReader reader=FileTool.getBufferedReaderFromFile(filePath);
		int maxLikehoodType=0;
		double maxValue=0;
		double total=0;
		String line="";
		int lineNum=1;
		int end=40;
		while((line=reader.readLine())!=null){
			if(lineNum>end) break;
			String[] elms=line.split(seperater);
			String[] vElms=new String[elms.length-1];
			for(int i=1;i<elms.length;++i){
				double d=Double.parseDouble(elms[i]);
				if(d>maxValue){
					maxValue=d;
					maxLikehoodType=i;
				}
				total+=d;
				vElms[i-1]=elms[i];
			}
			System.out.println(lineNum+" row predict type is " +elms[0]+", the "+maxLikehoodType+"th Value is maxValue "
					+maxValue+", total have "+(elms.length-1)+" probality value,"+",Sum all value is "+total);
			System.out.println(getMaxValueFromStrArray(vElms));
			maxLikehoodType=0;
			maxValue=0;
			total=0;
			++lineNum;
		}

	}
	public static double getMaxValueFromStrArray(String[] dStr){
		double maxValue=-1000000000;
		for(int i=0;i<dStr.length;++i){
			double dValue=Double.parseDouble(dStr[i]);
			if(maxValue<dValue){
				maxValue=dValue;
			}
		}
		return maxValue;
	}
	public static List<String> cloneStrList(List<String> list){
		List<String> clone=new LinkedList<String>();
		for(String s:list){
			clone.add(s);
		}
		return clone;
	}

	public static int max(int a,int b,int c){
		return Math.max(Math.max(a, b), c);
	}
	public static int min(int a,int b,int c){
		return Math.min(Math.min(a, b), c);
	}

	public static void main(String [] args) throws IOException{
		//getTypeNum("F:/ExpData/DataFromOther/qty/Data4Tritrain/IMDB_Freq_DataTextTf.txt","\\s{1,}");
		//testResult("F:/wy1223/svm/SVM_lg/result_lg.txt","\\s{1,}");
		System.out.println(max(1,5,1));
	}
}
