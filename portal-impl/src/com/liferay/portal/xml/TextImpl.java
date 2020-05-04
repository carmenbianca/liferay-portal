/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.xml;

import com.liferay.portal.kernel.xml.Text;
import com.liferay.portal.kernel.xml.Visitor;

/**
 * @author Brian Wing Shun Chan
 */
public class TextImpl extends NodeImpl implements Text {

	public TextImpl(org.dom4j.Text text) {
		super(text);

		_text = text;
	}

	@Override
	public <T, V extends Visitor<T>> T accept(V visitor) {
		return visitor.visitText(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TextImpl)) {
			return false;
		}

		TextImpl textImpl = (TextImpl)obj;

		org.dom4j.Text text = textImpl.getWrappedText();

		return _text.equals(text);
	}

	public org.dom4j.Text getWrappedText() {
		return _text;
	}

	@Override
	public int hashCode() {
		return _text.hashCode();
	}

	@Override
	public String toString() {
		return _text.toString();
	}

	private final org.dom4j.Text _text;

}