package cn.com.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

/**
 * @program: jd
 * @description:
 * @author: Lillie
 * @create: 2018-07-03 09:59
 **/
public class XmlUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(XmlUtil.class);
    /**
     * 序列化XML
     *
     * @param object
     * @return
     */
    public static String marshal(Object object, String uuid) throws Exception{
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            // 编码格式
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            // 格式化XML
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            marshaller.marshal(object, outputStream);
            return outputStream.toString("UTF-8");
        } catch (Exception e) {
            LOGGER.error(uuid + " 序列化异常:{}", e);
            throw new Exception( "序列化异常" + e);
        }
    }

    /**
     * 反序列化XML
     */
    @SuppressWarnings("unchecked")
    public static <T> T unMarshal(Class cls, String objStr) throws JAXBException, UnsupportedEncodingException {
        JAXBContext context = JAXBContext.newInstance(cls);
        Unmarshaller unMarshaller = context.createUnmarshaller();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(objStr.getBytes("UTF-8"));
        return (T) unMarshaller.unmarshal(inputStream);
    }

    @SuppressWarnings("unchecked")
    public static <T> T unMarshal2(Class cls, String objStr) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(cls);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (T) unmarshaller.unmarshal(new StringReader(objStr));
    }

    /**
     * 忽略命名空间，转换成实体类
     * @param cls 目标类类
     * @param objStr 源数据
     * @param <T>
     * @return
     * @throws JAXBException
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    public static <T> T unMarshal3(Class cls, String objStr) throws JAXBException, ParserConfigurationException, SAXException {

        JAXBContext jaxbContext = JAXBContext.newInstance(cls);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(objStr);
        SAXParserFactory sax = SAXParserFactory.newInstance();
        //设置忽略命名空间
        sax.setNamespaceAware(false);
        XMLReader xmlReader = sax.newSAXParser().getXMLReader();
        Source source = new SAXSource(xmlReader, new InputSource(reader));

        return (T) unmarshaller.unmarshal(source);
    }
}
