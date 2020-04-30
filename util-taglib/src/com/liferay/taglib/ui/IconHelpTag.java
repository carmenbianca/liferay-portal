/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.ui;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.taglib.util.TagResourceBundleUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Scott Lee
 * @author Shuyang Zhou
 */
public class IconHelpTag extends IconTag {

	@Override
	protected String getPage() {
		return super.getPage();
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {
		setCssClass("taglib-icon-help");
		setIcon("question-circle-full");
		setId(StringUtil.randomId());
		setLocalizeMessage(false);
		setMarkupView("lexicon");

		setMessage(
			LanguageUtil.get(
				TagResourceBundleUtil.getResourceBundle(pageContext),
				getMessage()));

		setToolTip(true);

		super.setAttributes(httpServletRequest);
	}

}