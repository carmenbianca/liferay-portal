/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.fabric.repository;

import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;

import java.nio.file.Path;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Shuyang Zhou
 */
public class RepositoryHelperUtil {

	public static Path getRepositoryFilePath(
		Path repositoryPath, Path remoteFilePath) {

		Path fileNamePath = remoteFilePath.getFileName();

		String name = fileNamePath.toString();

		int index = name.lastIndexOf(CharPool.PERIOD);

		if (index == -1) {
			StringBundler sb = new StringBundler(5);

			sb.append(name);
			sb.append(StringPool.DASH);
			sb.append(System.currentTimeMillis());
			sb.append(StringPool.DASH);
			sb.append(idGenerator.getAndIncrement());

			return repositoryPath.resolve(sb.toString());
		}

		StringBundler sb = new StringBundler(6);

		sb.append(name.substring(0, index));
		sb.append(StringPool.DASH);
		sb.append(System.currentTimeMillis());
		sb.append(StringPool.DASH);
		sb.append(idGenerator.getAndIncrement());
		sb.append(name.substring(index));

		return repositoryPath.resolve(sb.toString());
	}

	protected static final AtomicLong idGenerator = new AtomicLong();

}