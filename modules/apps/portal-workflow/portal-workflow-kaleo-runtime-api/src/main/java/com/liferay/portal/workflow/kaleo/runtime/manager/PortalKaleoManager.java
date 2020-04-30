/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.manager;

/**
 * @author Michael C. Han
 */
public interface PortalKaleoManager {

	public void deleteKaleoData(long companyId) throws Exception;

	public void deployDefaultDefinitionLink(String assetClassName)
		throws Exception;

	public void deployDefaultDefinitionLinks() throws Exception;

	public void deployDefaultDefinitionLinks(long companyId) throws Exception;

	public void deployDefaultDefinitions() throws Exception;

	public void deployDefaultDefinitions(long companyId) throws Exception;

	public void deployDefaultRoles() throws Exception;

	public void deployDefaultRoles(long companyId) throws Exception;

	public void deployKaleoDefaults() throws Exception;

	public void deployKaleoDefaults(long companyId) throws Exception;

}