/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eduardo García
 */
public class RequiredSegmentsEntryException extends PortalException {

	public RequiredSegmentsEntryException() {
	}

	public RequiredSegmentsEntryException(String msg) {
		super(msg);
	}

	public RequiredSegmentsEntryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RequiredSegmentsEntryException(Throwable cause) {
		super(cause);
	}

	public static class
		MustNotDeleteSegmentsEntryReferencedBySegmentsExperiences
			extends RequiredSegmentsEntryException {

		public MustNotDeleteSegmentsEntryReferencedBySegmentsExperiences(
			long segmentsEntryId) {

			super(
				String.format(
					"Segments entry %s cannot be deleted because it is " +
						"referenced by one or more segments experiences",
					segmentsEntryId));
		}

	}

}