/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.internal;

import com.liferay.portal.kernel.test.ReflectionTestUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Neil Griffin
 */
public class HeaderResponseImplTest {

	@Test
	public void testWellFormedXML() {
		_testTagName("link");
		_testTagName("LINK");
		_testTagName("meta");
		_testTagName("META");
	}

	private void _testTagName(String tagName) {
		String openTag = "<" + tagName + ">";
		String closeTag = "</" + tagName + ">";

		String openTagCloseTag = openTag + closeTag;

		String actual = ReflectionTestUtil.invoke(
			HeaderResponseImpl.class, "_addClosingTags",
			new Class<?>[] {String.class}, openTag);

		Assert.assertEquals(openTagCloseTag, actual);

		actual = ReflectionTestUtil.invoke(
			HeaderResponseImpl.class, "_addClosingTags",
			new Class<?>[] {String.class}, openTagCloseTag);

		Assert.assertEquals(openTagCloseTag, actual);

		actual = ReflectionTestUtil.invoke(
			HeaderResponseImpl.class, "_addClosingTags",
			new Class<?>[] {String.class}, "<head>" + openTag + "</head>");

		String openCloseTagInsideHead = "<head>" + openTagCloseTag + "</head>";

		Assert.assertEquals(openCloseTagInsideHead, actual);

		actual = ReflectionTestUtil.invoke(
			HeaderResponseImpl.class, "_addClosingTags",
			new Class<?>[] {String.class}, openCloseTagInsideHead);

		Assert.assertEquals(openCloseTagInsideHead, actual);
	}

}