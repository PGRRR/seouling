package com.pgrrr.woohaha.api.bus;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.net.URL;
import java.net.URLEncoder;

public class Test {
    public static void main(String[] args){


        try{

            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6410000/busarrivalservice/getBusArrivalList"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=pYR6Y3Q/eSHYdkHNUYBvZkrl6CgXo57zIa/nrSwJ1XNhq4ypcWfhVcn6yMVMkthsm3Z7m7HYQi9VKD2Ul2vCvg=="); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("stationId", "UTF-8") + "=" + URLEncoder.encode("200000078", "UTF-8")); /*정류소ID*/
            URL url = new URL(urlBuilder.toString());

            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url.toString());

            //XPath 선언
            XPath xPath = XPathFactory.newInstance().newXPath();

            // 절대경로
            Node node = (Node) xPath.evaluate("/response/msgBody/busArrivalList/plateNo1",document, XPathConstants.NODE);

//      Node node = (Node) xPath.evaluate("//book/title",document, XPathConstants.NODE);

            System.out.println(node.getTextContent());


        }catch(Exception e){
            e.printStackTrace();

        }

    }
}