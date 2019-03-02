package models;

import exception.ProductionImpossibleException;
import models.Chaine.Chaine;
import models.Element.Element;
import parser.main.CSVReader;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//test element
		String path = "C:\\Users\\JackMesss\\IdeaProjects\\factory\\src\\data\\";
		String file = "chaines.csv";
		CSVReader parse = new CSVReader(path+file);
		parse.read();
		ArrayList data = parse.getData();


		for(int i =0; i<data.size();i++){
			LinkedHashMap token = (LinkedHashMap)data.get(i);
			System.out.println(token.get("Code"));
		}



		Element e1 = new Element("e1","e1","kg",0,10);
		Element e2 = new Element("e2","e2","kg",1,1);
//		
//		System.out.println(e1.toString());
//		
//		System.out.println(e2.toString());
//		
//		System.out.println(e1.isMatierePremiere());
//		
//		System.out.println(e1.isProduitFini());
		
//		Stock s = new Stock();
//		
//		s.stocker(e1,2);
//		
//		s.stocker(e2, 3);
//		
//		System.out.println(s.toString());
//		
//		Stock ss = new Stock(s);
//			
//		ss.stocker(e2, 2);
//		
//		System.out.println(ss.toString());
//		
//		try {
//			ss.destocker(e2, 1);
//		} catch (NonExistantException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(ss.toString());
		
//		ListeAchat l = new ListeAchat();
//		
//		l.acheter(e1, 2);
//		l.acheter(e2, 30);
//		
//		System.out.println(l.toString());
//		System.out.println(l.getValeur());
//		
//		l.retirerListe(e2);
//		
//		System.out.println(l.toString());
		
		Chaine c = new Chaine("chaine");
		
		c.addComposant(e2, 1);
		
		c.addSortie(e1, 2);
		
		c.getStock().stocker(e2, 2);
		
		System.out.println(c.toString());
		
		System.out.println("--------------------------------------------------");
		
		try {
			c.produire(3);
		} catch (ProductionImpossibleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("--------------------------------------------------");
		System.out.println(c.toString());
		System.out.println("--------------------------------------------------");
		
		System.out.println(c.getStock().getListeAchat().toString());
		System.out.println(c.getStock().getListeAchat().getValeur());
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		

	}

}
