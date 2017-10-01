package factory;

import java.util.LinkedHashMap;
import java.util.Map;

import product.Product;

/**
 * Factoryクラス.
 * 
 * @author Noriyuki-Shimizu
 *
 */
public abstract class Factory {
	
	/** flyweightパターンで用いるマップ **/
	Map<String, Product> map = new LinkedHashMap<>();
	
	/**
	 * 同じインスタンス化を防止する.
	 * @param owner
	 * @return インスタンス化したProductオブジェクト
	 */
	public final Product create(String owner) {
		Product product = map.get(owner);
		if(product == null) {
			product = createProduct(owner);
			registerPoduct(product);
			map.put(owner, product);
		}
		return product;
	}
	
	/**
	 * 子クラスが行うabstractなメソッド
	 * クラスのインスタンス化を行う
	 * @param owner
	 * @return
	 */
	protected abstract Product createProduct(String owner);
	
	/**
	 * インスタンス化する引数を登録するメソッド
	 * @param product
	 */
	protected abstract void registerPoduct(Product product);
}
