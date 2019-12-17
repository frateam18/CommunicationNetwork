import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXMLFile {

	public static void main(String[] args) {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("small_graph.graphml");
			
			NodeList graphlist = doc.getElementsByTagName("graph");
			for(int i=0; i<graphlist.getLength();i++) {
				Node g = graphlist.item(i);
				if(g.getNodeType() == Node.ELEMENT_NODE) {
					Element graph = (Element) g;
					String id = graph.getAttribute("id");
					String edgedefault = graph.getAttribute("edgedefault");
				System.out.println("Graph : "+ id);
				System.out.println("Edgedefault: "+edgedefault);
				}
				
				NodeList nodelist = doc.getElementsByTagName("node");
				for(int k=0; i<nodelist.getLength();k++) {
					Node n = nodelist.item(k);
					if(n.getNodeType() == Node.ELEMENT_NODE) {
						Element node = (Element) n;
						String id = node.getAttribute("id");
						
					System.out.println("Id: "+ id);	
					}
					
					NodeList datalist= doc.getElementsByTagName("data");
					 
					Node d = datalist.item(k);
					if(d.getNodeType() == Node.ELEMENT_NODE) {
						Element data = (Element) d;
						String key = data.getAttribute("key");
							
					System.out.println("Key: "+key);	
						}	
				}
				NodeList edgelist = doc.getElementsByTagName("edge");
				for(int k=0; k<edgelist.getLength();k++) {
					Node e = edgelist.item(k);
					if(e.getNodeType() == Node.ELEMENT_NODE) {
						Element edge = (Element) e;
						String target = edge.getAttribute("target");
						String source = edge.getAttribute("source");
					
					System.out.println("Target: "+target+ "Source: "+source);	
					}
				}
			}	
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
