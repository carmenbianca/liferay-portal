/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.mobile.device.detection.fiftyonedegrees.data;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Michael C. Han
 */
public interface DataFileProvider {

	public InputStream getDataFileInputStream() throws IOException;

}