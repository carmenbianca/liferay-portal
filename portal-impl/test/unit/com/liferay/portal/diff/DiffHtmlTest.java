/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.diff;

import com.liferay.portal.kernel.diff.DiffHtml;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.StringReader;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Adolfo Pérez
 */
public class DiffHtmlTest {

	@Test
	public void testDiffMustNotHaveXMLDeclaration() throws Exception {
		String source = StringUtil.randomString();
		String target = StringUtil.randomString();

		String diff = _diffHtml.diff(
			new StringReader(source), new StringReader(target));

		Assert.assertFalse(diff.startsWith("<?xml"));
	}

	@Test
	public void testDiffWhereSourceAndTargetAreDifferent() throws Exception {
		String source = StringUtil.randomString();
		String target = StringUtil.randomString();

		String diff = _diffHtml.diff(
			new StringReader(source), new StringReader(target));

		Assert.assertNotEquals(source, diff);
		Assert.assertNotEquals(target, diff);
	}

	@Test
	public void testDiffWhereSourceAndTargetAreIdentical() throws Exception {
		String content = StringUtil.randomString();

		Assert.assertEquals(
			content,
			_diffHtml.diff(
				new StringReader(content), new StringReader(content)));
	}

	@Test(expected = NullPointerException.class)
	public void testDiffWhereSourceAndTargetAreNull() throws Exception {
		_diffHtml.diff(null, null);
	}

	@Test(expected = NullPointerException.class)
	public void testDiffWhereSourceIsNull() throws Exception {
		_diffHtml.diff(null, new StringReader(StringUtil.randomString()));
	}

	@Test(expected = NullPointerException.class)
	public void testDiffWhereTargetIsNull() throws Exception {
		_diffHtml.diff(new StringReader(StringUtil.randomString()), null);
	}

	private final DiffHtml _diffHtml = new DiffHtmlImpl();

}