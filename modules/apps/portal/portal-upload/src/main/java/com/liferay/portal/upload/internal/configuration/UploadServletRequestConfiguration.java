/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upload.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Pei-Jung Lan
 */
@ExtendedObjectClassDefinition(category = "infrastructure")
@Meta.OCD(
	id = "com.liferay.portal.upload.internal.configuration.UploadServletRequestConfiguration",
	localization = "content/Language",
	name = "upload-servlet-request-configuration-name"
)
public interface UploadServletRequestConfiguration {

	@Meta.AD(
		deflt = "104857600", description = "max-size-help",
		name = "overall-maximum-upload-request-size", required = false
	)
	public long maxSize();

	@Meta.AD(
		deflt = "50", description = "max-tries-help",
		name = "overall-maximum-unique-file-name-tries", required = false
	)
	public long maxTries();

	@Meta.AD(
		description = "temp-dir-help", name = "temporary-storage-directory",
		required = false
	)
	public String tempDir();

}