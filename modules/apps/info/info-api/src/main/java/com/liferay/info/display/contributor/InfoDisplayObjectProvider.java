/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.display.contributor;

import java.io.Serializable;

import java.util.Locale;

/**
 * @author Jürgen Kappler
 */
public interface InfoDisplayObjectProvider<T> extends Serializable {

	public long getClassNameId();

	public long getClassPK();

	public long getClassTypeId();

	public String getDescription(Locale locale);

	public T getDisplayObject();

	public long getGroupId();

	public String getKeywords(Locale locale);

	public String getTitle(Locale locale);

	public String getURLTitle(Locale locale);

}