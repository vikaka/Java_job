package org.example;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;
import org.apache.flink.streaming.util.serialization.SimpleStringSchema;

import java.util.Properties;


/**
 * Created by Vishesh Kakarala on 6/13/2017.
 */
public class job {

    public static void main(String[] args) throws Exception {

        // set up the execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment
                .getExecutionEnvironment();
        Properties properties = new Properties();

        properties.setProperty("bootstrap.servers", "34.203.160.240:9092");
        // only required for Kafka 0.8
        properties.setProperty("zookeeper.connect", "34.203.160.240:2181");
        properties.setProperty("group.id", "test");
        DataStream<String> stream = env.addSource(new FlinkKafkaConsumer010<>("test", new SimpleStringSchema(), properties));
        stream.print();
        // execute program
        env.execute("Java WordCount from SocketTextStream Example");
    }
}





