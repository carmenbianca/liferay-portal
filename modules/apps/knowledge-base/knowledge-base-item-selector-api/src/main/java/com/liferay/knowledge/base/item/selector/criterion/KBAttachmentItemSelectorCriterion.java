/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.item.selector.criterion;

import com.liferay.item.selector.BaseItemSelectorCriterion;

/**
 * @author Roberto Díaz
 */
public class KBAttachmentItemSelectorCriterion
	extends BaseItemSelectorCriterion {

	public KBAttachmentItemSelectorCriterion() {
	}

	public KBAttachmentItemSelectorCriterion(long resourcePrimKey) {
		_resourcePrimKey = resourcePrimKey;
	}

	public long getResourcePrimKey() {
		return _resourcePrimKey;
	}

	public void setResourcePrimKey(long resourcePrimKey) {
		_resourcePrimKey = resourcePrimKey;
	}

	private long _resourcePrimKey;

}