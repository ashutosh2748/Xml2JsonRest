package com.example.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.domain.Data;
import com.example.domain.FormObject;
@Service
@Primary
public class TemperatureServiceImpl implements TemperatureService {
	
	
	static String urlA = "https://graphical.weather.gov/xml/sample_products/browser_interface/ndfdXMLclient.php?zipCodeList=";
	
	static String urlB = "&product=time-series&numdays=7&maxt=maxt";
	
	static int N=7;

	@Override
	public FormObject getTemperatureforWeek(String zip) {
		FormObject formObject=FormObject.getFormObject(N,zip);
		String input = zip;
		try {

			URL url = new URL(urlA + input + urlB);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			System.out.println(url);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/xml");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			try {

				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(conn.getInputStream());

				doc.getDocumentElement().normalize();

				NodeList nList = doc.getElementsByTagName("temperature");

				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);

					NamedNodeMap nmap = nNode.getAttributes();

					if (nmap.getNamedItem("type").getNodeValue().equals("maximum")) {

						for (int i = 0; i < 7; i++) {
							if (nNode.getNodeType() == Node.ELEMENT_NODE) {

								Element eElement = (Element) nNode;
								Data data=new Data("Day " + (i + 1),eElement.getElementsByTagName("value").item(i).getTextContent());
								
								formObject.getData()[i]=data;
								
							

							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return formObject;
	}
	
	

}
