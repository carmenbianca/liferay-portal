/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.summary;

import java.util.Locale;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 * @author Bryan Engler
 * @author Ryan Park
 * @author Tibor Lipusz
 */
@ProviderType
public interface SummaryBuilder {

	public Summary build();

	public void setContent(String content);

	public void setEscape(boolean escape);

	public void setHighlight(boolean highlight);

	public void setLocale(Locale locale);

	public void setMaxContentLength(int maxContentLength);

	public void setTitle(String title);

}