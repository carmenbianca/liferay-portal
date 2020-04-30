/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field.builder;

import com.liferay.digital.signature.internal.model.field.DSListItemImpl;
import com.liferay.digital.signature.internal.model.field.ListDSFieldImpl;
import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.DSListItem;
import com.liferay.digital.signature.model.field.ListDSField;
import com.liferay.digital.signature.model.field.builder.ListDSFieldBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael C. Han
 */
public class ListDSFieldBuilderImpl
	extends UserEntryDSFieldBuilderImpl<ListDSField>
	implements ListDSFieldBuilder {

	public ListDSFieldBuilderImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public DSListItem addDSListItem(
		boolean selected, String text, String value) {

		DSListItem dsListItem = new DSListItemImpl(selected, text, value);

		_dsListItems.add(dsListItem);

		return dsListItem;
	}

	@Override
	public DSListItem addDSListItem(String text, String value) {
		return addDSListItem(false, text, value);
	}

	@Override
	public DSField<ListDSField> getDSField() {
		ListDSFieldImpl listDSFieldImpl = new ListDSFieldImpl(
			getDocumentKey(), getFieldKey(), getPageNumber()) {

			{
				addDSListItems(_dsListItems);
				setSenderRequired(_senderRequired);
			}
		};

		populateFields(listDSFieldImpl);

		return listDSFieldImpl;
	}

	@Override
	public ListDSFieldBuilder setSenderRequired(Boolean senderRequired) {
		_senderRequired = senderRequired;

		return this;
	}

	private List<DSListItem> _dsListItems = new ArrayList<>();
	private Boolean _senderRequired;

}