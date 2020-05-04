/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.internal.instance.lifecycle;

import com.liferay.dynamic.data.mapping.util.DefaultDDMStructureHelper;
import com.liferay.journal.configuration.JournalServiceConfiguration;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.instance.lifecycle.BasePortalInstanceLifecycleListener;
import com.liferay.portal.instance.lifecycle.PortalInstanceLifecycleListener;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Portal;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(
	configurationPid = "com.liferay.journal.configuration.JournalServiceConfiguration",
	immediate = true, service = PortalInstanceLifecycleListener.class
)
public class AddDefaultJournalStructuresPortalInstanceLifecycleListener
	extends BasePortalInstanceLifecycleListener {

	@Override
	public void portalInstanceRegistered(Company company) throws Exception {
		if (!_journalServiceConfiguration.addDefaultStructures()) {
			return;
		}

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddGuestPermissions(true);
		serviceContext.setAddGroupPermissions(true);

		Group group = _groupLocalService.getCompanyGroup(
			company.getCompanyId());

		serviceContext.setScopeGroupId(group.getGroupId());

		long defaultUserId = _userLocalService.getDefaultUserId(
			company.getCompanyId());

		serviceContext.setUserId(defaultUserId);

		Class<?> clazz = getClass();

		_defaultDDMStructureHelper.addDDMStructures(
			defaultUserId, group.getGroupId(),
			_portal.getClassNameId(JournalArticle.class),
			clazz.getClassLoader(),
			"com/liferay/journal/internal/upgrade/v1_0_0/dependencies" +
				"/basic-web-content-structure.xml",
			serviceContext);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_journalServiceConfiguration = ConfigurableUtil.createConfigurable(
			JournalServiceConfiguration.class, properties);
	}

	@Reference(unbind = "-")
	protected void setDefaultDDMStructureHelper(
		DefaultDDMStructureHelper defaultDDMStructureHelper) {

		_defaultDDMStructureHelper = defaultDDMStructureHelper;
	}

	@Reference(unbind = "-")
	protected void setGroupLocalService(GroupLocalService groupLocalService) {
		_groupLocalService = groupLocalService;
	}

	@Reference(unbind = "-")
	protected void setJournalArticleLocalService(
		JournalArticleLocalService journalArticleLocalService) {
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(
		ModuleServiceLifecycle moduleServiceLifecycle) {
	}

	@Reference(unbind = "-")
	protected void setUserLocalService(UserLocalService userLocalService) {
		_userLocalService = userLocalService;
	}

	private DefaultDDMStructureHelper _defaultDDMStructureHelper;
	private GroupLocalService _groupLocalService;
	private volatile JournalServiceConfiguration _journalServiceConfiguration;

	@Reference
	private Portal _portal;

	private UserLocalService _userLocalService;

}