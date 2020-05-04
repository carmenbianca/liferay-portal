/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Brian Wing Shun Chan
 * @author Jorge Ferrer
 */
public class UserIdException extends PortalException {

	public static class MustNotBeNull extends UserIdException {

		public MustNotBeNull() {
			super("User ID must not be null");
		}

	}

	public static class MustNotBeReserved extends UserIdException {

		public MustNotBeReserved(long userId, String[] reservedUserIds) {
			super(
				String.format(
					"User ID %s must not be a reserved one such as: %s", userId,
					StringUtil.merge(reservedUserIds)));

			this.userId = userId;
			this.reservedUserIds = reservedUserIds;
		}

		public final String[] reservedUserIds;
		public final long userId;

	}

	private UserIdException(String msg) {
		super(msg);
	}

}