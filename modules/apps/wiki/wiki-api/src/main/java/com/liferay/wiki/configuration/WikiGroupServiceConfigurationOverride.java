/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.configuration;

/**
 * @author Iván Zaera
 */
public interface WikiGroupServiceConfigurationOverride {

	public String emailPageAddedBodyXml();

	public String emailPageAddedSubjectXml();

	public String emailPageUpdatedBodyXml();

	public String emailPageUpdatedSubjectXml();

	public boolean enableRss();

}