/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.lpkg.deployer;

import java.io.IOException;

import org.junit.Test;

/**
 * @author Matthew Tambara
 */
public class LPKGDowngradeTest extends LPKGVersionChangeTestCase {

	@Test
	public void testDownGradeLPKG() throws IOException {
		testVersionChange(0, 0, -1);
	}

}