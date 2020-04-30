/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import com.liferay.portal.kernel.model.Portlet;

import javax.portlet.PortletException;

import javax.servlet.ServletContext;

/**
 * @author Brian Wing Shun Chan
 */
public interface PortletInstanceFactory {

	public void clear(Portlet portlet);

	public void clear(Portlet portlet, boolean resetRemotePortletBag);

	public InvokerPortlet create(Portlet portlet, ServletContext servletContext)
		throws PortletException;

	public InvokerPortlet create(
			Portlet portlet, ServletContext servletContext,
			boolean destroyPrevious)
		throws PortletException;

	public void delete(Portlet portlet);

	public void destroy(Portlet portlet);

}