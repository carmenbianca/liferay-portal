/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.store.s3;

/**
 * @author Michael C. Han
 */
public interface S3KeyTransformer {

	public String getDirectoryKey(
		long companyId, long repositoryId, String folderName);

	public String getFileKey(
		long companyId, long repositoryId, String fileName);

	public String getFileName(String key);

	public String getFileVersionKey(
		long companyId, long repositoryId, String fileName,
		String versionLabel);

	public String getNormalizedFileName(String fileName);

	public String getRepositoryKey(long companyId, long repositoryId);

	public String moveKey(String key, String oldPrefix, String newPrefix);

}