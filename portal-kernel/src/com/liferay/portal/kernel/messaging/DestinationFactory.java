/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.messaging;

import java.util.Collection;

/**
 * @author Michael C. Han
 */
public interface DestinationFactory {

	public Destination createDestination(
		DestinationConfiguration destinationConfiguration);

	public Collection<String> getDestinationTypes();

}