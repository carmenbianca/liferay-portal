/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.web.internal.info.display.contributor;

import com.liferay.asset.info.display.field.AssetEntryInfoDisplayFieldProvider;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryService;
import com.liferay.info.display.contributor.InfoDisplayContributor;
import com.liferay.info.display.contributor.InfoDisplayField;
import com.liferay.info.display.contributor.InfoDisplayObjectProvider;
import com.liferay.info.display.field.ExpandoInfoDisplayFieldProvider;
import com.liferay.info.display.field.InfoDisplayFieldProvider;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 */
@Component(service = InfoDisplayContributor.class)
public class BlogsEntryInfoDisplayContributor
	implements InfoDisplayContributor<BlogsEntry> {

	@Override
	public String getClassName() {
		return BlogsEntry.class.getName();
	}

	@Override
	public Set<InfoDisplayField> getInfoDisplayFields(
			long classTypeId, Locale locale)
		throws PortalException {

		Set<InfoDisplayField> infoDisplayFields =
			_infoDisplayFieldProvider.getContributorInfoDisplayFields(
				locale, AssetEntry.class.getName(), BlogsEntry.class.getName());

		infoDisplayFields.addAll(
			_expandoInfoDisplayFieldProvider.
				getContributorExpandoInfoDisplayFields(
					BlogsEntry.class.getName(), locale));

		return infoDisplayFields;
	}

	@Override
	public Map<String, Object> getInfoDisplayFieldsValues(
			BlogsEntry blogsEntry, Locale locale)
		throws PortalException {

		return HashMapBuilder.<String, Object>putAll(
			_assetEntryInfoDisplayFieldProvider.
				getAssetEntryInfoDisplayFieldsValues(
					BlogsEntry.class.getName(), blogsEntry.getEntryId(), locale)
		).putAll(
			_expandoInfoDisplayFieldProvider.
				getContributorExpandoInfoDisplayFieldsValues(
					BlogsEntry.class.getName(), blogsEntry, locale)
		).putAll(
			_infoDisplayFieldProvider.getContributorInfoDisplayFieldsValues(
				BlogsEntry.class.getName(), blogsEntry, locale)
		).build();
	}

	@Override
	public InfoDisplayObjectProvider<BlogsEntry> getInfoDisplayObjectProvider(
			long classPK)
		throws PortalException {

		BlogsEntry blogsEntry = _blogsEntryService.getEntry(classPK);

		if (blogsEntry.isDraft() || blogsEntry.isInTrash()) {
			return null;
		}

		return new BlogsInfoDisplayObjectProvider(blogsEntry);
	}

	@Override
	public InfoDisplayObjectProvider<BlogsEntry> getInfoDisplayObjectProvider(
			long groupId, String urlTitle)
		throws PortalException {

		BlogsEntry blogsEntry = _blogsEntryService.getEntry(groupId, urlTitle);

		if (blogsEntry.isInTrash()) {
			return null;
		}

		return new BlogsInfoDisplayObjectProvider(blogsEntry);
	}

	@Override
	public String getInfoURLSeparator() {
		return "/b/";
	}

	@Reference
	private AssetEntryInfoDisplayFieldProvider
		_assetEntryInfoDisplayFieldProvider;

	@Reference
	private BlogsEntryService _blogsEntryService;

	@Reference
	private ExpandoInfoDisplayFieldProvider _expandoInfoDisplayFieldProvider;

	@Reference
	private InfoDisplayFieldProvider _infoDisplayFieldProvider;

}