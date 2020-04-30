/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.query;

import com.liferay.portal.search.script.Script;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface TermsSetQuery extends Query {

	public String getFieldName();

	public String getMinimumShouldMatchField();

	public Script getMinimumShouldMatchScript();

	public List<Object> getValues();

	public Boolean isCached();

	public void setCached(Boolean cached);

	public String setMinimumShouldMatchField(String minimumShouldMatchField);

	public void setMinimumShouldMatchScript(Script minimumShouldMatchScript);

}