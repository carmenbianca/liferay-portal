/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.content.asset.addon.entry.comments.internal;

import com.liferay.journal.content.asset.addon.entry.ContentMetadataAssetAddonEntry;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.taglib.ui.BaseAssetAddonEntry;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

/**
 * @author Julio Camarero
 */
@Component(
	immediate = true,
	service = {
		CommentRatingsContentMetadataAssetAddonEntry.class,
		ContentMetadataAssetAddonEntry.class
	}
)
public class CommentRatingsContentMetadataAssetAddonEntry
	extends BaseAssetAddonEntry implements ContentMetadataAssetAddonEntry {

	@Override
	public String getIcon() {
		return "comments";
	}

	@Override
	public String getKey() {
		return "enableCommentRatings";
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, "comment-ratings");
	}

	@Override
	public Double getWeight() {
		return 4.0;
	}

}