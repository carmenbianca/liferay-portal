/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.util;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Eudaldo Alonso
 */
public interface LayoutClassedModelUsageRecorder {

	public void record(long classNameId, long classPK) throws PortalException;

}