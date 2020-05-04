/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.staged.model.repository;

import com.liferay.portal.kernel.model.StagedModel;

/**
 * @author Máté Thurzó
 */
public interface StagedModelRepositoryHelper {

	public <T extends StagedModel> T fetchMissingReference(
		String uuid, long groupId,
		StagedModelRepository<T> stagedModelRepository);

	public boolean isStagedModelInTrash(StagedModel stagedModel);

}