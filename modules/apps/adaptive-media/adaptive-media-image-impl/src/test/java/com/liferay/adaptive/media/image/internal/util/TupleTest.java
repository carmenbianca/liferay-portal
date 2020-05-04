/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.image.internal.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Adolfo Pérez
 */
public class TupleTest {

	@Test
	public void testElementAccess() {
		Tuple<Integer, Integer> tuple = Tuple.of(1, 2);

		Assert.assertEquals(1, (int)tuple.first);
		Assert.assertEquals(2, (int)tuple.second);
	}

}