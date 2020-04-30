/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Michael C. Han
 */
@ExtendedObjectClassDefinition(category = "search")
@Meta.OCD(
	id = "com.liferay.portal.search.solr7.configuration.SolrSSLSocketFactoryConfiguration",
	localization = "content/Language",
	name = "solr7-ssl-socket-factory-configuration-name"
)
public interface SolrSSLSocketFactoryConfiguration {

	@Meta.AD(deflt = "secret", required = false)
	public String keyStorePassword();

	@Meta.AD(deflt = "classpath:/keystore.jks", required = false)
	public String keyStorePath();

	@Meta.AD(deflt = "JKS", required = false)
	public String keyStoreType();

	@Meta.AD(deflt = "secret", required = false)
	public String trustStorePassword();

	@Meta.AD(deflt = "classpath:/truststore.jks", required = false)
	public String trustStorePath();

	@Meta.AD(deflt = "JKS", required = false)
	public String trustStoreType();

	@Meta.AD(deflt = "true", required = false)
	public boolean verifyServerCertificate();

	@Meta.AD(deflt = "true", required = false)
	public boolean verifyServerName();

}