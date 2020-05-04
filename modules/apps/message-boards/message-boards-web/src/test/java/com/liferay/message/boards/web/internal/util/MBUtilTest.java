/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.web.internal.util;

import com.liferay.message.boards.model.MBCategory;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.Html;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Props;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;

import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;

/**
 * @author Adolfo Pérez
 */
public class MBUtilTest {

	@BeforeClass
	public static void setUpClass() {
		Html html = Mockito.mock(Html.class);

		Mockito.stub(
			html.escape(Mockito.anyString())
		).toAnswer(
			MBUtilTest::_getFirstArgument
		);

		HtmlUtil htmlUtil = new HtmlUtil();

		htmlUtil.setHtml(html);

		Language language = Mockito.mock(Language.class);

		Mockito.stub(
			language.get(
				Mockito.any(HttpServletRequest.class), Mockito.anyString())
		).toAnswer(
			MBUtilTest::_getSecondArgument
		);

		LanguageUtil languageUtil = new LanguageUtil();

		languageUtil.setLanguage(language);

		Portal portal = Mockito.mock(Portal.class);

		Mockito.stub(
			portal.getUserName(Mockito.any(MBMessage.class))
		).toReturn(
			"USER[]()"
		);

		PortalUtil portalUtil = new PortalUtil();

		portalUtil.setPortal(portal);

		PropsUtil.setProps(Mockito.mock(Props.class));
	}

	@Test
	public void testGetBBCodeQuoteBodyReturnsQuotedContent() {
		MBMessage mbMessage = Mockito.mock(MBMessage.class);

		Mockito.when(
			mbMessage.getBody(Mockito.anyBoolean())
		).thenReturn(
			"CONTENT"
		);

		Assert.assertEquals(
			"[quote=USER&#91;&#93;&#40;&#41;]\nCONTENT[/quote]\n\n\n",
			MBUtil.getBBCodeQuoteBody(
				Mockito.mock(HttpServletRequest.class), mbMessage));
	}

	@Test
	public void testGetCategoryIdReturnsCategoryId() {
		long categoryId = RandomTestUtil.randomInt();

		MBCategory category = Mockito.mock(MBCategory.class);

		Mockito.when(
			category.getCategoryId()
		).thenReturn(
			categoryId
		);

		Assert.assertEquals(
			categoryId,
			MBUtil.getCategoryId(
				Mockito.mock(HttpServletRequest.class), category));
	}

	@Test
	public void testGetCategoryIdReturnsRequestValue() {
		long categoryId = RandomTestUtil.randomInt();

		HttpServletRequest httpServletRequest = Mockito.mock(
			HttpServletRequest.class);

		Mockito.when(
			httpServletRequest.getParameter("mbCategoryId")
		).thenReturn(
			String.valueOf(categoryId)
		);

		Assert.assertEquals(
			categoryId,
			MBUtil.getCategoryId(httpServletRequest, (MBCategory)null));
	}

	@Test
	public void testGetMBMessageCategoryIdReturnsMessageCategoryId() {
		long categoryId = RandomTestUtil.randomInt();

		MBMessage message = Mockito.mock(MBMessage.class);

		Mockito.when(
			message.getCategoryId()
		).thenReturn(
			categoryId
		);

		Assert.assertEquals(
			categoryId,
			MBUtil.getCategoryId(
				Mockito.mock(HttpServletRequest.class), message));
	}

	@Test
	public void testGetMBMessageCategoryIdReturnsRequestValue() {
		long categoryId = RandomTestUtil.randomInt();

		HttpServletRequest httpServletRequest = Mockito.mock(
			HttpServletRequest.class);

		Mockito.when(
			httpServletRequest.getParameter("mbCategoryId")
		).thenReturn(
			String.valueOf(categoryId)
		);

		Assert.assertEquals(
			categoryId,
			MBUtil.getCategoryId(httpServletRequest, (MBMessage)null));
	}

	@Test
	public void testGetMBMessageURLIncludesMessageAnchor() {
		RenderResponse renderResponse = Mockito.mock(RenderResponse.class);

		Mockito.when(
			renderResponse.createRenderURL()
		).thenReturn(
			Mockito.mock(PortletURL.class)
		);

		String namespace = StringUtil.randomString();

		Mockito.when(
			renderResponse.getNamespace()
		).thenReturn(
			namespace
		);

		long messageId = RandomTestUtil.randomInt();

		Assert.assertTrue(
			StringUtil.endsWith(
				MBUtil.getMBMessageURL(messageId, renderResponse),
				StringBundler.concat(
					StringPool.POUND, namespace, "message_", messageId)));

		Assert.assertTrue(
			StringUtil.endsWith(
				MBUtil.getMBMessageURL(
					messageId, StringUtil.randomString(), renderResponse),
				StringBundler.concat(
					StringPool.POUND, namespace, "message_", messageId)));
	}

	private static <T> T _getFirstArgument(InvocationOnMock invocationOnMock) {
		Object[] arguments = invocationOnMock.getArguments();

		return (T)arguments[0];
	}

	private static <T> T _getSecondArgument(InvocationOnMock invocationOnMock) {
		Object[] arguments = invocationOnMock.getArguments();

		return (T)arguments[1];
	}

}