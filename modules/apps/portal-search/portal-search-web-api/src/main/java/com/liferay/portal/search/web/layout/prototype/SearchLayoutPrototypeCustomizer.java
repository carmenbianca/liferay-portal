/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.layout.prototype;

import com.liferay.portal.kernel.model.Layout;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface SearchLayoutPrototypeCustomizer {

	public void customize(Layout layout) throws Exception;

	public String getLayoutTemplateId();

}