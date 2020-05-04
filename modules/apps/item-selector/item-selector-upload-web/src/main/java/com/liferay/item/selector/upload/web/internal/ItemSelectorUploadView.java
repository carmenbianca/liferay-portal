/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector.upload.web.internal;

import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.ItemSelectorReturnTypeResolverHandler;
import com.liferay.item.selector.ItemSelectorView;
import com.liferay.item.selector.criteria.DownloadFileEntryItemSelectorReturnType;
import com.liferay.item.selector.criteria.FileEntryItemSelectorReturnType;
import com.liferay.item.selector.criteria.upload.criterion.UploadItemSelectorCriterion;
import com.liferay.item.selector.upload.web.internal.display.context.ItemSelectorUploadViewDisplayContext;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ListUtil;

import java.io.IOException;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ambrín Chaudhary
 */
@Component(
	property = "item.selector.view.key=upload", service = ItemSelectorView.class
)
public class ItemSelectorUploadView
	implements ItemSelectorView<UploadItemSelectorCriterion> {

	public static final String ITEM_SELECTOR_UPLOAD_VIEW_DISPLAY_CONTEXT =
		"ITEM_SELECTOR_UPLOAD_VIEW_DISPLAY_CONTEXT";

	@Override
	public Class<UploadItemSelectorCriterion> getItemSelectorCriterionClass() {
		return UploadItemSelectorCriterion.class;
	}

	public ServletContext getServletContext() {
		return _servletContext;
	}

	@Override
	public List<ItemSelectorReturnType> getSupportedItemSelectorReturnTypes() {
		return _supportedItemSelectorReturnTypes;
	}

	@Override
	public String getTitle(Locale locale) {
		return LanguageUtil.get(locale, "upload-image");
	}

	@Override
	public void renderHTML(
			ServletRequest servletRequest, ServletResponse servletResponse,
			UploadItemSelectorCriterion uploadItemSelectorCriterion,
			PortletURL portletURL, String itemSelectedEventName, boolean search)
		throws IOException, ServletException {

		ServletContext servletContext = getServletContext();

		RequestDispatcher requestDispatcher =
			servletContext.getRequestDispatcher("/upload.jsp");

		ItemSelectorUploadViewDisplayContext
			itemSelectorUploadViewDisplayContext =
				new ItemSelectorUploadViewDisplayContext(
					uploadItemSelectorCriterion, this, itemSelectedEventName,
					_itemSelectorReturnTypeResolverHandler);

		servletRequest.setAttribute(
			ITEM_SELECTOR_UPLOAD_VIEW_DISPLAY_CONTEXT,
			itemSelectorUploadViewDisplayContext);

		requestDispatcher.include(servletRequest, servletResponse);
	}

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.item.selector.upload.web)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	private static final List<ItemSelectorReturnType>
		_supportedItemSelectorReturnTypes = Collections.unmodifiableList(
			ListUtil.fromArray(
				new DownloadFileEntryItemSelectorReturnType(),
				new FileEntryItemSelectorReturnType()));

	@Reference
	private ItemSelectorReturnTypeResolverHandler
		_itemSelectorReturnTypeResolverHandler;

	private ServletContext _servletContext;

}