/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.spi.model.result.contributor;

/**
 * @author Michael C. Han
 */
public interface ModelVisibilityContributor {

	public boolean isVisible(long classPK, int status);

}