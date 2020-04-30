/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.configuration.metatype.definitions;

import java.util.Map;
import java.util.Set;

import org.osgi.service.metatype.ObjectClassDefinition;

/**
 * @author Iván Zaera
 */
public interface ExtendedObjectClassDefinition extends ObjectClassDefinition {

	@Override
	public ExtendedAttributeDefinition[] getAttributeDefinitions(int filter);

	public Map<String, String> getExtensionAttributes(String uri);

	public Set<String> getExtensionUris();

}