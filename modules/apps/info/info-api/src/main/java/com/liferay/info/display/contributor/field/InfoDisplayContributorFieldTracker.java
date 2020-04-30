/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.display.contributor.field;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Jürgen Kappler
 */
@ProviderType
public interface InfoDisplayContributorFieldTracker {

	public List<InfoDisplayContributorField> getInfoDisplayContributorFields(
		String className);

	public List<InfoDisplayContributorField> getInfoDisplayContributorFields(
		String... classNames);

}