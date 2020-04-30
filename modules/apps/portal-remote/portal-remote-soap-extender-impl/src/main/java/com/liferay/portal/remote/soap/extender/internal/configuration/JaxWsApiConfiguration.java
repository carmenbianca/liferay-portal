/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.remote.soap.extender.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Carlos Sierra Andrés
 */
@ExtendedObjectClassDefinition(category = "web-api")
@Meta.OCD(
	id = "com.liferay.portal.remote.soap.extender.internal.configuration.JaxWsApiConfiguration",
	localization = "content/Language", name = "jax-ws-api-configuration-name"
)
public interface JaxWsApiConfiguration {

	@Meta.AD(name = "context-path")
	public String contextPath();

	@Meta.AD(deflt = "10000", name = "timeout")
	public long timeout();

}