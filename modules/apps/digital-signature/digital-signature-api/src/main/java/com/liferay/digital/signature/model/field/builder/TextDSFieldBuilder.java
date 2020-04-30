/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model.field.builder;

import com.liferay.digital.signature.model.field.TextDSField;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface TextDSFieldBuilder
	extends SenderInputRequiredDSFieldBuilder<TextDSFieldBuilder>,
			UserEntryDSFieldBuilder<TextDSField> {

	public TextDSFieldBuilder setFormula(String formula);

}