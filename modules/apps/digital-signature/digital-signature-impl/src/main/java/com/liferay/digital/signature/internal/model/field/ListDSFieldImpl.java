/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field;

import com.liferay.digital.signature.model.field.DSListItem;
import com.liferay.digital.signature.model.field.ListDSField;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael C. Han
 */
public class ListDSFieldImpl
	extends UserEntryDSFieldImpl<ListDSField> implements ListDSField {

	public ListDSFieldImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	public void addDSListItem(DSListItem dsListItem) {
		_dsListItems.add(dsListItem);
	}

	public void addDSListItems(List<DSListItem> dsListItems) {
		_dsListItems.addAll(dsListItems);
	}

	@Override
	public List<DSListItem> getDSListItems() {
		return _dsListItems;
	}

	@Override
	public Boolean getSenderRequired() {
		return _senderRequired;
	}

	public void setSenderRequired(Boolean senderRequired) {
		_senderRequired = senderRequired;
	}

	private List<DSListItem> _dsListItems = new ArrayList<>();
	private Boolean _senderRequired;

}