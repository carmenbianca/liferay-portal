/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.storage;

import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Jeyvison Nascimento
 */
@ProviderType
public interface DataStorage {

	public long delete(long dataStorageId) throws Exception;

	public Map<String, Object> get(long dataDefinitionId, long dataStorageId)
		throws Exception;

	public long save(
			long dataRecordCollectionId, Map<String, Object> dataRecordValues,
			long siteId)
		throws Exception;

}