/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.store.s3;

import com.amazonaws.services.s3.model.S3Object;

import java.io.File;
import java.io.IOException;

/**
 * @author Michael C. Han
 */
public interface S3FileCache {

	public void cleanUpCacheFiles();

	public File getCacheFile(S3Object s3Object, String fileName)
		throws IOException;

}