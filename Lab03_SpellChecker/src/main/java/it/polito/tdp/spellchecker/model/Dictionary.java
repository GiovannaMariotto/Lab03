package  it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dictionary {

	//modelo del nostro programma

	private List<String> dizionario;
	private String language;
	
	public Dictionary() { //Constructor
		
	}
	
	/**
	 * Questo metodo permette di caricare in memoria il dizionario della lingua desiderata.
	 * Ritornarà true se l'operazione è andata a buon fine
	 * @param Language English, Italian
	 */
 	public boolean loadDictionary(String Language) {
		if(dizionario!=null && this.language.equals(Language)) {
			return true;
		}
		dizionario=new ArrayList<String>();
		this.language=Language;
		String nomeFile = "src/main/resources/" + this.language+".txt";
		
			try {
				FileReader fr = new FileReader(nomeFile);
				BufferedReader br =  new BufferedReader(fr);
				String word;
				while((word=br.readLine())!=null) {
					dizionario.add(word.toLowerCase());
				}
				Collections.sort(dizionario);
				
				br.close();
				
				System.out.println("Dizionario "+language+" was loaded. Found "+dizionario.size()+" words.");
				 return true;
			} catch(IOException ioe) {
				System.out.println("Errore nella lettura del file");
				return false;
			}
		
		}
		
		
	
	/**
	 * Questo metodo esegue il controllo ortografico sul testo in input (rappresentato da una lista di parole)
e restituisce una lista di RichWord.
	 * @param inputTextList
	 * @return lista di RichWord
	 */
	public List<RichWord> spellCheckText(List<String> inputTextList){
		//TODO: Verificare se la parola sia giusta e ritornare una lista di RichWords
		List<String> input = inputTextList;
		List<RichWord> risultato = new ArrayList();
		for(String s : input) { //for each string inside inputTextList
			RichWord w;
			if(s!=null && dizionario.contains(s.toLowerCase())) { //if the dictionary contains it: create the RichWord ( parola, true)
				 w = new RichWord(s,true);	
			} else {
				 w = new RichWord(s,false);// if it's not on the dictionary: create the RichWord (parola,false)
				
			}
			risultato.add(w);
		}
		
		return risultato; //return list of RichWords
		
	}

	public List<String> getDizionario() {
		return dizionario;
	}


	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
}
