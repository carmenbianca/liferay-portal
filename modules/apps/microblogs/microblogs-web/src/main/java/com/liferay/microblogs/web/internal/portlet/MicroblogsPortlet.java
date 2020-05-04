/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.microblogs.web.internal.portlet;

import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.microblogs.constants.MicroblogsPortletKeys;
import com.liferay.microblogs.model.MicroblogsEntry;
import com.liferay.microblogs.service.MicroblogsEntryLocalService;
import com.liferay.microblogs.service.MicroblogsEntryService;
import com.liferay.microblogs.web.internal.util.MicroblogsWebUtil;
import com.liferay.portal.kernel.model.Release;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adolfo Pérez
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.css-class-wrapper=microblogs-portlet",
		"com.liferay.portlet.display-category=category.collaboration",
		"com.liferay.portlet.footer-portlet-javascript=/microblogs/js/main.js",
		"com.liferay.portlet.header-portlet-css=/microblogs/css/main.css",
		"com.liferay.portlet.icon=/microblogs/icons/microblogs.png",
		"javax.portlet.display-name=Microblogs",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.view-template=/microblogs/view.jsp",
		"javax.portlet.name=" + MicroblogsPortletKeys.MICROBLOGS,
		"javax.portlet.portlet-info.keywords=Microblogs",
		"javax.portlet.portlet-info.short-title=Microblogs",
		"javax.portlet.portlet-info.title=Microblogs",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator,guest,power-user,user"
	},
	service = Portlet.class
)
public class MicroblogsPortlet extends MVCPortlet {

	public void deleteMicroblogsEntry(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long microblogsEntryId = ParamUtil.getLong(
			actionRequest, "microblogsEntryId");

		microblogsEntryService.deleteMicroblogsEntry(microblogsEntryId);
	}

	public void updateMicroblogsEntry(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long microblogsEntryId = ParamUtil.getLong(
			actionRequest, "microblogsEntryId");

		String content = ParamUtil.getString(actionRequest, "content");
		int socialRelationType = ParamUtil.getInteger(
			actionRequest, "socialRelationType");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			MicroblogsEntry.class.getName(), actionRequest);

		serviceContext.setAssetTagNames(getAssetTagNames(content));

		if (microblogsEntryId > 0) {
			microblogsEntryService.updateMicroblogsEntry(
				microblogsEntryId, content, socialRelationType, serviceContext);
		}
		else {
			ThemeDisplay themeDisplay =
				(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			int type = ParamUtil.getInteger(actionRequest, "type");
			long parentMicroblogsEntryId = ParamUtil.getLong(
				actionRequest, "parentMicroblogsEntryId");

			microblogsEntryService.addMicroblogsEntry(
				themeDisplay.getUserId(), content, type,
				parentMicroblogsEntryId, socialRelationType, serviceContext);
		}
	}

	public void updateMicroblogsEntryViewCount(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long microblogsEntryId = ParamUtil.getLong(
			actionRequest, "microblogsEntryId");

		MicroblogsEntry microblogsEntry =
			microblogsEntryLocalService.fetchMicroblogsEntry(microblogsEntryId);

		if (microblogsEntry == null) {
			return;
		}

		assetEntryLocalService.incrementViewCounter(
			microblogsEntry.getCompanyId(), 0, MicroblogsEntry.class.getName(),
			microblogsEntryId, 1);
	}

	protected String[] getAssetTagNames(String content) {
		List<String> assetTagNames = new ArrayList<>();

		assetTagNames.addAll(MicroblogsWebUtil.getHashtags(content));

		assetTagNames.addAll(MicroblogsWebUtil.getScreenNames(content));

		return assetTagNames.toArray(new String[0]);
	}

	@Reference(unbind = "-")
	protected void setAssetEntryLocalService(
		AssetEntryLocalService assetEntryLocalService) {

		this.assetEntryLocalService = assetEntryLocalService;
	}

	@Reference(unbind = "-")
	protected void setMicroblogsEntryLocalService(
		MicroblogsEntryLocalService microblogsEntryLocalService) {

		this.microblogsEntryLocalService = microblogsEntryLocalService;
	}

	@Reference(unbind = "-")
	protected void setMicroblogsEntryService(
		MicroblogsEntryService microblogsEntryService) {

		this.microblogsEntryService = microblogsEntryService;
	}

	@Reference(
		target = "(&(release.bundle.symbolic.name=com.liferay.microblogs.web)(&(release.schema.version>=1.0.0)(!(release.schema.version>=2.0.0))))",
		unbind = "-"
	)
	protected void setRelease(Release release) {
	}

	protected AssetEntryLocalService assetEntryLocalService;
	protected MicroblogsEntryLocalService microblogsEntryLocalService;
	protected MicroblogsEntryService microblogsEntryService;

}