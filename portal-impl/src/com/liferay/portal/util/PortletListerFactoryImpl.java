/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.util;

import com.liferay.portal.kernel.util.PortletLister;
import com.liferay.portal.kernel.util.PortletListerFactory;

/**
 * @author Jorge Ferrer
 * @author Dennis Ju
 * @author Brian Wing Shun Chan
 */
public class PortletListerFactoryImpl implements PortletListerFactory {

	@Override
	public PortletLister getPortletLister() {
		return new PortletListerImpl();
	}

}