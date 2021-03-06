package models;

import exception.*;
import models.Element.Element;

import java.util.Map;

/**
 * 
 * @author claude
 *
 */

public class Util {
	
	/**
	 * Methode pour ajouter ou metre à jour un element dans une map
	 * @param map
	 * @param e l'element à ajouter dans la map
	 * @param quantite
	 */
	public static void addInMap(Map<Element, Double> map, Element e, double quantite)
	{
		//si l'element existe dans la map
		if(map.containsKey(e))
		{		
			// on prend la quantite actuelle
			double oldQuantite = (map.get(e)).doubleValue();

			// on ajoute la nouvelle quantite
			double newQuantite = oldQuantite + quantite;

			// on met à jour la quantite dans la map
			map.replace(e, newQuantite);
		}
		else {
			//si l'element n'existe pas 
			
			//on l'ajoute dans la map
			Double nouvQuantite = new Double(quantite);
			map.put(e, nouvQuantite);
		}
	}
	
	/**
	 * Methode pour destocker
	 * @param map 
	 * @param e l'element à destocker
	 * @param quantite
	 */
	
	public static void removeInMap(Map<Element, Double> map, Element e, double quantite) throws NonExistantException
	{
		//si l'element existe dans la map
		if(map.containsKey(e))
			
		{	//on met à jour la quantite	
			double old = map.get(e);
			
			double nouv = old -quantite; 
			
			map.replace(e, nouv);
		}
		else {
			throw  new NonExistantException(e);
		}
	}
	
	public static void removeInMap(Map<Element,Double> map, Element e)
	{
		map.remove(e);
	}

}
