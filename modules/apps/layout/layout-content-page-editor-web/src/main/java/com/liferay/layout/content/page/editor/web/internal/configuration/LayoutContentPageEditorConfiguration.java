/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.content.page.editor.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Víctor Galán
 */
@ExtendedObjectClassDefinition(generateUI = false)
@Meta.OCD(
	id = "com.liferay.layout.content.page.editor.web.internal.configuration.LayoutContentPageEditorConfiguration"
)
public interface LayoutContentPageEditorConfiguration {

	@Meta.AD(deflt = "false", required = false)
	public boolean undoEnabled();

}