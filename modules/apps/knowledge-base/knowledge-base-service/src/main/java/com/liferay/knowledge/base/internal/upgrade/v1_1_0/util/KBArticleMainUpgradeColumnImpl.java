/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.internal.upgrade.v1_1_0.util;

import com.liferay.knowledge.base.model.KBArticle;
import com.liferay.knowledge.base.service.KBArticleLocalServiceUtil;
import com.liferay.portal.kernel.upgrade.util.BaseUpgradeColumnImpl;
import com.liferay.portal.kernel.upgrade.util.UpgradeColumn;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

/**
 * @author Peter Shin
 */
public class KBArticleMainUpgradeColumnImpl extends BaseUpgradeColumnImpl {

	public KBArticleMainUpgradeColumnImpl(
		UpgradeColumn kbArticleIdColumn, UpgradeColumn resourcePrimKeyColumn) {

		super("main");

		_kbArticleIdColumn = kbArticleIdColumn;
		_resourcePrimKeyColumn = resourcePrimKeyColumn;
	}

	@Override
	public Object getNewValue(Object oldValue) throws Exception {
		Long resourcePrimKey = (Long)_resourcePrimKeyColumn.getOldValue();

		KBArticle kbArticle = KBArticleLocalServiceUtil.getLatestKBArticle(
			resourcePrimKey, WorkflowConstants.STATUS_ANY);

		if (kbArticle.isApproved()) {
			return Boolean.TRUE;
		}

		if (kbArticle.isFirstVersion()) {
			return Boolean.FALSE;
		}

		kbArticle = KBArticleLocalServiceUtil.getLatestKBArticle(
			resourcePrimKey, WorkflowConstants.STATUS_APPROVED);

		Long kbArticleId = (Long)_kbArticleIdColumn.getOldValue();

		if (kbArticle.getKbArticleId() != kbArticleId) {
			return Boolean.FALSE;
		}

		KBArticleAttachmentsUtil.updateAttachments(kbArticle);

		return Boolean.TRUE;
	}

	private final UpgradeColumn _kbArticleIdColumn;
	private final UpgradeColumn _resourcePrimKeyColumn;

}