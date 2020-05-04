/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mobile.device.rules.web.internal.exportimport.staged.model.repository;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.PortletDataException;
import com.liferay.exportimport.staged.model.repository.StagedModelRepository;
import com.liferay.mobile.device.rules.model.MDRRule;
import com.liferay.mobile.device.rules.service.MDRRuleLocalService;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Akos Thurzo
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.mobile.device.rules.model.MDRRule",
	service = StagedModelRepository.class
)
public class MDRRuleStagedModelRepository
	implements StagedModelRepository<MDRRule> {

	@Override
	public MDRRule addStagedModel(
			PortletDataContext portletDataContext, MDRRule mdrRule)
		throws PortalException {

		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteStagedModel(MDRRule mdrRule) throws PortalException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteStagedModel(
			String uuid, long groupId, String className, String extraData)
		throws PortalException {

		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteStagedModels(PortletDataContext portletDataContext)
		throws PortalException {

		throw new UnsupportedOperationException();
	}

	@Override
	public MDRRule fetchMissingReference(String uuid, long groupId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public MDRRule fetchStagedModelByUuidAndGroupId(String uuid, long groupId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<MDRRule> fetchStagedModelsByUuidAndCompanyId(
		String uuid, long companyId) {

		throw new UnsupportedOperationException();
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext) {

		throw new UnsupportedOperationException();
	}

	@Override
	public MDRRule getStagedModel(long ruleId) throws PortalException {
		return _mdrRuleLocalService.getMDRRule(ruleId);
	}

	@Override
	public void restoreStagedModel(
			PortletDataContext portletDataContext, MDRRule mdrRule)
		throws PortletDataException {

		throw new UnsupportedOperationException();
	}

	@Override
	public MDRRule saveStagedModel(MDRRule mdrRule) throws PortalException {
		throw new UnsupportedOperationException();
	}

	@Override
	public MDRRule updateStagedModel(
			PortletDataContext portletDataContext, MDRRule mdrRule)
		throws PortalException {

		throw new UnsupportedOperationException();
	}

	@Reference
	private MDRRuleLocalService _mdrRuleLocalService;

}