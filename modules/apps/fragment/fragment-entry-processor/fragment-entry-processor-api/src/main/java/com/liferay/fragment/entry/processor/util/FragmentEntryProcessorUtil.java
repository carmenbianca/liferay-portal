/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.entry.processor.util;

import aQute.bnd.annotation.ProviderType;

import com.liferay.fragment.processor.FragmentEntryProcessorContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.Locale;
import java.util.Map;

/**
 * @author     Eudaldo Alonso
 * @deprecated As of Mueller (7.2.x), replaced by {@link
 *             com.liferay.fragment.entry.processor.helper.FragmentEntryProcessorHelper}
 */
@Deprecated
@ProviderType
public interface FragmentEntryProcessorUtil {

	public String getEditableValue(
		JSONObject jsonObject, Locale locale, long[] segmentsExperienceIds);

	public Object getMappedValue(
			JSONObject jsonObject,
			Map<Long, Map<String, Object>> infoDisplaysFieldValues,
			FragmentEntryProcessorContext fragmentEntryProcessorContext)
		throws PortalException;

	public Object getMappedValue(
			JSONObject jsonObject,
			Map<Long, Map<String, Object>> infoDisplaysFieldValues, String mode,
			Locale locale, long previewClassPK, int previewType)
		throws PortalException;

	public boolean isAssetDisplayPage(String mode);

	public boolean isMapped(JSONObject jsonObject);

	public String processTemplate(
			String html,
			FragmentEntryProcessorContext fragmentEntryProcessorContext)
		throws PortalException;

}