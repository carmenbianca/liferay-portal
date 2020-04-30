/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bean.portlet.cdi.extension.internal;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Neil Griffin
 */
public interface BeanApp {

	public Map<String, List<String>> getContainerRuntimeOptions();

	public Set<String> getCustomPortletModes();

	public String getDefaultNamespace();

	public List<Event> getEvents();

	public List<Map.Entry<Integer, String>> getPortletListeners();

	public Map<String, PublicRenderParameter> getPublicRenderParameters();

	public String getSpecVersion();

}