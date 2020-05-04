/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.image.internal.storage;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.repository.model.FileVersion;

/**
 * @author Roberto Díaz
 */
public class AMStoreUtil {

	public static String getFileVersionPath(
		FileVersion fileVersion, String configurationUuid) {

		StringBundler sb = new StringBundler(11);

		sb.append("adaptive/");
		sb.append(configurationUuid);
		sb.append("/");
		sb.append(fileVersion.getGroupId());
		sb.append("/");
		sb.append(fileVersion.getRepositoryId());
		sb.append("/");
		sb.append(fileVersion.getFileEntryId());
		sb.append("/");
		sb.append(fileVersion.getFileVersionId());
		sb.append("/");

		return sb.toString();
	}

}