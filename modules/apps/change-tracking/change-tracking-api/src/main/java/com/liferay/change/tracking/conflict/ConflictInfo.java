/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.conflict;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Preston Crary
 */
@ProviderType
public interface ConflictInfo {

	public String getConflictDescription(ResourceBundle resourceBundle);

	public long getCTAutoResolutionInfoId();

	public String getResolutionDescription(ResourceBundle resourceBundle);

	public ResourceBundle getResourceBundle(Locale locale);

	public long getSourcePrimaryKey();

	public long getTargetPrimaryKey();

	public boolean isResolved();

}