/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.portlet.shared.search;

/**
 * @author Rodrigo Paulino
 */
public interface PortletSharedSearchContributor {

	public void contribute(
		PortletSharedSearchSettings portletSharedSearchSettings);

}