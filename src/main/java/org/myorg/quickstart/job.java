package org.myorg.quickstart;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer08;
import org.apache.flink.streaming.util.serialization.SimpleStringSchema;
import java.util.Properties;


import java.util.Properties;

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
		DataStream<String> stream = env.addSource(new FlinkKafkaConsumer08<>("test", new SimpleStringSchema(), properties));
		stream.print();
		// execute program
		env.execute("Java WordCount from SocketTextStream Example");
	}
}
