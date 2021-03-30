package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Dictionary {

	//modelo del nostro programma

	
	
	/**
	 * Questo metodo permette di caricare in memoria il dizionario della lingua desiderata
	 * @param Language English, Italian
	 */
	public void loadDictionary(String Language) {
		String nomeFile = null;
		
		if(Language.contains("English")) {
			nomeFile="English.txt";
		}else if (Language.contains("Italian")) {
			nomeFile="Italian.txt";
		}
		
		if(nomeFile!=null) {
			
			try {
				FileReader fr = new FileReader(nomeFile);
				BufferedReader br =  new BufferedReader(fr);
				String word;
				while((word=br.readLine())!=null) {
					//TO DO: add struttura dati
				}
				br.close();
				fr.close();
			} catch(IOException ioe) {
				System.out.println("Errore nella lettura del file");
			}
			
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
		return null;
		
	}
	
}
