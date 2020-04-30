/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model.field.builder;

import com.liferay.digital.signature.model.field.PostalCodeDSField;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface PostalCodeDSFieldBuilder
	extends SenderInputRequiredDSFieldBuilder<PostalCodeDSFieldBuilder>,
			UserEntryDSFieldBuilder<PostalCodeDSField> {
}