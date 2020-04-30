/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mule.internal.metadata.key;

import com.liferay.mule.internal.metadata.MetadataKeysBuilder;
import com.liferay.mule.internal.oas.OASConstants;

import java.util.Set;

import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.metadata.MetadataContext;
import org.mule.runtime.api.metadata.MetadataKey;
import org.mule.runtime.api.metadata.MetadataResolvingException;
import org.mule.runtime.api.metadata.resolving.TypeKeysResolver;

/**
 * @author Matija Petanjek
 */
public class DeleteEndpointTypeKeysResolver implements TypeKeysResolver {

	@Override
	public String getCategoryName() {
		return "liferay-delete";
	}

	@Override
	public Set<MetadataKey> getKeys(MetadataContext metadataContext)
		throws ConnectionException, MetadataResolvingException {

		return metadataKeysBuilder.buildMetadataKeys(
			metadataContext, OASConstants.OPERATION_DELETE);
	}

	private final MetadataKeysBuilder metadataKeysBuilder =
		new MetadataKeysBuilder();

}