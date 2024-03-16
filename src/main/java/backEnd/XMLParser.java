package backEnd;

import java.io.File;
import java.io.FileInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLParser {
  private File file;

  public XMLParser(String fileName) {
    this.file = new File(fileName);
  }

  public NodeList xPath(String expression) throws Exception {
    FileInputStream fileInputStream = new FileInputStream(this.file);
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
    Document xmlDocument = documentBuilder.parse(fileInputStream);
    XPath xPath = XPathFactory.newInstance().newXPath();

    NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);

    fileInputStream.close();

    return nodeList;
  }
}
