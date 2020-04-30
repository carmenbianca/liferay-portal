/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.indexer;

import com.liferay.portal.kernel.model.BaseModel;

import java.util.Optional;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface BaseModelRetriever {

	public Optional<BaseModel<?>> fetchBaseModel(
		String className, long classPK);

}