/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.application.list;

import com.liferay.portal.kernel.model.Group;

import javax.servlet.http.HttpServletRequest;

/**
 * Provides an interface that defines how a <code>Group</code> (in
 * <code>portal-kernel</code>) associated with a servlet request is stored and
 * retrieved.
 *
 * @author Julio Camarero
 */
public interface GroupProvider {

	/**
	 * Returns the <code>Group</code> associated with the request.
	 *
	 * @param  httpServletRequest the servlet request used to retrieve the group
	 * @return the <code>Group</code> associated with the request
	 */
	public Group getGroup(HttpServletRequest httpServletRequest);

	/**
	 * Sets the <code>Group</code> to associate with the request.
	 *
	 * @param httpServletRequest the servlet request used to associate the
	 *        <code>Group</code>
	 * @param group the <code>Group</code> to associate with the request
	 */
	public void setGroup(HttpServletRequest httpServletRequest, Group group);

}