/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Alicia García
 */
@ExtendedObjectClassDefinition(generateUI = false)
@Meta.OCD(
	id = "com.liferay.document.library.web.internal.configuration.FFDocumentLibraryDDMEditorConfiguration"
)
public interface FFDocumentLibraryDDMEditorConfiguration {

	@Meta.AD(deflt = "false", required = false)
	public boolean useDataEngineEditor();

}