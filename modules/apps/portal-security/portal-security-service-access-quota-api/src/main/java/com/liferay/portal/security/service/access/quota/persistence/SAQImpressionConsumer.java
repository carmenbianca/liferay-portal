/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.service.access.quota.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Stian Sigvartsen
 */
@ProviderType
public interface SAQImpressionConsumer {

	public Status consume(SAQImpression saqImpression);

	public enum Status {

		HUNGRY, SATISFIED

	}

}