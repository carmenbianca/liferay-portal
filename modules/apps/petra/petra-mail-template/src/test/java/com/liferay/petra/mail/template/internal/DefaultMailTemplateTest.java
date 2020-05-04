/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.mail.template.internal;

import com.liferay.mail.kernel.template.MailTemplate;
import com.liferay.mail.kernel.template.MailTemplateContext;
import com.liferay.mail.kernel.template.MailTemplateContextBuilder;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.EscapableLocalizableFunction;
import com.liferay.portal.kernel.util.EscapableObject;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Adolfo Pérez
 */
public class DefaultMailTemplateTest {

	@Before
	public void setUp() {
		MailTemplateContextBuilder mailTemplateContextBuilder =
			new DefaultMailTemplateContextBuilder();

		mailTemplateContextBuilder.put("[$PLACEHOLDER$]", "replacement");
		mailTemplateContextBuilder.put(
			"[$ESCAPED_VALUE$]", new EscapableObject<>("<>", true));
		mailTemplateContextBuilder.put(
			"[$LOCALIZED_VALUE$]",
			new EscapableLocalizableFunction(Locale::getLanguage));
		mailTemplateContextBuilder.put("[$PORTAL_URL$]", "http://liferay.com");

		_mailTemplateContext = mailTemplateContextBuilder.build();
	}

	@Test
	public void testEmptyTemplate() throws Exception {
		MailTemplate mailTemplate = new DefaultMailTemplate(
			StringPool.BLANK, false);

		String result = mailTemplate.renderAsString(
			Locale.ENGLISH, _mailTemplateContext);

		Assert.assertEquals(StringPool.BLANK, result);
	}

	@Test
	public void testHrefAbsoluteURLRewriting() throws Exception {
		String template = "<a href=\"/resource\">";

		MailTemplate mailTemplate = new DefaultMailTemplate(template, false);

		String result = mailTemplate.renderAsString(
			Locale.ENGLISH, _mailTemplateContext);

		Assert.assertEquals("<a href=\"http://liferay.com/resource\">", result);
	}

	@Test
	public void testSrcAbsoluteURLRewriting() throws Exception {
		String template = "<img src=\"/resource\">";

		MailTemplate mailTemplate = new DefaultMailTemplate(template, false);

		String result = mailTemplate.renderAsString(
			Locale.ENGLISH, _mailTemplateContext);

		Assert.assertEquals(
			"<img src=\"http://liferay.com/resource\">", result);
	}

	@Test
	public void testTemplateWithEscapedPlaceholder() throws Exception {
		String template = "This template contains a [$ESCAPED_VALUE$]";

		MailTemplate mailTemplate = new DefaultMailTemplate(template, false);

		String result = mailTemplate.renderAsString(
			Locale.ENGLISH, _mailTemplateContext);

		Assert.assertEquals("This template contains a <>", result);
	}

	@Test
	public void testTemplateWithLocalizedPlaceholder() throws Exception {
		String template = "This template is in [$LOCALIZED_VALUE$]";

		MailTemplate mailTemplate = new DefaultMailTemplate(template, false);

		String result = mailTemplate.renderAsString(
			Locale.ENGLISH, _mailTemplateContext);

		Assert.assertEquals("This template is in en", result);
	}

	@Test
	public void testTemplateWithNoPlaceholder() throws Exception {
		String template = StringUtil.randomString();

		MailTemplate mailTemplate = new DefaultMailTemplate(template, false);

		String result = mailTemplate.renderAsString(
			Locale.ENGLISH, _mailTemplateContext);

		Assert.assertEquals(template, result);
	}

	@Test
	public void testTemplateWithPlaceholder() throws Exception {
		String template = "This template contains a [$PLACEHOLDER$]";

		MailTemplate mailTemplate = new DefaultMailTemplate(template, false);

		String result = mailTemplate.renderAsString(
			Locale.ENGLISH, _mailTemplateContext);

		Assert.assertEquals("This template contains a replacement", result);
	}

	private MailTemplateContext _mailTemplateContext;

}