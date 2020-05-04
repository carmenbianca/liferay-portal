/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.service.impl;

import com.liferay.layout.page.template.model.LayoutPageTemplateStructureRel;
import com.liferay.layout.page.template.service.base.LayoutPageTemplateStructureRelLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eduardo García
 */
@Component(
	property = "model.class.name=com.liferay.layout.page.template.model.LayoutPageTemplateStructureRel",
	service = AopService.class
)
public class LayoutPageTemplateStructureRelLocalServiceImpl
	extends LayoutPageTemplateStructureRelLocalServiceBaseImpl {

	@Override
	public LayoutPageTemplateStructureRel addLayoutPageTemplateStructureRel(
			long userId, long groupId, long layoutPageTemplateStructureId,
			long segmentsExperienceId, String data,
			ServiceContext serviceContext)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		long layoutPageTemplateStructureRelId = counterLocalService.increment();

		LayoutPageTemplateStructureRel layoutPageTemplateStructureRel =
			layoutPageTemplateStructureRelPersistence.create(
				layoutPageTemplateStructureRelId);

		layoutPageTemplateStructureRel.setUuid(serviceContext.getUuid());
		layoutPageTemplateStructureRel.setGroupId(groupId);
		layoutPageTemplateStructureRel.setCompanyId(user.getCompanyId());
		layoutPageTemplateStructureRel.setUserId(user.getUserId());
		layoutPageTemplateStructureRel.setUserName(user.getFullName());
		layoutPageTemplateStructureRel.setCreateDate(
			serviceContext.getCreateDate(new Date()));
		layoutPageTemplateStructureRel.setModifiedDate(
			serviceContext.getModifiedDate(new Date()));
		layoutPageTemplateStructureRel.setLayoutPageTemplateStructureId(
			layoutPageTemplateStructureId);
		layoutPageTemplateStructureRel.setSegmentsExperienceId(
			segmentsExperienceId);
		layoutPageTemplateStructureRel.setData(data);

		return layoutPageTemplateStructureRelPersistence.update(
			layoutPageTemplateStructureRel);
	}

	@Override
	@SystemEvent(type = SystemEventConstants.TYPE_DELETE)
	public LayoutPageTemplateStructureRel deleteLayoutPageTemplateStructureRel(
			long layoutPageTemplateStructureId, long segmentsExperienceId)
		throws PortalException {

		LayoutPageTemplateStructureRel layoutPageTemplateStructureRel =
			layoutPageTemplateStructureRelPersistence.findByL_S(
				layoutPageTemplateStructureId, segmentsExperienceId);

		layoutPageTemplateStructureRelPersistence.remove(
			layoutPageTemplateStructureRel);

		return layoutPageTemplateStructureRel;
	}

	@Override
	public void deleteLayoutPageTemplateStructureRels(
		long layoutPageTemplateStructureId) {

		layoutPageTemplateStructureRelPersistence.
			removeByLayoutPageTemplateStructureId(
				layoutPageTemplateStructureId);
	}

	@Override
	public void deleteLayoutPageTemplateStructureRelsBySegmentsExperienceId(
		long segmentsExperienceId) {

		layoutPageTemplateStructureRelPersistence.removeBySegmentsExperienceId(
			segmentsExperienceId);
	}

	@Override
	public LayoutPageTemplateStructureRel fetchLayoutPageTemplateStructureRel(
		long layoutPageTemplateStructureId, long segmentsExperienceId) {

		return layoutPageTemplateStructureRelPersistence.fetchByL_S(
			layoutPageTemplateStructureId, segmentsExperienceId);
	}

	@Override
	public List<LayoutPageTemplateStructureRel>
		getLayoutPageTemplateStructureRels(long layoutPageTemplateStructureId) {

		return layoutPageTemplateStructureRelPersistence.
			findByLayoutPageTemplateStructureId(layoutPageTemplateStructureId);
	}

	@Override
	public List<LayoutPageTemplateStructureRel>
		getLayoutPageTemplateStructureRelsBySegmentsExperienceId(
			long segmentsExperienceId) {

		return layoutPageTemplateStructureRelPersistence.
			findBySegmentsExperienceId(segmentsExperienceId);
	}

	@Override
	public LayoutPageTemplateStructureRel updateLayoutPageTemplateStructureRel(
			long layoutPageTemplateStructureId, long segmentsExperienceId,
			String data)
		throws PortalException {

		LayoutPageTemplateStructureRel layoutPageTemplateStructureRel =
			layoutPageTemplateStructureRelPersistence.findByL_S(
				layoutPageTemplateStructureId, segmentsExperienceId);

		layoutPageTemplateStructureRel.setModifiedDate(new Date());
		layoutPageTemplateStructureRel.setData(data);

		return layoutPageTemplateStructureRelPersistence.update(
			layoutPageTemplateStructureRel);
	}

}