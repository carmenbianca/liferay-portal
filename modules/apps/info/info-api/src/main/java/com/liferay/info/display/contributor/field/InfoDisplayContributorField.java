/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.display.contributor.field;

import java.util.Locale;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Jürgen Kappler
 */
@ProviderType
public interface InfoDisplayContributorField<T> {

	public String getKey();

	public String getLabel(Locale locale);

	public InfoDisplayContributorFieldType getType();

	public Object getValue(T model, Locale locale);

}