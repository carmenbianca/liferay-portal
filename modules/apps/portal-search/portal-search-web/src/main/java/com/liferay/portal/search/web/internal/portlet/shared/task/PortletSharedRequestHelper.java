/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.portlet.shared.task;

import java.util.Optional;

import javax.portlet.RenderRequest;

/**
 * @author André de Oliveira
 */
public interface PortletSharedRequestHelper {

	public <T> Optional<T> getAttribute(
		String name, RenderRequest renderRequest);

	public String getCompleteURL(RenderRequest renderRequest);

	public Optional<String> getParameter(
		String name, RenderRequest renderRequest);

	public Optional<String[]> getParameterValues(
		String name, RenderRequest renderRequest);

	public void setAttribute(
		String name, Object attributeValue, RenderRequest renderRequest);

}