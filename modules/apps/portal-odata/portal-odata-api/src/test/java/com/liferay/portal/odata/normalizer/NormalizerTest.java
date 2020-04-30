/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.odata.normalizer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Eduardo García
 */
public class NormalizerTest {

	@Test
	public void testNormalizeIdentifier() {
		String identifier = Normalizer.normalizeIdentifier(
			"Aaa Ááá Üüü B'bb (Ccc) Ñññ d_d _[]+-./&ªº!|\"·$=?¿¡`^*¨´Ç};:-");

		Assert.assertEquals("Aaa_Ááá_Üüü_Bbb_Ccc_Ñññ_d_d__ªºÇ", identifier);
	}

}