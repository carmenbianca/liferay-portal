/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.fabric.netty.agent;

import com.liferay.portal.kernel.test.rule.CodeCoverageAssertor;
import com.liferay.util.SerializableUtil;

import java.io.File;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;

/**
 * @author Shuyang Zhou
 */
public class NettyFabricAgentConfigTest {

	@ClassRule
	public static final CodeCoverageAssertor codeCoverageAssertor =
		CodeCoverageAssertor.INSTANCE;

	@Test
	public void testConstructor() {
		try {
			new NettyFabricAgentConfig(null);

			Assert.fail();
		}
		catch (NullPointerException nullPointerException) {
		}

		File repositoryFolder = new File("RepositoryFolder");

		NettyFabricAgentConfig nettyFabricAgentConfig =
			new NettyFabricAgentConfig(repositoryFolder);

		Assert.assertEquals(
			repositoryFolder.toPath(),
			nettyFabricAgentConfig.getRepositoryPath());
	}

	@Test
	public void testSerialization() {
		File repositoryFolder = new File("RepositoryFolder");

		NettyFabricAgentConfig copyNettyFabricAgentConfig =
			(NettyFabricAgentConfig)SerializableUtil.deserialize(
				SerializableUtil.serialize(
					new NettyFabricAgentConfig(repositoryFolder)));

		Assert.assertEquals(
			repositoryFolder.toPath(),
			copyNettyFabricAgentConfig.getRepositoryPath());
	}

}