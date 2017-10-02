package domain;

import logic.GetRss;
import product.Product;
import rssInterface.RssInterface;

/**
 * Product�̎q�N���X.
 * Rss�̐�����s���N���X.
 * 
 * @author Noriyuki-Shimizu
 *
 */
public class Rss extends Product {
	
	/** �C���X�^���X������L�[�ƂȂ�ϐ� **/
	private String owner;
	
	/**	Rss�N���X�̃��W�b�N�N���X **/
	private RssInterface getRss;

    /**
     * ��������̃R���X�g���N�^.
     * @param owner
     */
    public Rss(String owner) {
        System.out.println("Create rss: " + owner);
        
        // Adapter�p�^�[��
        // Rss�̃C���X�^���X���ƂƂ��ɁA���W�b�N�N���X���C���X�^���X������
        getRss = new GetRss(); 
        
        this.owner = owner;
    }

    public void use(String url) {
        System.out.println("Use rss: " + owner);
        getRss.parseXML(url);
    }
    
    /**
     * �C���X�^���X�������L�[���擾���郁�\�b�h.
     * @return
     */
    public String getOwner() {
        return owner;
    }
	
}
