/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.relationship;

/**
 * @author Máté Thurzó
 */
public class Degree {

	public static Degree infinite() {
		return new Degree(Integer.MAX_VALUE);
	}

	public static Degree minusOne(Degree degree) {
		int degreeValue = degree.getDegree();

		if (degreeValue == 1) {
			throw new RuntimeException("Relationship degree cannot be 0");
		}

		return new Degree(degreeValue - 1);
	}

	public static Degree one() {
		return new Degree(1);
	}

	public static Degree parse(String string) {
		try {
			int degree = Integer.valueOf(string);

			if (degree <= 0) {
				throw new IllegalArgumentException(
					"Relationship degree cannot be 0 or less than 0");
			}

			return new Degree(degree);
		}
		catch (NumberFormatException numberFormatException) {
			return one();
		}
	}

	public static Degree two() {
		return new Degree(2);
	}

	public int getDegree() {
		return _degree;
	}

	private Degree(int degree) {
		_degree = degree;
	}

	private final int _degree;

}