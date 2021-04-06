package  it.polito.tdp.spellchecker.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TesteModelo {

	public static void main(String[] args) {
		final int nTest=10;
		Dictionary model = new Dictionary();
		model.loadDictionary("Italian");
		String inputText ="In informatica Java è un linguaggio di programmazione ad alto livello,"
				+ " \"orientato agli oggetti e a tipizzazione statica, specificatamente progettato per essere \"\r\n"
				+ "\"il più possibile indipendente dalla piattaforma di esecuzione.\";";
		inputText = inputText.replaceAll("\n", " ");
		inputText = inputText.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]]", "");
		//System.out.println(inputText);		
		
		List<String> inputTextList = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(inputText," ");
		
		while(st.hasMoreTokens()) {
			inputTextList.add(st.nextToken());
		}
		
		//System.out.println(inputTextList.toString());
	}
	
}
