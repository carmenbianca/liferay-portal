/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector.web.internal;

import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.ItemSelectorView;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Iván Zaera
 */
public class MediaItemSelectorView
	implements ItemSelectorView<MediaItemSelectorCriterion> {

	@Override
	public Class<MediaItemSelectorCriterion> getItemSelectorCriterionClass() {
		return MediaItemSelectorCriterion.class;
	}

	@Override
	public List<ItemSelectorReturnType> getSupportedItemSelectorReturnTypes() {
		return _supportedItemSelectorReturnTypes;
	}

	@Override
	public String getTitle(Locale locale) {
		return MediaItemSelectorView.class.getName();
	}

	@Override
	public void renderHTML(
			ServletRequest servletRequest, ServletResponse servletResponse,
			MediaItemSelectorCriterion mediaItemSelectorCriterion,
			PortletURL portletURL, String itemSelectedEventName, boolean search)
		throws IOException {

		PrintWriter printWriter = servletResponse.getWriter();

		printWriter.print(
			"<html>" + MediaItemSelectorView.class.getName() + "</html>");
	}

	private static final List<ItemSelectorReturnType>
		_supportedItemSelectorReturnTypes = Collections.singletonList(
			new TestURLItemSelectorReturnType());

}