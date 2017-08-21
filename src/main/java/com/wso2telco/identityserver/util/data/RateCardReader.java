package com.wso2telco.identityserver.util.data;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * The Class RateCardReader.
 */
public class RateCardReader {
	
	/**
	 * Check xml.
	 *
	 * @author SulakkhanaW
	 * @param doc the doc
	 * @return the string
	 * @throws XPathExpressionException the x path expression exception
	 */
	public String checkXML(Document doc) throws XPathExpressionException{
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath path = xpathFactory.newXPath();
		XPathExpression exp = path.compile("//Operator[@name='DIALOG']/API");
		NodeList elementList = (NodeList) exp.evaluate(doc, XPathConstants.NODESET);
		for (int tblIndex = 0; tblIndex < elementList.getLength(); tblIndex++) {
			Node table = elementList.item(tblIndex);
			Node nAtt = table.getAttributes().getNamedItem("name");
			System.out.println(nAtt);
		}
		exp = path.compile("//Operator[@name='DIALOG']/API[@name='smsmessaging']/Rate[1]/Name");
		NodeList nameList = (NodeList) exp.evaluate(doc, XPathConstants.NODESET);
		return nameList.item(0).getTextContent().trim();
	}
	
	/**
	 * Calculate ammount.
	 *
	 * @author SulakkhanaW
	 * @param doc the doc
	 * @param parentName the parent name
	 * @param parentValue the parent value
	 * @param returnValueNode the return value node
	 * @return the string
	 */
	public String calculateAmmount(Document doc, String parentName, String parentValue, String returnValueNode) {
		String returnValue = null;
		int parentNodeNumber = returnParentNodeNumber(doc, parentName, parentValue);
		System.out.println(parentNodeNumber);
		NodeList listOfOperator = doc.getElementsByTagName(parentName);
		int totalOperator = listOfOperator.getLength();
		for (int x = 0; x < totalOperator; x++) {
			Node firstOperatorNode = listOfOperator.item(x);
			if (firstOperatorNode.getNodeType() == Node.ELEMENT_NODE) {
				Element firstOperatorElement = (Element) firstOperatorNode;
				NodeList firstNameList = firstOperatorElement.getElementsByTagName("API");
				Element firstNameElement = (Element) firstNameList.item(1);
				firstNameElement.getAttribute("name");
				NodeList textFNList = firstNameElement.getChildNodes();
				System.out.println("First Name : " + ((Node) textFNList.item(0)).getNodeValue().trim());

			}
		}
		return returnValue;
	}
	
	/**
	 * Return parent node number.
	 *
	 * @author SulakkhanaW
	 * @param doc the doc
	 * @param parentName the parent name
	 * @param parentValue the parent value
	 * @return the int
	 */
	public int returnParentNodeNumber(Document doc, String parentName, String parentValue){
		int returnNumber = 0;
		NodeList listOfParents = doc.getElementsByTagName(parentName);
		int totalParents = listOfParents.getLength();
		for (int i = 0; i < totalParents; i++){
			Node parentNode = listOfParents.item(i);
			if (parentNode.getNodeType() == Node.ELEMENT_NODE){
				Element firstParentElement = (Element) listOfParents.item(i);
				String firstParentName = firstParentElement.getAttribute("name");
				if (firstParentName.equalsIgnoreCase(parentValue)){
					return returnNumber = i;
				}
			}
		}
		return returnNumber;
	}
}
