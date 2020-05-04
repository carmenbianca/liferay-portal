/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.admin.web.internal.exportimport.data.handler.helper;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.fragment.model.FragmentEntryLink;
import com.liferay.layout.page.template.model.LayoutPageTemplateStructure;
import com.liferay.layout.page.template.model.LayoutPageTemplateStructureRel;
import com.liferay.layout.page.template.service.LayoutPageTemplateStructureLocalService;
import com.liferay.layout.page.template.service.LayoutPageTemplateStructureRelLocalService;
import com.liferay.layout.util.structure.FragmentLayoutStructureItem;
import com.liferay.layout.util.structure.LayoutStructure;
import com.liferay.layout.util.structure.LayoutStructureItem;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.segments.constants.SegmentsExperienceConstants;
import com.liferay.segments.model.SegmentsExperience;
import com.liferay.segments.service.SegmentsExperienceLocalService;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jürgen Kappler
 */
@Component(
	immediate = true,
	service = LayoutPageTemplateStructureDataHandlerHelper.class
)
public class LayoutPageTemplateStructureDataHandlerHelper {

	public void importLayoutPageTemplateStructure(
			PortletDataContext portletDataContext, long classNameId,
			long classPK, Element layoutPageTemplateStructureElement)
		throws Exception {

		layoutPageTemplateStructureElement.addAttribute(
			"className", String.valueOf(_portal.getClassName(classNameId)));
		layoutPageTemplateStructureElement.addAttribute(
			"classPK", String.valueOf(classPK));

		StagedModelDataHandlerUtil.importStagedModel(
			portletDataContext, layoutPageTemplateStructureElement);

		Map<Long, Long> layoutPageTemplateStructureIds =
			(Map<Long, Long>)portletDataContext.getNewPrimaryKeysMap(
				LayoutPageTemplateStructure.class);

		String path = layoutPageTemplateStructureElement.attributeValue("path");

		LayoutPageTemplateStructure layoutPageTemplateStructure =
			(LayoutPageTemplateStructure)portletDataContext.getZipEntryAsObject(
				path);

		long layoutPageTemplateStructureId = MapUtil.getLong(
			layoutPageTemplateStructureIds,
			layoutPageTemplateStructure.getLayoutPageTemplateStructureId(),
			layoutPageTemplateStructure.getLayoutPageTemplateStructureId());

		LayoutPageTemplateStructure existingLayoutPageTemplateStructure =
			_layoutPageTemplateStructureLocalService.
				fetchLayoutPageTemplateStructure(layoutPageTemplateStructureId);

		if (existingLayoutPageTemplateStructure == null) {
			return;
		}

		List<LayoutPageTemplateStructureRel>
			existingLayoutPageTemplateStructureRels =
				_layoutPageTemplateStructureRelLocalService.
					getLayoutPageTemplateStructureRels(
						layoutPageTemplateStructureId);

		for (LayoutPageTemplateStructureRel
				existingLayoutPageTemplateStructureRel :
					existingLayoutPageTemplateStructureRels) {

			_importLayoutPageTemplateStructureRel(
				portletDataContext, existingLayoutPageTemplateStructureRel);

			_updateSegmentsExperiences(
				classNameId, classPK, existingLayoutPageTemplateStructureRel);
		}
	}

	private void _importLayoutPageTemplateStructureRel(
		PortletDataContext portletDataContext,
		LayoutPageTemplateStructureRel existingLayoutPageTemplateStructureRel) {

		String data = existingLayoutPageTemplateStructureRel.getData();

		if (Validator.isNull(data)) {
			return;
		}

		JSONObject dataJSONObject = _processDataJSONObject(
			data, portletDataContext);

		existingLayoutPageTemplateStructureRel.setData(
			dataJSONObject.toString());

		_layoutPageTemplateStructureRelLocalService.
			updateLayoutPageTemplateStructureRel(
				existingLayoutPageTemplateStructureRel);
	}

	private JSONObject _processDataJSONObject(
		String data, PortletDataContext portletDataContext) {

		LayoutStructure layoutStructure = LayoutStructure.of(data);

		Map<Long, Long> fragmentEntryLinkIds =
			(Map<Long, Long>)portletDataContext.getNewPrimaryKeysMap(
				FragmentEntryLink.class);

		for (LayoutStructureItem layoutStructureItem :
				layoutStructure.getLayoutStructureItems()) {

			if (!(layoutStructureItem instanceof FragmentLayoutStructureItem)) {
				continue;
			}

			FragmentLayoutStructureItem fragmentLayoutStructureItem =
				(FragmentLayoutStructureItem)layoutStructureItem;

			long fragmentEntryLinkId = MapUtil.getLong(
				fragmentEntryLinkIds,
				fragmentLayoutStructureItem.getFragmentEntryLinkId(),
				fragmentLayoutStructureItem.getFragmentEntryLinkId());

			if (fragmentEntryLinkId <= 0) {
				continue;
			}

			fragmentLayoutStructureItem.setFragmentEntryLinkId(
				fragmentEntryLinkId);
		}

		return layoutStructure.toJSONObject();
	}

	private void _updateSegmentsExperiences(
		long classNameId, long classPK,
		LayoutPageTemplateStructureRel existingLayoutPageTemplateStructureRel) {

		if (existingLayoutPageTemplateStructureRel.getSegmentsExperienceId() ==
				SegmentsExperienceConstants.ID_DEFAULT) {

			return;
		}

		SegmentsExperience existingSegmentsExperience =
			_segmentsExperienceLocalService.fetchSegmentsExperience(
				existingLayoutPageTemplateStructureRel.
					getSegmentsExperienceId());

		if (existingSegmentsExperience == null) {
			return;
		}

		existingSegmentsExperience.setClassNameId(classNameId);
		existingSegmentsExperience.setClassPK(classPK);

		_segmentsExperienceLocalService.updateSegmentsExperience(
			existingSegmentsExperience);
	}

	@Reference
	private LayoutPageTemplateStructureLocalService
		_layoutPageTemplateStructureLocalService;

	@Reference
	private LayoutPageTemplateStructureRelLocalService
		_layoutPageTemplateStructureRelLocalService;

	@Reference
	private Portal _portal;

	@Reference
	private SegmentsExperienceLocalService _segmentsExperienceLocalService;

}