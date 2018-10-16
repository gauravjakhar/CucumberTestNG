package objectRepo;

import java.io.File;
import java.io.FileWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import utility.Drivers;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ORCreater {

	public static void main(String[] args) {
		writeInTheObjectRepositoryClassFile(CreateOR());
	}

	private static String CreateOR() {
		String str = "package objectModel;\n\nimport org.openqa.selenium.By;\nimport java.util.List;\nimport org.openqa.selenium.WebElement;\n";
		str = str + "import utility.Drivers;\n\npublic class ObjectRepository extends Drivers{\n";
		try {
			File allFiles = new File("OR_XMLs");
			for (File inputFile : allFiles.listFiles()) {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(inputFile);
				doc.getDocumentElement().normalize();
				str = str + "\n\tpublic static class " + doc.getDocumentElement().getAttribute("name") + "{";
				NodeList nList = doc.getElementsByTagName("WebElement");
				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);
					Element eElement = (Element) nNode;

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						if (eElement.getAttribute("multiple").equals("true")) {
							str = str + "\n\t\tpublic static List<WebElement> " + eElement.getAttribute("name") + "()";
							str = str + " {return driver.findElements(By." + eElement.getAttribute("by");
						} else if (eElement.getAttribute("multiple").equals("false")) {
							str = str + "\n\t\tpublic static WebElement " + eElement.getAttribute("name") + "()";
							str = str + " {return driver.findElement(By." + eElement.getAttribute("by");
						}
						str = str + "(\"" + eElement.getAttribute("using") + "\"));}";
					}
				}
				str = str + "\n\t}\n";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		str = str + "\n}";
		return str;
	}

	private static void writeInTheObjectRepositoryClassFile(String data) {
		File file = new File("src//objectModel//ObjectRepository.java");
		FileWriter fr = null;
		try {
			fr = new FileWriter(file);
			fr.write(data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
