/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.json.transformer;

import com.liferay.portal.kernel.json.JSONContext;
import com.liferay.portal.kernel.repository.model.RepositoryModel;

/**
 * @author Igor Spasic
 */
public class RepositoryModelJSONTransformer extends ObjectTransformer {

	@Override
	public void transform(JSONContext jsonContext, Object object) {
		RepositoryModel<?> repositoryModel = (RepositoryModel<?>)object;

		super.transform(jsonContext, repositoryModel.getModel());
	}

}