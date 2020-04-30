/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service.configuration;

import java.io.InputStream;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Miguel Pastor
 */
@ProviderType
public interface ServiceComponentConfiguration {

	public InputStream getHibernateInputStream();

	public InputStream getModelHintsExtInputStream();

	public InputStream getModelHintsInputStream();

	public String getServletContextName();

	public InputStream getSQLIndexesInputStream();

	public InputStream getSQLSequencesInputStream();

	public InputStream getSQLTablesInputStream();

}