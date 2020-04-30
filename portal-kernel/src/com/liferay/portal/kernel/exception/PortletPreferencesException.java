/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

/**
 * @author Pei-Jung Lan
 */
public class PortletPreferencesException extends PortalException {

	public static class MustBeStrict extends PortletPreferencesException {

		public MustBeStrict(String portletId) {
			super(
				String.format(
					"Portlet preferences for portlet %s must be an instance " +
						"of StrictPortletPreferencesImpl",
					portletId));

			this.portletId = portletId;
		}

		public final String portletId;

	}

	private PortletPreferencesException(String msg) {
		super(msg);
	}

}