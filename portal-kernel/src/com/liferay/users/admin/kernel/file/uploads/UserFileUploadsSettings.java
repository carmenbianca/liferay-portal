/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.kernel.file.uploads;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Drew Brokke
 */
@ProviderType
public interface UserFileUploadsSettings {

	public int getImageMaxHeight();

	public long getImageMaxSize();

	public int getImageMaxWidth();

	public boolean isImageCheckToken();

	/**
	 * @deprecated As of Athanasius (7.3.x)
	 */
	@Deprecated
	public boolean isImageDefaultUseInitials();

}