package logic;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import rssInterface.RssInterface;

public class GetRss implements RssInterface {

	public void parseXML(String url) {
		try {
            DocumentBuilderFactory  factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder         builder = factory.newDocumentBuilder();
            Document                document = builder.parse(url);
            Element                 root = document.getDocumentElement();

            // channelタグの中の要素を取得し、そのchannelの中のtitleタグの要素を取得し表示する
            NodeList                channel = root.getElementsByTagName("channel");
            NodeList                title = ((Element)channel.item(0)).getElementsByTagName("title");
            System.out.println("\nTitle: " + title.item(0).getFirstChild().getNodeValue() + "\n");

            // itemタグの要素を取得し、ループで回す
            NodeList                item_list = root.getElementsByTagName("item");
            for (int i = 0; i <item_list.getLength(); i++) {
                Element  element = (Element)item_list.item(i);
                NodeList item_title = element.getElementsByTagName("title");
                NodeList item_link  = element.getElementsByTagName("link");
                System.out.println(" title: " + item_title.item(0).getFirstChild().getNodeValue());
                System.out.println(" link:  " + item_link.item(0).getFirstChild().getNodeValue() + "\n");
            }
        } catch (IOException e) {
            System.out.println("IO Exception");
        } catch (ParserConfigurationException e) {
            System.out.println("Parser Configuration Exception");
        } catch (SAXException e) {
            System.out.println("SAX Exception");
        }
        return;
	}
	
}
