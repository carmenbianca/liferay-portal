/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.expando.model.impl;

import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ExpandoValue in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ExpandoValueCacheModel
	implements CacheModel<ExpandoValue>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExpandoValueCacheModel)) {
			return false;
		}

		ExpandoValueCacheModel expandoValueCacheModel =
			(ExpandoValueCacheModel)obj;

		if (valueId == expandoValueCacheModel.valueId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, valueId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{valueId=");
		sb.append(valueId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", tableId=");
		sb.append(tableId);
		sb.append(", columnId=");
		sb.append(columnId);
		sb.append(", rowId=");
		sb.append(rowId);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", data=");
		sb.append(data);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ExpandoValue toEntityModel() {
		ExpandoValueImpl expandoValueImpl = new ExpandoValueImpl();

		expandoValueImpl.setValueId(valueId);
		expandoValueImpl.setCompanyId(companyId);
		expandoValueImpl.setTableId(tableId);
		expandoValueImpl.setColumnId(columnId);
		expandoValueImpl.setRowId(rowId);
		expandoValueImpl.setClassNameId(classNameId);
		expandoValueImpl.setClassPK(classPK);

		if (data == null) {
			expandoValueImpl.setData("");
		}
		else {
			expandoValueImpl.setData(data);
		}

		expandoValueImpl.resetOriginalValues();

		return expandoValueImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		valueId = objectInput.readLong();

		companyId = objectInput.readLong();

		tableId = objectInput.readLong();

		columnId = objectInput.readLong();

		rowId = objectInput.readLong();

		classNameId = objectInput.readLong();

		classPK = objectInput.readLong();
		data = (String)objectInput.readObject();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(valueId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(tableId);

		objectOutput.writeLong(columnId);

		objectOutput.writeLong(rowId);

		objectOutput.writeLong(classNameId);

		objectOutput.writeLong(classPK);

		if (data == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(data);
		}
	}

	public long valueId;
	public long companyId;
	public long tableId;
	public long columnId;
	public long rowId;
	public long classNameId;
	public long classPK;
	public String data;

}