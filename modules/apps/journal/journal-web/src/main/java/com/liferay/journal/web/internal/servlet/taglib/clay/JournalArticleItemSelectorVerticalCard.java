/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.web.internal.servlet.taglib.clay;

import com.liferay.frontend.taglib.clay.servlet.taglib.soy.VerticalCard;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;
import java.util.Locale;

import javax.portlet.RenderRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class JournalArticleItemSelectorVerticalCard implements VerticalCard {

	public JournalArticleItemSelectorVerticalCard(
		JournalArticle article, RenderRequest renderRequest) {

		_article = article;
		_httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);

		_themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	@Override
	public String getElementClasses() {
		return "card-interactive card-interactive-secondary";
	}

	@Override
	public String getIcon() {
		return "web-content";
	}

	@Override
	public String getImageSrc() {
		return HtmlUtil.escape(_article.getArticleImageURL(_themeDisplay));
	}

	@Override
	public String getSubtitle() {
		Date createDate = _article.getModifiedDate();

		String modifiedDateDescription = LanguageUtil.getTimeDescription(
			_httpServletRequest,
			System.currentTimeMillis() - createDate.getTime(), true);

		return LanguageUtil.format(
			_httpServletRequest, "modified-x-ago", modifiedDateDescription);
	}

	@Override
	public String getTitle() {
		String title = _article.getTitle(_themeDisplay.getLocale());

		if (Validator.isNotNull(title)) {
			return HtmlUtil.escape(title);
		}

		Locale defaultLanguage = LocaleUtil.fromLanguageId(
			_article.getDefaultLanguageId());

		return HtmlUtil.escape(_article.getTitle(defaultLanguage));
	}

	@Override
	public boolean isSelectable() {
		return false;
	}

	private final JournalArticle _article;
	private final HttpServletRequest _httpServletRequest;
	private final ThemeDisplay _themeDisplay;

}