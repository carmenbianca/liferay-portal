/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletContextBagPool {

	public static void clear() {
		_portletContextBagPool._portletContextBagMap.clear();
	}

	public static PortletContextBag get(String servletContextName) {
		return _portletContextBagPool._get(servletContextName);
	}

	public static void put(
		String servletContextName, PortletContextBag portletContextBag) {

		_portletContextBagPool._put(servletContextName, portletContextBag);
	}

	public static PortletContextBag remove(String servletContextName) {
		return _portletContextBagPool._remove(servletContextName);
	}

	private PortletContextBagPool() {
		_portletContextBagMap = new ConcurrentHashMap<>();
	}

	private PortletContextBag _get(String servletContextName) {
		return _portletContextBagMap.get(servletContextName);
	}

	private void _put(
		String servletContextName, PortletContextBag portletContextBag) {

		_portletContextBagMap.put(servletContextName, portletContextBag);
	}

	private PortletContextBag _remove(String servletContextName) {
		return _portletContextBagMap.remove(servletContextName);
	}

	private static final PortletContextBagPool _portletContextBagPool =
		new PortletContextBagPool();

	private final Map<String, PortletContextBag> _portletContextBagMap;

}