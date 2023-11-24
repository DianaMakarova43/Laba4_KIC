package cmd;

import model.input.CSVInput;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import service.MergeCSVProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MergeIgnoreExtraRow {
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file://in").unmarshal(new BindyCsvDataFormat("model.input"))
                        .split(body()).process(new MergeCSVProcessor());
            }

        });
        context.start();
        Thread.sleep(100000);
        context.stop();
    }
}
