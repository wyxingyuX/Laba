package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IO {
	public static Set<String> readUids(String uids) throws IOException{
		BufferedReader reader=FileTool.getBufferedReaderFromFile(uids);
		Set<String> ids=new HashSet<String>();
		String line="";
		while((line=reader.readLine())!=null){
			String[] elms=line.split("\t");
			String id=elms[0].trim();
			ids.add(id);
		}
		return ids;
	}
	
	public static void readUidLabel(String uids,String label,Map<String,String> idLabelMap) throws IOException{
		BufferedReader reader=FileTool.getBufferedReaderFromFile(uids);
		String line="";
		while((line=reader.readLine())!=null){
			String[] elms=line.split("\t");
			String id=elms[0].trim();
			idLabelMap.put(id, label);
		}
	}
	public static Map<String,List<Double>> loadWordVecMaxtrix(String wordVecFilePath,String seperater,Map<String,List<Double>> wordVecMatrix) throws IOException{
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(wordVecFilePath),"utf-8"));
		String line="";
		int lineCount=0;
		while((line=reader.readLine())!=null){
			++lineCount;
			if(lineCount==1){
				continue;
			}
			String[] elms=line.split(seperater);
			String word=elms[0];
			List<Double> vec=new ArrayList<Double>();
			for(int i=1;i<elms.length;++i){
				vec.add(Double.parseDouble(elms[i]));
			}
			wordVecMatrix.put(word, vec);
		}
		return wordVecMatrix;
	}

}
