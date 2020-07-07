package Broker;

import org.apache.activemq.broker.BrokerService;

public class EmbedBroker {

    public static void main(String[] args) throws Exception {
        //ActiveMQ也支持vm中通信基于嵌入式的Broker
        BrokerService brokerService = new BrokerService();
        brokerService.setUseJmx(true);
        brokerService.addConnector("tcp://localhost:61616");
        brokerService.start();
    }
}
