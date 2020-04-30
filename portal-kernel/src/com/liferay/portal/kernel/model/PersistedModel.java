/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

/**
 * @author Connor McKay
 */
public interface PersistedModel {

	/**
	 * Updates this model instance in the database or adds it if it does not yet
	 * exist. Also notifies the appropriate model listeners.
	 */
	public void persist();

}