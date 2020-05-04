/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.highlight;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Wade Cao
 * @author André de Oliveira
 */
@ProviderType
public interface FieldConfigBuilder {

	public FieldConfig build();

	public FieldConfigBuilder field(String field);

	public FieldConfigBuilder fragmentOffset(Integer fragmentOffset);

	public FieldConfigBuilder fragmentSize(Integer fragmentSize);

	public FieldConfigBuilder numFragments(Integer numFragments);

}