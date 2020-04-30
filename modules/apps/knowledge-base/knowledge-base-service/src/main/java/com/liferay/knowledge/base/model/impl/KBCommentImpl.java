/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.model.impl;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.knowledge.base.model.KBComment;

/**
 * @author Peter Shin
 * @author Daniel Kocsis
 */
public class KBCommentImpl extends KBCommentBaseImpl {

	public KBCommentImpl() {
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(KBComment.class);
	}

}