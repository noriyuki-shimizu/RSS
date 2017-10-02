package domain;

import logic.GetRss;
import product.Product;
import rssInterface.RssInterface;

/**
 * Productの子クラス.
 * Rssの制御を行うクラス.
 * 
 * @author Noriyuki-Shimizu
 *
 */
public class Rss extends Product {
	
	/** インスタンス化するキーとなる変数 **/
	private String owner;
	
	/**	Rssクラスのロジッククラス **/
	private RssInterface getRss;

    /**
     * 引数ありのコンストラクタ.
     * @param owner
     */
    public Rss(String owner) {
        System.out.println("Create rss: " + owner);
        
        // Adapterパターン
        // Rssのインスタンス化とともに、ロジッククラスもインスタンス化する
        getRss = new GetRss(); 
        
        this.owner = owner;
    }

    public void use(String url) {
        System.out.println("Use rss: " + owner);
        getRss.parseXML(url);
    }
    
    /**
     * インスタンス化したキーを取得するメソッド.
     * @return
     */
    public String getOwner() {
        return owner;
    }
	
}
