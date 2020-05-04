/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.item.selector.criterion;

import com.liferay.item.selector.BaseItemSelectorCriterion;

/**
 * @author Iván Zaera
 * @author Roberto Díaz
 */
public class WikiAttachmentItemSelectorCriterion
	extends BaseItemSelectorCriterion {

	public WikiAttachmentItemSelectorCriterion() {
	}

	public WikiAttachmentItemSelectorCriterion(long wikiPageResourceId) {
		this(wikiPageResourceId, new String[0]);
	}

	public WikiAttachmentItemSelectorCriterion(
		long wikiPageResourceId, String[] mimeTypes) {

		_wikiPageResourceId = wikiPageResourceId;
		_mimeTypes = mimeTypes;
	}

	public String[] getMimeTypes() {
		return _mimeTypes;
	}

	public long getWikiPageResourceId() {
		return _wikiPageResourceId;
	}

	public void setMimeTypes(String[] mimeTypes) {
		_mimeTypes = mimeTypes;
	}

	public void setWikiPageResourceId(long wikiPageResourceId) {
		_wikiPageResourceId = wikiPageResourceId;
	}

	private String[] _mimeTypes;
	private long _wikiPageResourceId;

}