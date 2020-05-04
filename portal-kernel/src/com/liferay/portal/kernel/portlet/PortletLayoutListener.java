/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import com.liferay.portal.kernel.util.UnicodeProperties;

/**
 * @author Brian Wing Shun Chan
 */
public interface PortletLayoutListener {

	public void onAddToLayout(String portletId, long plid)
		throws PortletLayoutListenerException;

	public void onMoveInLayout(String portletId, long plid)
		throws PortletLayoutListenerException;

	public void onRemoveFromLayout(String portletId, long plid)
		throws PortletLayoutListenerException;

	public void onSetup(String portletId, long plid)
		throws PortletLayoutListenerException;

	public void updatePropertiesOnRemoveFromLayout(
			String portletId, UnicodeProperties typeSettingsUnicodeProperties)
		throws PortletLayoutListenerException;

}