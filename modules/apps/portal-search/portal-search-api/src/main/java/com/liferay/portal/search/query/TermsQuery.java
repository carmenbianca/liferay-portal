/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.query;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface TermsQuery extends Query {

	public void addValue(Object value);

	public void addValues(Object... values);

	public String getField();

	public String[] getValues();

	public boolean isEmpty();

}