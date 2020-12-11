package xml;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ParseXml {
    public static Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    String xml="<?xml version=\"1.0\" encoding=\"utf-8\"?><Package><StreamingNo>907743</StreamingNo><OPFlag>0104</OPFlag><ProductID>6600067000</ProductID><OfferID></OfferID><BizID>00000129490010</BizID><AreaCode>000</AreaCode><CustID>1000003049940000</CustID><CustAccount>1000003049940000</CustAccount><CustName>婷婷大集中测试</CustName><ProductInfo><Product><ProductInstID>2020121014583001507_980_202011021</ProductInstID><ProductType>202011021</ProductType><ProductValue>刘新宇liuxinyu</ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product><Product><ProductInstID>2020121014583001507_980_202011023</ProductInstID><ProductType>202011023</ProductType><ProductValue>liuxinyu@qq.com</ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product><Product><ProductInstID>2020121014583001507_980_10020287</ProductInstID><ProductType>10020287</ProductType><ProductValue><![CDATA[M5#2&frdg]]></ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product><Product><ProductInstID>2020121014583001507_980_142002634</ProductInstID><ProductType>142002634</ProductType><ProductValue>19878909878</ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product><Product><ProductInstID>2020121014583001507_980_10020139</ProductInstID><ProductType>10020139</ProductType><ProductValue>132830001</ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product><Product><ProductInstID>2020121014583001507_980_202011022</ProductInstID><ProductType>202011022</ProductType><ProductValue>18510173350</ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product><Product><ProductInstID>2020121014583001507_980_10020286</ProductInstID><ProductType>10020286</ProductType><ProductValue>admin43433491</ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product><Product><ProductInstID>2020121014583001507_980_142002635</ProductInstID><ProductType>142002635</ProductType><ProductValue>ADMIN</ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product><Product><ProductInstID>2020121014583001507_980_142002636</ProductInstID><ProductType>142002636</ProductType><ProductValue>19878909878@163.COM</ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product><Product><ProductInstID>2020121014583001507_980_10020080</ProductInstID><ProductType>10020080</ProductType><ProductValue>农业</ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product><Product><ProductInstID>2020121014583001507_980_142002637</ProductInstID><ProductType>142002637</ProductType><ProductValue>900</ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product></ProductInfo><Summary></Summary><ReturnStatus>00000</ReturnStatus></Package>";

    String xml2 = "<?xml version=\"1.0\" encoding=\"utf-8\"?><Package><StreamingNo>907749</StreamingNo><OPFlag>0104</OPFlag><ProductID>6600067000</ProductID><OfferID></OfferID><BizID>00000129510010</BizID><AreaCode>000</AreaCode><CustID>1000003049940000</CustID><CustAccount>1000003049940000</CustAccount><CustName>婷婷大集中测试</CustName><ProductInfo><Product><ProductInstID>2020121017585301513_732_202011021</ProductInstID><ProductType>202011021</ProductType><ProductValue>刘新宇liuxinyu</ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product><Product><ProductInstID>2020121017585301513_732_202011023</ProductInstID><ProductType>202011023</ProductType><ProductValue>liuxinyu@qq.com</ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product><Product><ProductInstID>2020121017585301513_732_10020287</ProductInstID><ProductType>10020287</ProductType><ProductValue><![CDATA[adW&56D5]]></ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product><Product><ProductInstID>2020121017585301513_732_142002634</ProductInstID><ProductType>142002634</ProductType><ProductValue>19098765677</ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product><Product><ProductInstID>2020121017585301513_732_10020139</ProductInstID><ProductType>10020139</ProductType><ProductValue>132830002</ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product><Product><ProductInstID>2020121017585301513_732_202011022</ProductInstID><ProductType>202011022</ProductType><ProductValue>18510173350</ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product><Product><ProductInstID>2020121017585301513_732_10020286</ProductInstID><ProductType>10020286</ProductType><ProductValue>admin1210098</ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product><Product><ProductInstID>2020121017585301513_732_142002635</ProductInstID><ProductType>142002635</ProductType><ProductValue>北京管理员</ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product><Product><ProductInstID>2020121017585301513_732_142002636</ProductInstID><ProductType>142002636</ProductType><ProductValue>43654365@1223.com</ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product><Product><ProductInstID>2020121017585301513_732_10020080</ProductInstID><ProductType>10020080</ProductType><ProductValue>银行</ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product><Product><ProductInstID>2020121017585301513_732_142002637</ProductInstID><ProductType>142002637</ProductType><ProductValue>46</ProductValue><ParentType></ParentType><ProductParentInstID></ProductParentInstID></Product></ProductInfo><Summary></Summary><ReturnStatus>00000</ReturnStatus></Package>";
    @Test
    public void contextLoads() {
        try {
            PortalResultRes portalResultRes =parseQueryRes4PortalRes(xml2);
            System.out.println(gson.toJson(portalResultRes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析领航客户/用户查询接口响应
     *
     * @param response
     * @return
     * @throws Exception
     */
    public static PortalResultRes parseQueryRes4PortalRes(String response) throws Exception {
        PortalResultRes result = new PortalResultRes();
        List<Product> pdtList = new ArrayList<Product>();

        Document document = DocumentHelper.parseText(response);

        Element Package = document.getRootElement();

        Element OPFlag = Package.element("OPFlag");
        Element ProductID = Package.element("ProductID");
        Element OfferID = Package.element("OfferID");
        Element BizID = Package.element("BizID");
        Element AreaCode = Package.element("AreaCode");
        Element CustID = Package.element("CustID");
        Element CustAccount = Package.element("CustAccount");
        Element CustName = Package.element("CustName");


        Element UserID = Package.element("UserID");
        Element AccType = Package.element("AccType");
        Element AccName = Package.element("AccName");

        Element Summary = Package.element("Summary");
        Element ReturnStatus = Package.element("ReturnStatus");

        result.setOPFlag(OPFlag == null ? "" : OPFlag.getText());
        result.setProductID(ProductID == null ? "" : ProductID.getText());
        result.setOfferID(OfferID == null ? "" : OfferID.getText());
        result.setBizID(BizID == null ? "" : BizID.getText());
        result.setAreaCode(AreaCode == null ? "" : AreaCode.getText());
        result.setCustID(CustID == null ? "" : CustID.getText());
        result.setCustAccount(CustAccount == null ? "" : CustAccount.getText());
        result.setCustName(CustName == null ? "" : CustName.getText());

        result.setUserID(UserID == null ? "" : UserID.getText());
        result.setAccType(AccType == null ? "" : AccType.getText());
        result.setAccName(AccName == null ? "" : AccName.getText());

        result.setSummary(Summary == null ? "" : Summary.getText());
        result.setReturnStatus(ReturnStatus.getText());

        if (response.contains("ProductInfo")) {
            Element ProductInfo = Package.element("ProductInfo");
            Iterator it = ProductInfo.elements().iterator();
            while (it.hasNext()) {
                Element Product = (Element) it.next();
                Element ProductInstID = Product.element("ProductInstID");
                Element ProductType = Product.element("ProductType");
                Element ProductValue = Product.element("ProductValue");
                Element ParentType = Product.element("ParentType");
                Element ProductParentInstID = Product.element("ProductParentInstID");
                Product pdt = new Product();
                pdt.setProductInstID(ProductInstID == null ? "" : ProductInstID.getText());
                pdt.setProductType(ProductType == null ? "" : ProductType.getText());
                pdt.setProductValue(ProductValue == null ? "" : ProductValue.getText());
                pdt.setParentType(ParentType == null ? "" : ParentType.getText());
                pdt.setProductParentInstID(ProductParentInstID == null ? "" : ProductParentInstID
                        .getText());
                pdtList.add(pdt);
            }
        }
        result.setProductInfo(pdtList);
        return result;
    }


     /* @param document 要转换的xml
 * @param charset 字符编码 设置成 utf-8
            * @param istrans 设置成 false;
 * @return
         */
    public static String formatXml(String document) {
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        StringWriter sw = new StringWriter();
        XMLWriter xw = new XMLWriter(sw, format);
        xw.setEscapeText(true);
        try {
            xw.write(document);
            xw.flush();
            xw.close();
        } catch (IOException e) {
            System.out.println("格式化XML文档发生异常，请检查！");
            e.printStackTrace();
        }
        return sw.toString();
    }
}
