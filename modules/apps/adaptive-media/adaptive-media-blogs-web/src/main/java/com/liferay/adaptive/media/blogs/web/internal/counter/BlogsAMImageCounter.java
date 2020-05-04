/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.blogs.web.internal.counter;

import com.liferay.adaptive.media.image.counter.AMImageCounter;
import com.liferay.adaptive.media.image.mime.type.AMImageMimeTypeProvider;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.service.ClassNameLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Sergio González
 */
@Component(
	immediate = true, property = "adaptive.media.key=blogs",
	service = AMImageCounter.class
)
public class BlogsAMImageCounter implements AMImageCounter {

	@Override
	public int countExpectedAMImageEntries(long companyId) {
		DynamicQuery dynamicQuery = _dlFileEntryLocalService.dynamicQuery();

		Property companyIdProperty = PropertyFactoryUtil.forName("companyId");

		dynamicQuery.add(companyIdProperty.eq(companyId));

		Property classNameIdProperty = PropertyFactoryUtil.forName(
			"classNameId");

		long classNameId = _classNameLocalService.getClassNameId(
			BlogsEntry.class.getName());

		dynamicQuery.add(classNameIdProperty.eq(classNameId));

		Property mimeTypeProperty = PropertyFactoryUtil.forName("mimeType");

		dynamicQuery.add(
			mimeTypeProperty.in(
				_amImageMimeTypeProvider.getSupportedMimeTypes()));

		return (int)_dlFileEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	@Reference
	private AMImageMimeTypeProvider _amImageMimeTypeProvider;

	@Reference
	private ClassNameLocalService _classNameLocalService;

	@Reference
	private DLFileEntryLocalService _dlFileEntryLocalService;

}