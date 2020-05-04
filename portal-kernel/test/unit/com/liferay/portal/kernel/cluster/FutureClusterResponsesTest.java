/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.cluster;

import java.net.InetAddress;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael C. Han
 */
public class FutureClusterResponsesTest {

	@Test
	public void testMultipleResponseFailure() throws Exception {
		Set<String> clusterNodeIds = new HashSet<>();

		clusterNodeIds.add("1.2.3.4");
		clusterNodeIds.add("1.2.3.5");
		clusterNodeIds.add("1.2.3.6");

		FutureClusterResponses futureClusterResponses =
			new FutureClusterResponses(clusterNodeIds);

		futureClusterResponses.addClusterNodeResponse(
			ClusterNodeResponse.createResultClusterNodeResponse(
				new ClusterNode("1.2.3.4", InetAddress.getLocalHost()), null,
				null));
		futureClusterResponses.addClusterNodeResponse(
			ClusterNodeResponse.createResultClusterNodeResponse(
				new ClusterNode("1.2.3.5", InetAddress.getLocalHost()), null,
				null));

		try {
			futureClusterResponses.get(500, TimeUnit.MILLISECONDS);

			Assert.fail("Should have failed");
		}
		catch (TimeoutException timeoutException) {
		}
	}

	@Test
	public void testMultipleResponseSuccess() throws Exception {
		Set<String> clusterNodeIds = new HashSet<>();

		clusterNodeIds.add("1.2.3.4");
		clusterNodeIds.add("1.2.3.5");
		clusterNodeIds.add("1.2.3.6");

		FutureClusterResponses futureClusterResponses =
			new FutureClusterResponses(clusterNodeIds);

		futureClusterResponses.addClusterNodeResponse(
			ClusterNodeResponse.createResultClusterNodeResponse(
				new ClusterNode("1.2.3.4", InetAddress.getLocalHost()), null,
				null));
		futureClusterResponses.addClusterNodeResponse(
			ClusterNodeResponse.createResultClusterNodeResponse(
				new ClusterNode("1.2.3.5", InetAddress.getLocalHost()), null,
				null));
		futureClusterResponses.addClusterNodeResponse(
			ClusterNodeResponse.createResultClusterNodeResponse(
				new ClusterNode("1.2.3.6", InetAddress.getLocalHost()), null,
				null));

		futureClusterResponses.get(500, TimeUnit.MILLISECONDS);
	}

	@Test
	public void testSingleResponseFailure() throws InterruptedException {
		Set<String> clusterNodeIds = new HashSet<>();

		clusterNodeIds.add("1.2.3.4");

		FutureClusterResponses futureClusterResponses =
			new FutureClusterResponses(clusterNodeIds);

		try {
			futureClusterResponses.get(500, TimeUnit.MILLISECONDS);

			Assert.fail("Should have failed");
		}
		catch (TimeoutException timeoutException) {
		}
	}

	@Test
	public void testSingleResponseSuccess() throws Exception {
		Set<String> clusterNodeIds = new HashSet<>();

		clusterNodeIds.add("test");

		FutureClusterResponses futureClusterResponses =
			new FutureClusterResponses(clusterNodeIds);

		futureClusterResponses.addClusterNodeResponse(
			ClusterNodeResponse.createResultClusterNodeResponse(
				new ClusterNode("test", InetAddress.getLocalHost()), null,
				null));

		futureClusterResponses.get(500, TimeUnit.MILLISECONDS);
	}

}