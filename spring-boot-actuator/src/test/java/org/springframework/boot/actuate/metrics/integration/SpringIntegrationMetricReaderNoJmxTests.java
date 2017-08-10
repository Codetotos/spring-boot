/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.actuate.metrics.integration;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.autoconfigure.metrics.PublicMetricsAutoConfiguration;
import org.springframework.boot.actuate.endpoint.MetricReaderPublicMetrics;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link SpringIntegrationMetricReader}.
 *
 * @author Artem Bilan
 */
@RunWith(SpringRunner.class)
@SpringBootTest("spring.jmx.enabled=false")
@DirtiesContext
public class SpringIntegrationMetricReaderNoJmxTests {

	@Autowired
	@Qualifier("springIntegrationPublicMetrics")
	private MetricReaderPublicMetrics integrationMetricReader;

	@Test
	public void test() {
		assertThat(this.integrationMetricReader.metrics().size() > 0).isTrue();
	}

	@Configuration
	@Import({ IntegrationAutoConfiguration.class, PublicMetricsAutoConfiguration.class })
	protected static class TestConfiguration {

	}

}
