/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package org.springframework.xd.dirt.stream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.xd.test.rabbit.RabbitTestSupport;

/**
 * @author Mark Fisher
 */
public class RabbitSingleNodeStreamDeploymentIntegrationTests extends
		AbstractSingleNodeStreamDeploymentIntegrationTests {

	@Rule
	public RabbitTestSupport rabbitAvailableRule = new RabbitTestSupport();

	@BeforeClass
	public static void setUp() {
		setUp("rabbit");
	}

	@AfterClass
	public static void cleanup() {
		RabbitAdmin admin = context.getBean(RabbitAdmin.class);
		admin.deleteQueue("xd.deployer");
		admin.deleteExchange("xd.undeployer");
	}

}
