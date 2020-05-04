/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.content.targeting.upgrade.internal.v1_0_0.util;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.segments.criteria.Criteria;
import com.liferay.segments.criteria.contributor.SegmentsCriteriaContributor;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo García
 */
@Component(
	immediate = true, property = "rule.converter.key=PreviousVisitedSiteRule",
	service = RuleConverter.class
)
public class PreviousVisitedSiteRuleConverter implements RuleConverter {

	@Override
	public void convert(
		long companyId, Criteria criteria, String typeSettings) {

		try {
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray(typeSettings);

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);

				String value = jsonObject.getString("value");

				_contextSegmentsCriteriaContributor.contribute(
					criteria, "contains(referrerURL, '" + value + "')",
					Criteria.Conjunction.AND);
			}
		}
		catch (JSONException jsonException) {
			_log.error(
				"Unable to convert previous visited site rule with type " +
					"settings" + typeSettings,
				jsonException);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		PreviousVisitedSiteRuleConverter.class);

	@Reference(target = "(segments.criteria.contributor.key=context)")
	private SegmentsCriteriaContributor _contextSegmentsCriteriaContributor;

}