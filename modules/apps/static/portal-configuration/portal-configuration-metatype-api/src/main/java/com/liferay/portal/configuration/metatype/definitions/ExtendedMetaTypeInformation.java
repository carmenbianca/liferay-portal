/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.configuration.metatype.definitions;

import org.osgi.service.metatype.MetaTypeInformation;

/**
 * @author Iván Zaera
 */
public interface ExtendedMetaTypeInformation extends MetaTypeInformation {

	@Override
	public ExtendedObjectClassDefinition getObjectClassDefinition(
		String id, String locale);

}