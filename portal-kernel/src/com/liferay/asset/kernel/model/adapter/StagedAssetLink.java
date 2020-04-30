/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel.model.adapter;

import com.liferay.asset.kernel.model.AssetLink;
import com.liferay.portal.kernel.model.StagedModel;

/**
 * @author Máté Thurzó
 */
public interface StagedAssetLink extends AssetLink, StagedModel {

	public String getEntry1ClassName();

	public String getEntry1Uuid();

	public String getEntry2ClassName();

	public String getEntry2Uuid();

}