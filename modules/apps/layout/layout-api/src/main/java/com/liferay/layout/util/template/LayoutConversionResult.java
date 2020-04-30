/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.util.template;

import com.liferay.portal.kernel.model.Layout;

/**
 * @author Rubén Pulido
 */
public class LayoutConversionResult {

	public static LayoutConversionResult of(
		LayoutData layoutData, String[] conversionWarningMessages) {

		return new LayoutConversionResult(
			layoutData, conversionWarningMessages, null);
	}

	public static LayoutConversionResult of(
		LayoutData layoutData, String[] conversionWarningMessages,
		Layout draftLayout) {

		return new LayoutConversionResult(
			layoutData, conversionWarningMessages, draftLayout);
	}

	public String[] getConversionWarningMessages() {
		return _conversionWarningMessages;
	}

	public Layout getDraftLayout() {
		return _draftLayout;
	}

	public LayoutData getLayoutData() {
		return _layoutData;
	}

	private LayoutConversionResult(
		LayoutData layoutData, String[] conversionWarningMessages,
		Layout draftLayout) {

		_layoutData = layoutData;
		_conversionWarningMessages = conversionWarningMessages;
		_draftLayout = draftLayout;
	}

	private final String[] _conversionWarningMessages;
	private final Layout _draftLayout;
	private final LayoutData _layoutData;

}