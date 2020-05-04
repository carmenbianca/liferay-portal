/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.powwow.model.impl;

import com.liferay.portal.kernel.json.JSONFactoryUtil;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Shinn Lok
 */
public class PowwowMeetingImpl extends PowwowMeetingBaseImpl {

	public PowwowMeetingImpl() {
	}

	@Override
	public Map<String, Serializable> getProviderTypeMetadataMap() {
		if (_providerTypeMetadataMap != null) {
			return _providerTypeMetadataMap;
		}

		_providerTypeMetadataMap =
			(Map<String, Serializable>)JSONFactoryUtil.deserialize(
				getProviderTypeMetadata());

		return _providerTypeMetadataMap;
	}

	private Map<String, Serializable> _providerTypeMetadataMap;

}