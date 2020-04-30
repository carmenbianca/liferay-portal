/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bean.portlet.cdi.extension.internal;

import java.util.Dictionary;
import java.util.Map;
import java.util.Set;

import javax.portlet.filter.PortletFilter;

/**
 * @author Neil Griffin
 */
public interface BeanFilter {

	public Class<? extends PortletFilter> getFilterClass();

	public String getFilterName();

	public Map<String, String> getInitParams();

	public Set<String> getLifecycles();

	public int getOrdinal();

	public Set<String> getPortletNames();

	public Dictionary<String, Object> toDictionary();

}