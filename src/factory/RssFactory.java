package factory;

import java.util.ArrayList;
import java.util.List;

import domain.Rss;
import product.Product;

public class RssFactory extends Factory {
	
	private static RssFactory singleton = new RssFactory();
	
	private RssFactory() {}
	
	@SuppressWarnings("rawtypes")
	private List owners = new ArrayList<>();
	
	public static RssFactory getInstance() {
		return singleton;
	}
	
	protected Product createProduct(String owner) {
		return new Rss(owner);
	}
	
	@SuppressWarnings("unchecked")
	protected void registerPoduct(Product product) {
		owners.add( ((Rss)product).getOwner() );
	}
	
	@SuppressWarnings("unchecked")
	public List<Rss> getOwners() {
		return owners;
	}

}
