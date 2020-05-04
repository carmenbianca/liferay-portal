/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ExtendedObjectClassDefinition(category = "search")
@Meta.OCD(
	id = "com.liferay.portal.search.configuration.IndexerRegistryConfiguration",
	localization = "content/Language",
	name = "indexer-registry-configuration-name"
)
@ProviderType
public interface IndexerRegistryConfiguration {

	@Meta.AD(deflt = "true", name = "buffered", required = false)
	public boolean buffered();

	@Meta.AD(
		deflt = "DEFAULT", name = "buffered-execution-mode", required = false
	)
	public String bufferedExecutionMode();

	@Meta.AD(deflt = "10000", name = "max-buffer-size", required = false)
	public int maxBufferSize();

	@Meta.AD(
		deflt = "0.90", max = "0.99", min = "0.1",
		name = "minimum-buffer-availability-percentage", required = false
	)
	public float minimumBufferAvailabilityPercentage();

}