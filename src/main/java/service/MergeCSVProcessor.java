package service;

import model.input.CSVInput;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import java.util.Map;

public class MergeCSVProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
        Message in = exchange.getIn();
        Map<String, Object> body = (Map<String, Object>) in.getBody();

        CSVInput obj = (CSVInput) body.get("model.input.CSVInput");

        System.out.println( "name:" + obj.getColumn1() + ", secondname:" + obj.getColumn2() + ", city:" + obj.getColumn3());

    }
}
