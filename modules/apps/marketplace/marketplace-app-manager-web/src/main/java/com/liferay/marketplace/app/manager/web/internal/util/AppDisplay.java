/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.marketplace.app.manager.web.internal.util;

import java.util.List;

import javax.portlet.MimeResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.framework.Bundle;

/**
 * @author Ryan Park
 */
public interface AppDisplay extends Comparable<AppDisplay> {

	public static final String APP_TITLE_UNCATEGORIZED = "Independent Modules";

	public void addBundle(Bundle bundle);

	public List<Bundle> getBundles();

	public String getDescription();

	public String getDisplaySuiteTitle();

	public String getDisplayTitle();

	public String getDisplayURL(MimeResponse mimeResponse);

	public String getIconURL(HttpServletRequest httpServletRequest);

	public int getState();

	public String getStoreURL(HttpServletRequest httpServletRequest);

	public String getTitle();

	public String getVersion();

	public boolean isRequired();

}