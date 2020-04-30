/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.item.selector.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Sergio González
 */
@ExtendedObjectClassDefinition(category = "documents-and-media")
@Meta.OCD(
	id = "com.liferay.document.library.item.selector.web.internal.configuration.DLImageItemSelectorViewConfiguration",
	localization = "content/Language", name = "dl-image-item-selector-view-name"
)
public interface DLImageItemSelectorViewConfiguration {

	/**
	 * Set valid file extensions for uploading images to documents and media
	 * image item selector view. A file extension of * will permit all file
	 * extensions
	 */
	@Meta.AD(
		deflt = ".bmp|.gif|.jpeg|.jpg|.png|.svg|.tiff",
		name = "valid-extensions", required = false
	)
	public String[] validExtensions();

}