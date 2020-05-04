/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser;

/**
 * @author Hugo Huijser
 */
public class Position implements Comparable<Position> {

	public Position(int lineNumber, int linePosition) {
		_lineNumber = lineNumber;
		_linePosition = linePosition;
	}

	@Override
	public int compareTo(Position position) {
		if (_lineNumber != position.getLineNumber()) {
			return _lineNumber - position.getLineNumber();
		}

		return _linePosition - position.getLinePosition();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Position)) {
			return false;
		}

		Position position = (Position)obj;

		if ((_lineNumber == position.getLineNumber()) &&
			(_linePosition == position.getLinePosition())) {

			return true;
		}

		return false;
	}

	public int getLineNumber() {
		return _lineNumber;
	}

	public int getLinePosition() {
		return _linePosition;
	}

	private final int _lineNumber;
	private final int _linePosition;

}