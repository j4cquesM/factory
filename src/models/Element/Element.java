package models.Element;
/**
 * 
 * @author claude
 *
 */
public class Element {
	private String nom;
	private String codeUnique;
	private String uniteMesure;
	private double prixAchat;
	private double prixVente;
	
	
	
	
	public Element(String nom, String codeUnique, String uniteMesure, double prixAchat, double prixVente) {
		this.nom = nom;
		this.codeUnique = codeUnique;
		this.uniteMesure = uniteMesure;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
	}
	
	
	public Element(Element e)
	{
		this(e.getNom(),e.getCodeUnique(),e.getUniteMesure(),e.getPrixAchat(),e.getPrixVente());
	}




	public String getNom() {
		return nom;
	}




	public String getCodeUnique() {
		return codeUnique;
	}




	public String getUniteMesure() {
		return uniteMesure;
	}




	public double getPrixAchat() {
		return prixAchat;
	}




	public double getPrixVente() {
		return prixVente;
	}
	
	

	public boolean isMatierePremiere() {
		
		if( this.prixAchat != 0 )
		{
			return true;
		}
		return false;
	}
	
	public boolean isProduitFini() {
		if( this.prixVente != 0 ) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		
		String message = this.nom+" "+this.codeUnique+" : "+this.prixAchat+" "+this.prixVente+" \n";
		
		return message;
	}
	
	@Override 
	
	public boolean equals(Object e) {
		boolean result = false ; 
		
		if((Element) e == this ) {
			result = true; 
		}
		
		if( ! ( e instanceof Element ) ) {
			result = false ;
			
		}
		
		if ( ((Element) e).getCodeUnique() == this.codeUnique )
		{
			result = true;
		}
		
		return result ;
	} 
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.codeUnique.hashCode();
        return result;
    }





	
	
	
	

}
