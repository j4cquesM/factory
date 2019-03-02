package models.Chaine;

import exception.NonExistantException;
import exception.ProductionImpossibleException;
import models.Element.Element;
import models.Stock.Stock;
import models.Util;
import java.util.*;
/**
 * 
 * @author claude
 *
 */
public class Chaine {
	private Stock stock;
	private String nom;
	private Map<Element, Double> composants;
	private Map<Element,Double> sortie;
	
	
	public Chaine(String nom)
	{
		this.nom=nom;
		this.stock=new Stock();
		this.composants = new HashMap<Element,Double>();
		this.sortie = new HashMap<Element,Double>();
		
	}
	
	/**
	 * Constructeur par copie
	 * @param stock
	 * @param nom
	 */
	public Chaine( String nom,Stock stock) {
		this(nom);
		this.stock = new Stock(stock);
	}

	
	/**
	 * 
	 * @param niveauActivation le niveau d'activation de la chaine
	 * @return le benefice produit
	 * @throws NonExistantException 
	 */
	public double  produire(double niveauActivation) throws ProductionImpossibleException
	{
		//duplication du stock pour la simulation
		Stock stockSimulation = new Stock(this.stock);
		
		for(Element elem : this.composants.keySet())
		{
			
				double quantite = niveauActivation * this.composants.get(elem);
				
				try {
					stockSimulation.destocker(elem , quantite );
					
					if( stockSimulation.getQuantite(elem) < 0  ) {
						
						if( elem.isMatierePremiere() ) {
							
							//ajout à la liste d'achat 
							double quantiteAchat = stockSimulation.getQuantiteMinAchat(elem);
							
							stockSimulation.acheter(elem, quantiteAchat);
							
						}
						else {
							throw new ProductionImpossibleException(elem);
						}
					}
					
				} catch (NonExistantException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
				
		}
		//ajout des elements en sortie de le stock
		
		for(Element key: sortie.keySet()) {
			
			double quantiteAjout= niveauActivation * this.sortie.get(key);
			stockSimulation.stocker(key, quantiteAjout);
		}
		
		double benefice = stockSimulation.getValeurPrixVente() - stockSimulation.getListeAchat().getValeur();
				
		this.stock= new Stock(stockSimulation);
		
		System.out.println("benefice "+benefice);
		
		return benefice ;
	}
	
	public void addComposant(Element e, double quantite)
	{
		Util.addInMap(this.composants, e, quantite);
	}
	
	public void addSortie(Element e,double quantite)
	{
		Util.addInMap(this.sortie, e, quantite);
	}
	
	public void removeComposant(Element e)
	{
		Util.removeInMap(this.composants, e);
	}
	
	public void removeSortie(Element e) {
		
		Util.removeInMap(this.sortie, e);
	}
	
	public String toString() {
		String message = "Composants : \n";
		
		for (Element key : this.composants.keySet()) {
			message += ""+key.getNom()+" "+key.getCodeUnique()+" "+key.getPrixAchat()+" "+key.getPrixAchat()+" \n";
		}
		
		message += "Sortie : \n ";
		
		for (Element key : this.sortie.keySet()) {
			message += key.getNom()+" "+key.getCodeUnique()+" "+key.getPrixAchat()+" "+key.getPrixAchat()+" \n";
		}
		
		message+="Stock : \n";
		
		message += this.stock.toString();

		return message;
	}
	
	public Stock getStock() {
		return this.stock;
	}
	
	
	
	
}