/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.remote.soap.extender;

import java.util.Map;

import javax.xml.namespace.QName;

/**
 * @author Carlos Sierra Andrés
 */
public interface SoapDescriptorBuilder {

	public SoapDescriptor buildSoapDescriptor(
		Object service, Map<String, Object> properties);

	public interface SoapDescriptor {

		public QName getEndpointName();

		public String getPublicationAddress();

		public Class<?> getServiceClass();

		public String getWsdlLocation();

	}

}