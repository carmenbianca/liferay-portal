/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository.registry;

import com.liferay.portal.kernel.repository.capabilities.Capability;

/**
 * @author Adolfo Pérez
 */
public interface CapabilityRegistry<T> {

	public <S extends Capability> void addExportedCapability(
		Class<S> capabilityClass, S capability);

	public <S extends Capability> void addSupportedCapability(
		Class<S> capabilityClass, S capability);

	public T getTarget();

}