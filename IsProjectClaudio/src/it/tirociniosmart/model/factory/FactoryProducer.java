
/**
 * Classe che permette di ottenere un oggetto producer di Factory per iniettare le classi DAO, è un singleton.
 * @author Armando Ferrara
 * 
 */package it.tirociniosmart.model.factory;

public class FactoryProducer {
/**
 * Il FactoryProducer deve essere consistente per tutte le classi.
 */
	private volatile static FactoryProducer dataSource;
	/**
	 * costruttore privato perché è un singleton
	 */
	private FactoryProducer(){
		
	}
	/**
	 * Permette di ottenere un istanza di FactoryProducer
	 * @return FactoryProducer
	 */
	public static  FactoryProducer getIstance()
	{
		
	}
}
