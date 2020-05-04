/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.xml;

import com.liferay.portal.kernel.xml.Comment;
import com.liferay.portal.kernel.xml.Visitor;

/**
 * @author Brian Wing Shun Chan
 */
public class CommentImpl extends NodeImpl implements Comment {

	public CommentImpl(org.dom4j.Comment comment) {
		super(comment);

		_comment = comment;
	}

	@Override
	public <T, V extends Visitor<T>> T accept(V visitor) {
		return visitor.visitComment(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommentImpl)) {
			return false;
		}

		CommentImpl commentImpl = (CommentImpl)obj;

		org.dom4j.Comment comment = commentImpl.getWrappedComment();

		return _comment.equals(comment);
	}

	public org.dom4j.Comment getWrappedComment() {
		return _comment;
	}

	@Override
	public int hashCode() {
		return _comment.hashCode();
	}

	@Override
	public String toString() {
		return _comment.toString();
	}

	private final org.dom4j.Comment _comment;

}