package models.Stock;

import exception.NonExistantException;
import models.Element.Element;
import models.Util;
import java.util.*;

/**
 * 
 * @author claude
 *
 */

public class Stock {

	public ListeAchat getListeAchat() {
		return listeAchat;
	}

	private Map<Element, Double> stock;

	private ListeAchat listeAchat;

	public Stock() {
		this.stock = new HashMap<Element, Double>();
		this.listeAchat = new ListeAchat();
	}

	public Stock(Stock s) {
		this();
		for (Element key : s.stock.keySet()) {

			Element nouv = new Element(key);

		double quantite = s.stock.get(key);

			this.stocker(nouv, quantite);
		}
		
		this.listeAchat=new ListeAchat(s.listeAchat);

	}

	/**
	 * @return la valeur du stock avec la prixAchat
	 */
	public double getValeurPrixAchat() {
		double prix = 0;
		for (Element key : stock.keySet()) {

			// on prend le prix de l'element
			double prixElement =  key.getPrixAchat();

			// on prend le prix de la quantite en stock
			double prixElementCumul = prixElement * (stock.get(key)).doubleValue();

			prix += prixElementCumul;
		}
		return prix;
	}
	
	/**
	 * @return la valeur du stock avec la prixVente
	 */
	public double getValeurPrixVente() {
		double prix = 0;
		for (Element key : stock.keySet()) {

			// on prend le prix de l'element
			double prixElement =  key.getPrixVente();

			// on prend le prix de la quantite en stock
			double prixElementCumul = prixElement * (stock.get(key)).doubleValue();

			prix += prixElementCumul;
		}
		return prix;
	}


	/**
	 * Rajoute ou met à jour un element dans le stock
	 * 
	 * @param e        l'element du stock
	 * @param quantite la quantite de l'element
	 */

	public void stocker(Element e, double quantite) {

		Util.addInMap(this.stock, e, quantite);
	}

	/**
	 * Fait sortir un element du stock
	 * 
	 * @param e  l'element à destocker
	 * @param quantite la quantite de l'element
	 * @throws NonExistantException 
	 */

	public void destocker(Element e, double quantite) throws NonExistantException {

		Util.removeInMap(this.stock, e, quantite);

	}

	public void acheter(Element e, double quantite) {
		this.listeAchat.acheter(e, quantite);
	}
	
	/**
	 * 
	 * @param e
	 * @return la quanité d'une element en stock
	 */
	
	public double getQuantite(Element e) {
		
		double quantite = this.stock.get(e);
		
		return quantite;
		
	}

	public String toString() {
		String message = "";
		
		for (Element key : this.stock.keySet()) {
			message += key.toString()+" Quantité "+this.stock.get(key)+"\n";
		}

		return message;
	}
	
	public double getQuantiteMinAchat(Element e)
	{
		double quantiteActuelle = this.getQuantite(e);
		double i=0;
		while(quantiteActuelle <= 0)
		{
			i++;
			quantiteActuelle++;
		}
		return i;
	}
	
	

}
