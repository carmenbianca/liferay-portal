/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.highlight;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Wade Cao
 */
@ProviderType
public interface Highlights {

	public HighlightBuilder builder();

	public FieldConfig fieldConfig(String field);

	public FieldConfigBuilder fieldConfigBuilder();

	public Highlight highlight(FieldConfig fieldConfig);

}