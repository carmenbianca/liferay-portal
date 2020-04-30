/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository;

import java.util.Collection;
import java.util.Locale;

/**
 * @author Adolfo Pérez
 */
public interface RepositoryConfiguration {

	public Collection<Parameter> getParameters();

	public interface Parameter {

		public String getLabel(Locale locale);

		public String getName();

	}

}