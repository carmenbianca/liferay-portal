/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.user.associated.data.component;

/**
 * Provides the base interface for the UAD framework. Do not implement this
 * interface directly.
 *
 * @author Drew Brokke
 * @param  <T> the entity type to be anonymized, deleted, displayed, edited, or
 *         exported. This is also used as an identifier for grouping the various
 *         components.
 * @see    com.liferay.user.associated.data.anonymizer.UADAnonymizer
 * @see    com.liferay.user.associated.data.display.UADDisplay
 * @see    com.liferay.user.associated.data.exporter.UADExporter
 */
public interface UADComponent<T> {

	/**
	 * Returns the class representing the extending components' data types.
	 *
	 * @return the identifying class of type {@code T}
	 */
	public Class<T> getTypeClass();

}