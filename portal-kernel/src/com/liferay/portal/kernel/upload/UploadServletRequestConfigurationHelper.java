/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.upload;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Pei-Jung Lan
 */
@ProviderType
public interface UploadServletRequestConfigurationHelper {

	public long getMaxSize();

	public long getMaxTries();

	public String getTempDir();

}