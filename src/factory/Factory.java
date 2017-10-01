package factory;

import java.util.LinkedHashMap;
import java.util.Map;

import product.Product;

/**
 * Factory�N���X.
 * 
 * @author Noriyuki-Shimizu
 *
 */
public abstract class Factory {
	
	/** flyweight�p�^�[���ŗp����}�b�v **/
	Map<String, Product> map = new LinkedHashMap<>();
	
	/**
	 * �����C���X�^���X����h�~����.
	 * @param owner
	 * @return �C���X�^���X������Product�I�u�W�F�N�g
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
	 * �q�N���X���s��abstract�ȃ��\�b�h
	 * �N���X�̃C���X�^���X�����s��
	 * @param owner
	 * @return
	 */
	protected abstract Product createProduct(String owner);
	
	/**
	 * �C���X�^���X�����������o�^���郁�\�b�h
	 * @param product
	 */
	protected abstract void registerPoduct(Product product);
}
